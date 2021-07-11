package com.example.listadeaplicaes.common.adapter;

import android.widget.Spinner;

public interface MutableSpinnerAdapter<T> extends MutableAdapter<T>{

    void setItemSelected(Spinner spinner, T item);
}
