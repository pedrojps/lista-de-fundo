package com.example.listadeaplicaes.data.network.service;

import com.example.listadeaplicaes.data.entities.Fundo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FundoService {

    @GET("orama-media/json/fund_detail_full.json?serializ%20er=fund_detail_full")
    Single<Response<List<Fundo>>> getAllFundos();
}
