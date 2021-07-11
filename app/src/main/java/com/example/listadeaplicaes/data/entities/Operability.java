package com.example.listadeaplicaes.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Operability implements Parcelable {


    @SerializedName("minimum_initial_application_amount")
    private String initialApplicationAmount;

    @SerializedName("minimum_subsequent_retrieval_amount")
    private String minimumSubsequentRetrieval;

    @SerializedName("retrieval_liquidation_days_str")
    private String retrievalLiquidationDays;

    public Operability(){}

    public String getInitialApplicationAmount() {
        return initialApplicationAmount;
    }

    public void setInitialApplicationAmount(String initialApplicationAmount) {
        this.initialApplicationAmount = initialApplicationAmount;
    }

    public String getRetrievalLiquidationDays() {
        return retrievalLiquidationDays;
    }

    public void setRetrievalLiquidationDays(String retrievalLiquidationDays) {
        this.retrievalLiquidationDays = retrievalLiquidationDays;
    }

    public String getMinimumSubsequentRetrieval() {
        return minimumSubsequentRetrieval;
    }

    public void setMinimumSubsequentRetrieval(String minimumSubsequentRetrieval) {
        this.minimumSubsequentRetrieval = minimumSubsequentRetrieval;
    }

    protected Operability(Parcel in) {
    }

    public static final Creator<Operability> CREATOR = new Creator<Operability>() {
        @Override
        public Operability createFromParcel(Parcel in) {
            return new Operability(in);
        }

        @Override
        public Operability[] newArray(int size) {
            return new Operability[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
