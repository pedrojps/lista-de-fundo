package com.example.listadeaplicaes.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Specification implements Parcelable {


    @SerializedName("fund_main_strategy_explanation")
    private String strategyExplanation;

    @SerializedName("fund_type")
    private String type;

    @SerializedName("fund_class")
    private String fundClass;

    @SerializedName("fund_main_strategy_name")
    private String mainStrategyName;

    @SerializedName("fund_class_anbima")
    private String classAnbima;

    public Specification(){}

    public String getClassAnbima() {
        return classAnbima;
    }

    public String getFundClass() {
        return fundClass;
    }

    public String getMainStrategyName() {
        return mainStrategyName;
    }

    public String getStrategyExplanation() {
        return strategyExplanation;
    }

    public String getType() {
        return type;
    }

    public void setMainStrategyName(String mainStrategyName) {
        this.mainStrategyName = mainStrategyName;
    }

    public void setClassAnbima(String classAnbima) {
        this.classAnbima = classAnbima;
    }

    public void setFundClass(String fundClass) {
        this.fundClass = fundClass;
    }

    public void setStrategyExplanation(String strategyExplanation) {
        this.strategyExplanation = strategyExplanation;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected Specification(Parcel in) {
    }

    public static final Creator<Specification> CREATOR = new Creator<Specification>() {
        @Override
        public Specification createFromParcel(Parcel in) {
            return new Specification(in);
        }

        @Override
        public Specification[] newArray(int size) {
            return new Specification[size];
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
