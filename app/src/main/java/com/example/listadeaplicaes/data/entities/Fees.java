package com.example.listadeaplicaes.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Fees implements Parcelable{

    @SerializedName("administration_fee")
    private String adiministracao;

    @SerializedName("maximum_administration_fee")
    private String adiministracaoMax;

    @SerializedName("performance_fee")
    private String performance;

    @SerializedName("anticipated_retrieval_fee")
    private String anticipatedRetrieval;

    public Fees(){}

    public String getAnticipatedRetrieval() {
        return anticipatedRetrieval;
    }

    public void setAnticipatedRetrieval(String anticipatedRetrieval) {
        this.anticipatedRetrieval = anticipatedRetrieval;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getAdiministracaoMax() {
        return adiministracaoMax;
    }

    public void setAdiministracaoMax(String adiministracaoMax) {
        this.adiministracaoMax = adiministracaoMax;
    }

    public String getAdiministracao() {
        return adiministracao;
    }

    public void setAdiministracao(String adiministracao) {
        this.adiministracao = adiministracao;
    }

    protected Fees(Parcel in) {
        adiministracao = in.readString();
        adiministracaoMax = in.readString();
        performance = in.readString();
        anticipatedRetrieval = in.readString();
    }

    public static final Creator<Fees> CREATOR = new Creator<Fees>() {
        @Override
        public Fees createFromParcel(Parcel in) {
            return new Fees(in);
        }

        @Override
        public Fees[] newArray(int size) {
            return new Fees[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adiministracao);
        dest.writeString(adiministracaoMax);
        dest.writeString(performance);
        dest.writeString(anticipatedRetrieval);
    }
}
