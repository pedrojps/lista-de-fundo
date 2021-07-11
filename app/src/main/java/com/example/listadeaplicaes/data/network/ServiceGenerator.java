package com.example.listadeaplicaes.data.network;

import android.text.TextUtils;

import com.example.listadeaplicaes.common.time.DateTime;
import com.example.listadeaplicaes.common.time.LocalDate;
import com.example.listadeaplicaes.common.time.LocalTime;
import com.example.listadeaplicaes.data.network.serializer.GsonDataTimeSerializer;
import com.example.listadeaplicaes.data.network.serializer.GsonDateDeserializer;
import com.example.listadeaplicaes.data.network.serializer.GsonLocalDateSerializer;
import com.example.listadeaplicaes.data.network.serializer.GsonLocalTimeSerializer;
import com.example.listadeaplicaes.data.network.serializer.ResourceMessageDeserializer;
import com.example.listadeaplicaes.data.network.serializer.ResourceStatusDeserializer;
import com.example.listadeaplicaes.data.network.typeAdapterFactory.ServerResponseTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final long CONNECT_TIMEOUT_IN_SECONDS = 30L;

    private static final long WRITE_TIMEOUT_IN_SECONDS = 50L;

    private static final long READ_TIMEOUT_IN_SECONDS = 40L;

    private final static OkHttpClient.Builder httpClient;

    static {


        httpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
    }

    //Retrofit2 OkHttp Url
    public static <T> T createService(Class<T> serviceClass, HttpUrl url) {
        Gson gson = getGsonInstance();
        return new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(serviceClass);
    }

    public static Gson getGsonInstance(){
        return new GsonBuilder()
                .registerTypeAdapterFactory(new ServerResponseTypeAdapterFactory())
                .registerTypeAdapter(Status.class, new ResourceStatusDeserializer())
                .registerTypeAdapter(Message.class, new ResourceMessageDeserializer())
                .registerTypeAdapter(LocalDate.class, new GsonLocalDateSerializer())
                .registerTypeAdapter(LocalTime.class, new GsonLocalTimeSerializer())
                .registerTypeAdapter(Date.class, new GsonDateDeserializer())
                .registerTypeAdapter(DateTime.class, new GsonDataTimeSerializer())
                .create();
    }
}
