package com.example.listadeaplicaes.ui.detalhes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.listadeaplicaes.common.time.LocalDate;
import com.example.listadeaplicaes.common.time.LocalDateFormat;
import com.example.listadeaplicaes.data.entities.Fundo;

import java.util.Date;

public class DetalhesViewModel  extends AndroidViewModel {

    private final Fundo fundo;
    public ObservableField<String> nome = new ObservableField<>();

    public ObservableField<String> strategName = new ObservableField<>();

    public ObservableField<String> strateType = new ObservableField<>();

    public ObservableField<String> rendintoMes = new ObservableField<>();

    public ObservableField<String> rendintoAno = new ObservableField<>();

    public ObservableField<String> rendinto12M = new ObservableField<>();

    public ObservableField<String> prazoCotizacaoResgate = new ObservableField<>();

    public ObservableField<String> aplicacaoMinimaInit = new ObservableField<>();

    public ObservableField<String> aplicacaoMinimaAdicional = new ObservableField<>();

    public ObservableField<String> diasConversaoAplicacao = new ObservableField<>();

    public ObservableField<String> horarioAplicacao = new ObservableField<>();

    public ObservableField<String> minimoResgate = new ObservableField<>();

    public ObservableField<String> minimoPermanence = new ObservableField<>();

    public ObservableField<String> diasConversaoResgate = new ObservableField<>();

    public ObservableField<String> diasConversaoResgateAntecipa = new ObservableField<>();

    public ObservableField<String> diasPagamentoResgate = new ObservableField<>();

    public ObservableField<String> horarioResgate = new ObservableField<>();

    public ObservableField<String> administracao = new ObservableField<>();
    public ObservableField<String> administracaoMax = new ObservableField<>();
    public ObservableField<String> perfomance = new ObservableField<>();
    public ObservableField<String> resgateAntecipado = new ObservableField<>();

    public ObservableField<String> ano = new ObservableField<>();

    public ObservableBoolean regraAplicacao = new ObservableBoolean(true);

    public ObservableBoolean regraResgate = new ObservableBoolean(false);

    public ObservableBoolean regraCusto = new ObservableBoolean(false);

    public DetalhesViewModel(
            @NonNull Application application,
            Fundo fundo
    ) {
        super(application);
        this.fundo=fundo;
        nome.set(fundo.getNomeCompleto());
        strategName.set(fundo.getSpecification().getMainStrategyName());
        strateType.set(fundo.getSpecification().getType());
        rendintoMes.set(fundo.getProfitabilities().getMonth()+"");
        rendintoAno.set(fundo.getProfitabilities().getYear()+"");
        rendinto12M.set(fundo.getProfitabilities().getM12()==0.00? fundo.getProfitabilities().getM12()+"":"--");
        prazoCotizacaoResgate.set(fundo.getOperability().getRetrievalConversaoDays());
        aplicacaoMinimaInit.set(fundo.getOperability().getInitialApplicationAmount());
        aplicacaoMinimaAdicional.set(fundo.getOperability().getMinimumAdicaionSubseque());
        diasConversaoAplicacao.set(fundo.getOperability().getDiasConversaoAplicacao());
        horarioAplicacao.set(fundo.getOperability().getAplicacaoHorario());
        minimoResgate.set(fundo.getOperability().getMinimumSubsequentRetrieval());
        minimoPermanence.set(fundo.getOperability().getMinimoPermane());
        diasConversaoResgate.set(fundo.getOperability().getRetrievalConversaoDays());
        diasConversaoResgateAntecipa.set(fundo.getOperability().getRetrievalConversaoAntecipaDays());
        diasPagamentoResgate.set(fundo.getOperability().getRetrievalLiquidationDays());
        horarioResgate.set(fundo.getOperability().getRetiradaHorario());

        administracao.set(fundo.getFees().getAdiministracao());
        administracaoMax.set(fundo.getFees().getAdiministracaoMax());
        perfomance.set(fundo.getFees().getPerformance());
        resgateAntecipado.set(fundo.getFees().getAnticipatedRetrieval());

        ano.set(new LocalDate().toString(LocalDateFormat.SQLITE_DATE).substring(0,4));

    }

    public void regraAplicacaoShow() {
        regraAplicacao.set(!regraAplicacao.get());
    }

    public void regraResgateShow() {
        regraResgate.set(!regraResgate.get());
    }

    public void RegraCustoShow() {
        regraCusto.set(!regraCusto.get());
    }

    public static class Factory implements ViewModelProvider.Factory {

        private final Application mApplication;

        private final Fundo mFundo;

        public Factory(
                @NonNull Application application,
                Fundo fundo) {
            mApplication = application;
            mFundo =fundo;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new DetalhesViewModel(mApplication, mFundo);
        }
    }

}
