package com.example.listadeaplicaes.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.listadeaplicaes.utils.MathUtils;
import com.google.gson.annotations.SerializedName;

public class Profitabilities   implements Parcelable {


    @SerializedName("m12")
    private Double m12;

    @SerializedName("year")
    private Double year;

    @SerializedName("day")
    private Double day;

    public Profitabilities(){}

    public Double getDay() {
        return day;
    }

    public Double getM12() {
        if(m12==null)
            return 0.00;
        return MathUtils.round( m12*100,2);
    }

    public Double getYear() {
        return year;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public void setM12(Double m12) {
        this.m12 = m12;
    }

    public void setYear(Double year) {
        this.year = year;
    }

    protected Profitabilities(Parcel in) {
    }

    public static final Creator<Profitabilities> CREATOR = new Creator<Profitabilities>() {
        @Override
        public Profitabilities createFromParcel(Parcel in) {
            return new Profitabilities(in);
        }

        @Override
        public Profitabilities[] newArray(int size) {
            return new Profitabilities[size];
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
