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


    @SerializedName("month")
    private Double month;


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
        if(year==null)
            return 0.00;
        return MathUtils.round( year*100,2);
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

    public Double getMonth() {
        if(month==null)
            return 0.00;
        return MathUtils.round( month*100,2);
    }

    public void setMonth(Double month) {
        this.month = month;
    }

    protected Profitabilities(Parcel in) {
        m12 = in.readDouble();
        year = in.readDouble();
        day = in.readDouble();
        month = in.readDouble();
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
        if(m12==null)
            dest.writeDouble(0.00);
        else
            dest.writeDouble(m12);
        dest.writeDouble(year);
        dest.writeDouble(day);
        dest.writeDouble(month);
    }
}
