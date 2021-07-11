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

    @SerializedName("description_seo")
    private String descriptionSEO;

    @SerializedName("specification")
    private Specification specification;

    @SerializedName("fund_manager")
    private FundManager manager;

    @SerializedName("profitabilities")
    private Profitabilities profitabilities;

    @SerializedName("operability")
    private Operability operability;

    @SerializedName("fees")
    private Fees fees;

    public Fundo(String nomeCompleto,
                 String nomeSimples,
                 String cnpj,
                 String descriptionSEO,
                 Specification specification,
                 FundManager manager,
                 Profitabilities profitabilities,
                 Operability operability,
                 Fees fees){
        this.nomeCompleto = nomeCompleto;
        this.nomeSimples = nomeSimples;
        this.cnpj = cnpj;
        this.descriptionSEO = descriptionSEO;
        this.specification =specification;
        this.manager = manager;
        this.profitabilities =profitabilities;
        this.operability = operability;
        this.fees = fees;
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

    public String getDescriptionSEO() {
        return descriptionSEO;
    }

    public void setDescriptionSEO(String descriptionSEO) {
        this.descriptionSEO = descriptionSEO;
    }

    public Specification getSpecification() {
        return specification;
    }

    public FundManager getManager() {
        return manager;
    }

    public void setManager(FundManager manager) {
        this.manager = manager;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Profitabilities getProfitabilities() {
        return profitabilities;
    }

    public void setProfitabilities(Profitabilities profitabilities) {
        this.profitabilities = profitabilities;
    }

    public Operability getOperability() {
        return operability;
    }

    public void setOperability(Operability operability) {
        this.operability = operability;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    protected Fundo(Parcel in) {
        this.nomeCompleto = in.readString();
        this.nomeSimples =  in.readString();
        this.cnpj =  in.readString();
        this.descriptionSEO =  in.readString();
        this.specification =new Specification(in);
        this.manager = new FundManager(in);
        this.profitabilities = new Profitabilities(in);
        this.operability = new Operability(in);
        this.fees = new Fees(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeCompleto );
        dest.writeString(nomeSimples );
        dest.writeString(cnpj );
        dest.writeString(descriptionSEO );
        this.specification.writeToParcel(dest,flags);
        this.manager.writeToParcel(dest,flags);
        this.profitabilities.writeToParcel(dest,flags);
        this.operability.writeToParcel(dest,flags);
        this.fees.writeToParcel(dest,flags);
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
