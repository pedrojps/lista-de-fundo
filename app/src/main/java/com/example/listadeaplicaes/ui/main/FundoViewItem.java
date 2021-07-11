package com.example.listadeaplicaes.ui.main;

import android.view.View;


import androidx.databinding.DataBindingUtil;

import com.example.listadeaplicaes.R;
import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.databinding.ItemFundoBinding;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFilterable;

public class FundoViewItem extends AbstractFlexibleItem<FundoViewHolder> implements IFilterable {

    private final Fundo mFundo;

    public FundoViewItem(Fundo fundo) {
        mFundo = fundo;
    }

    public Fundo getModel(){
        return mFundo;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        return mFundo.equals(o);
    }

    @Override
    public int hashCode() {
        return mFundo.hashCode();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_fundo;
    }

    @Override
    public FundoViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        ItemFundoBinding binding = DataBindingUtil.bind(view);
        return new FundoViewHolder(binding, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, FundoViewHolder holder, int position, List payloads) {
        holder.bind(mFundo);
    }

    @Override
    public boolean filter(String constraint) {
        String word;
        word = constraint.toLowerCase();

        return mFundo.getNomeCompleto().contains(word);
    }
}
