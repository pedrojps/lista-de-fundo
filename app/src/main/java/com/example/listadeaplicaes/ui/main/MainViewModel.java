package com.example.listadeaplicaes.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.listadeaplicaes.R;
import com.example.listadeaplicaes.common.lifecycle.ErrorDialogMessage;
import com.example.listadeaplicaes.common.lifecycle.SimpleDialogMessage;
import com.example.listadeaplicaes.common.lifecycle.SingleLiveEvent;
import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.data.network.Resource;
import com.example.listadeaplicaes.data.repository.FundoRepository;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {

    private final FundoRepository mFundoRepository;

    public final ObservableBoolean dataLoading = new ObservableBoolean(false);

    public final ObservableBoolean dataAvaliable = new ObservableBoolean(false);

    public final ObservableField<String> filteringText = new ObservableField<>();

    private final MutableLiveData<String> mFilterConstraint = new MutableLiveData<>();

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private LiveData<Resource<List<FundoViewItem>>> mItems;

    public MainViewModel(@NonNull Application application,@NonNull FundoRepository fundoRepository) {
        super(application);
        mFundoRepository=fundoRepository;
        loadFundos();
        setupObservables();
    }

    public LiveData<Resource<List<FundoViewItem>>> getItems() {
        return mItems;
    }

    private void loadFundos() {
        mItems = LiveDataReactiveStreams.fromPublisher(getEquipesPublisher()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()));
    }

    private Flowable<Resource<List<FundoViewItem>>> getEquipesPublisher() {
        return Flowable.create(e -> {
            e.onNext(Resource.loading(null));

            Disposable disposable = mFundoRepository.getAllFundos2()
                    .observeOn(Schedulers.computation())
                    .map(this::sortAndMapToFlexibleItem)
                    .map(Resource::success)
                    .onErrorReturn(Resource::error)
                    .subscribe(e::onNext);
            addDisposable(disposable);
        }, BackpressureStrategy.BUFFER);
    }
    private List<FundoViewItem> sortAndMapToFlexibleItem(Resource<List<Fundo>> equipes){
        List<Fundo> sortedList =new ArrayList<>();
        if(equipes.data!=null)
            sortedList = new ArrayList<>(equipes.data);
        Collections.sort(sortedList, this::sortByEquipeNameAsc);
        return Lists.transform(sortedList, FundoViewItem::new);
    }

    private int sortByEquipeNameAsc(Fundo e1, Fundo e2) {
        return e1.getNomeCompleto().compareTo( e2.getNomeCompleto());
    }

    private void setupObservables() {
        filteringText.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                setFilterConstraint(filteringText.get());
            }
        });
    }

    private void setFilterConstraint(String text) {
        mFilterConstraint.setValue(text);
    }

    public LiveData<String> getFilterConstraint() {
        return mFilterConstraint;
    }

    private void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
    }

    public static class Factory implements ViewModelProvider.Factory {

        private final Application mApplication;

        private final FundoRepository mFundoRepository;

        public Factory(
                @NonNull Application application,
                @NonNull FundoRepository fundoRepository
        ) {
            mApplication = application;
            mFundoRepository = fundoRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new MainViewModel(mApplication,mFundoRepository);
        }
    }
}
