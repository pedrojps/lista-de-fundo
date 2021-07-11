package com.example.listadeaplicaes.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class FundManager  implements Parcelable {

    @SerializedName("description")
    private String description;

    @SerializedName("full_name")
    private String full_name;

    @SerializedName("logo")
    private String logo;


    @SerializedName("name")
    private String name;

    public FundManager(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    protected FundManager(Parcel in) {
    }

    public static final Creator<FundManager> CREATOR = new Creator<FundManager>() {
        @Override
        public FundManager createFromParcel(Parcel in) {
            return new FundManager(in);
        }

        @Override
        public FundManager[] newArray(int size) {
            return new FundManager[size];
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
