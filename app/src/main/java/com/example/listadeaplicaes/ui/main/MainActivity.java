package com.example.listadeaplicaes.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.listadeaplicaes.R;
import com.example.listadeaplicaes.common.adapter.HideFabOnScrollRecyclerViewListener;
import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.data.network.Status;
import com.example.listadeaplicaes.data.repository.FundoRepository;
import com.example.listadeaplicaes.databinding.ActivityMainBinding;
import com.example.listadeaplicaes.utils.DialogUtils;
import com.example.listadeaplicaes.utils.ObjectUtils;

import java.util.ArrayList;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;

public class MainActivity extends AppCompatActivity implements FlexibleAdapter.OnItemClickListener{

    private MainViewModel mViewModel;

    private FlexibleAdapter<FundoViewItem> mAdapter;

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = findOrCreateViewModel();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setVm(mViewModel);

        setupAdapter();
    }
    private void setupAdapter() {
        mAdapter = new FlexibleAdapter<>(new ArrayList<>(), this, true);

        FlexibleItemDecoration itemDecoration = new FlexibleItemDecoration(this)
                .withDefaultDivider(R.layout.item_fundo);

        mBinding.fundoList.setLayoutManager(new LinearLayoutManager(this));
        mBinding.fundoList.setAdapter(mAdapter);
        mBinding.fundoList.addItemDecoration(itemDecoration);

        subscribeItems();
    }




    private void subscribeItems() {
        mViewModel.getItems().observe(this, resource -> {
            mViewModel.dataLoading.set(resource.status == Status.LOADING);

            if (resource.status == Status.SUCCESS) {
                mViewModel.dataAvaliable.set(ObjectUtils.nonNull(resource.data) && !resource.data.isEmpty());
                mAdapter.updateDataSet(resource.data, true);
            } else if (resource.status == Status.ERROR) {
                mViewModel.dataAvaliable.set(false);
                DialogUtils.showDialog(this, resource.message.header, resource.message.body);
            }
        });
    }
    private MainViewModel findOrCreateViewModel() {
        MainViewModel.Factory factory = new MainViewModel.Factory(
                getApplication(),
                FundoRepository.getInstance()
        );
        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }


    @Override
    public boolean onItemClick(int position) {
        return false;
    }

}