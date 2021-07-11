package com.example.listadeaplicaes.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.data.network.NetworkBoundResource;
import com.example.listadeaplicaes.data.network.Resource;
import com.example.listadeaplicaes.data.souce.FundoRemoteDataSource;
import com.google.common.base.Strings;

import java.util.List;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class FundoRepository {

    private static FundoRepository INSTANCE;

    private final FundoRemoteDataSource mFundoRemoteDataSource;


    private FundoRepository() {
        mFundoRemoteDataSource = FundoRemoteDataSource.getInstance();
    }

    public static synchronized FundoRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FundoRepository();
        }
        return INSTANCE;
    }

    public void clearInstance() {
        INSTANCE = null;
    }


    public Single<Resource<List<Fundo>>> getAllFundos2() {
        return mFundoRemoteDataSource.getAllFundos();
    }


  /*  public Flowable<Resource<List<Fundo>>> getAllFundos() {
        return Flowable.create(e -> new NetworkBoundResource<List<Fundo>, List<Fundo>>(e) {
            @Override
            public Completable saveCallResult(@NonNull List<Fundo> data) {
                return Completable.fromAction(() -> {});
            }

            @Override
            public Single<List<Fundo>> createCall() {
                return mFundoRemoteDataSource.getAllFundos().map(e -> e.body());
            }

            @Override
            public Flowable<List<Fundo>> loadFromDb() {
                return null;
            }

            @Override
            public boolean shouldFetch(@Nullable List<Fundo> data) {
                return false;
            }

            @Override
            public Function<List<Fundo>, List<Fundo>> mapper() {
                return equipamentos -> {
                    return equipamentos;
                };
            }
        }, BackpressureStrategy.BUFFER);
    }
*/

}
