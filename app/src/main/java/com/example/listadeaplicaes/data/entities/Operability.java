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

    @SerializedName("retrieval_quotation_days_str")
    private String retrievalConversaoDays;

    @SerializedName("anticipated_retrieval_quotation_days_str")
    private String retrievalConversaoAntecipaDays;

    @SerializedName("minimum_subsequent_application_amount")
    private String minimumAdicaionSubseque;

    @SerializedName("application_quotation_days_str")
    private String diasConversaoAplicacao;

    @SerializedName("application_time_limit")
    private String aplicacaoHorario;

    @SerializedName("retrieval_time_limit")
    private String retiradaHorario;

    @SerializedName("minimum_balance_permanence")
    private String minimoPermane;

    public Operability(){}

    public String getRetiradaHorario() {
        return retiradaHorario;
    }

    public void setRetiradaHorario(String retiradaHorario) {
        this.retiradaHorario = retiradaHorario;
    }

    public String getRetrievalConversaoAntecipaDays() {
        return retrievalConversaoAntecipaDays;
    }

    public void setRetrievalConversaoAntecipaDays(String retrievalConversaoAntecipaDays) {
        this.retrievalConversaoAntecipaDays = retrievalConversaoAntecipaDays;
    }

    public String getRetrievalConversaoDays() {
        return retrievalConversaoDays;
    }

    public void setRetrievalConversaoDays(String retrievalConversaoDays) {
        this.retrievalConversaoDays = retrievalConversaoDays;
    }

    public String getMinimoPermane() {
        return minimoPermane;
    }

    public void setMinimoPermane(String minimoPermane) {
        this.minimoPermane = minimoPermane;
    }

    public String getAplicacaoHorario() {
        return aplicacaoHorario;
    }

    public void setAplicacaoHorario(String aplicacaoHorario) {
        this.aplicacaoHorario = aplicacaoHorario;
    }

    public String getDiasConversaoAplicacao() {
        return diasConversaoAplicacao;
    }

    public void setDiasConversaoAplicacao(String diasConversaoAplicacao) {
        this.diasConversaoAplicacao = diasConversaoAplicacao;
    }

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

    public String getMinimumAdicaionSubseque() {
        return minimumAdicaionSubseque;
    }

    public void setMinimumAdicaionSubseque(String minimumAdicaionSubseque) {
        this.minimumAdicaionSubseque = minimumAdicaionSubseque;
    }

    protected Operability(Parcel in) {
        initialApplicationAmount = in.readString();
        minimumSubsequentRetrieval = in.readString();
        retrievalLiquidationDays = in.readString();

        retrievalConversaoDays=in.readString();
        retrievalConversaoAntecipaDays=in.readString();
        minimumAdicaionSubseque=in.readString();
        diasConversaoAplicacao=in.readString();
        aplicacaoHorario=in.readString();
        retiradaHorario=in.readString();
        minimoPermane=in.readString();

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
        dest.writeString(initialApplicationAmount);
        dest.writeString(minimumSubsequentRetrieval);
        dest.writeString(retrievalLiquidationDays);

        dest.writeString(retrievalConversaoDays);
        dest.writeString(retrievalConversaoAntecipaDays);
        dest.writeString(minimumAdicaionSubseque);
        dest.writeString(diasConversaoAplicacao);
        dest.writeString(aplicacaoHorario);
        dest.writeString(retiradaHorario);
        dest.writeString(minimoPermane);

    }
}
