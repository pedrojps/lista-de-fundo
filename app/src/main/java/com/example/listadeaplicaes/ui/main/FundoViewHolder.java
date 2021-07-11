package com.example.listadeaplicaes.ui.main;

import android.view.View;

import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.databinding.ItemFundoBinding;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

public class FundoViewHolder extends FlexibleViewHolder {

    private final ItemFundoBinding mBinding;

    public FundoViewHolder(ItemFundoBinding binding, FlexibleAdapter adapter) {
        super(binding.getRoot(), adapter);
        mBinding = binding;
    }

    public void bind(Fundo item) {
        mBinding.setVm(item);
    }

}
