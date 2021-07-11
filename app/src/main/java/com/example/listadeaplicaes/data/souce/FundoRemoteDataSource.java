package com.example.listadeaplicaes.data.souce;

import androidx.annotation.NonNull;

import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.data.network.Resource;
import com.example.listadeaplicaes.data.network.service.FundoService;
import com.google.common.net.HostAndPort;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;

public class FundoRemoteDataSource extends BaseRemoteDataSource{
    private static FundoRemoteDataSource INSTANCE;

    private FundoRemoteDataSource( ) {}

    public static synchronized FundoRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FundoRemoteDataSource();
        }
        return INSTANCE;
    }

    public void clearInstance() {
        INSTANCE = null;
    }

    public Single<Resource<List<Fundo>>> getAllFundos() {
        FundoService mainService;

        mainService = getMainService(FundoService.class,"s3.amazonaws.com");

        return mainService.getAllFundos()
                .observeOn(Schedulers.computation())
                .onErrorReturn(this::wrapInErrorResponse)
                .map(this::proccessResponse);
    }
}
