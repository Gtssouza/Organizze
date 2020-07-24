package com.example.organizze.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.organizze.R;
import com.example.organizze.activity.helper.DataUtil;
import com.google.android.material.textfield.TextInputEditText;

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, camporDescricao;
    private EditText campoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);
        campoData = findViewById(R.id.txtInpitDespesaData);
        campoCategoria = findViewById(R.id.txtInputDespesaTipo);
        camporDescricao = findViewById(R.id.textInputDespesaDescricao);
        campoValor = findViewById(R.id.editTextDespesaValor);

        //Preenche o campo data com a data atual
        campoData.setText(DataUtil.dataAtual());
    }
}