package com.example.listadeaplicaes.ui.detalhes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.listadeaplicaes.R;
import com.example.listadeaplicaes.data.entities.Fundo;
import com.example.listadeaplicaes.databinding.ActivityDetalhesFundoBinding;

public class DetalhesActivity  extends AppCompatActivity {

    public static final int REQUEST_DETAIL_CODE = 8;

    public static final String EXTRA_FUNDO = "EXTRA_FUNDO";

    private ActivityDetalhesFundoBinding mBinding;

    private DetalhesViewModel mViewModel;

    public static Intent getStartIntent(Context context, Fundo fundo) {
        return new Intent(context, DetalhesActivity.class)
                .putExtra(EXTRA_FUNDO, fundo);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = findOrCreateViewModel();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detalhes_fundo);
        mBinding.setVm(mViewModel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private DetalhesViewModel findOrCreateViewModel() {
        Fundo fundo = (Fundo) getIntent().getExtras().get(EXTRA_FUNDO);

        DetalhesViewModel.Factory factory = new DetalhesViewModel.Factory(
                getApplication(),
                fundo
        );

        return ViewModelProviders.of(this, factory).get(DetalhesViewModel.class);
    }

}
