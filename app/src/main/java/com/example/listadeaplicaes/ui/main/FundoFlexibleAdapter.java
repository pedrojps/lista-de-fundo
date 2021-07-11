package com.example.listadeaplicaes.ui.main;


import androidx.annotation.Nullable;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;

public class FundoFlexibleAdapter extends FlexibleAdapter<FundoViewItem> {

    public FundoFlexibleAdapter(@Nullable List<FundoViewItem> items, @Nullable Object listeners) {
        super(items, listeners, true);
    }

    @Override
    public String onCreateBubbleText(int position) {
        FundoViewItem item = getItem(position);

        if(item != null){
            return item.getModel().getNomeCompleto().substring(0, 1).toUpperCase();
        }else{
            return "";
        }
    }
}
