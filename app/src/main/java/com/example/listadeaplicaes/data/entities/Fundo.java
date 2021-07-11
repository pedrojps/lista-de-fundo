package com.example.listadeaplicaes.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Fundo implements Parcelable {

    @SerializedName("full_name")
    private String nomeCompleto;

    @SerializedName("simple_name")
    private String nomeSimples;

    @SerializedName("cnpj")
    private String cnpj;

    public Fundo(String nomeCompleto,String nomeSimples,String cnpj){
        this.nomeCompleto = nomeCompleto;
        this.nomeSimples = nomeSimples;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setNomeSimples(String nomeSimples) {
        this.nomeSimples = nomeSimples;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getNomeSimples() {
        return nomeSimples;
    }

    protected Fundo(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Fundo> CREATOR = new Creator<Fundo>() {
        @Override
        public Fundo createFromParcel(Parcel in) {
            return new Fundo(in);
        }

        @Override
        public Fundo[] newArray(int size) {
            return new Fundo[size];
        }
    };
}
