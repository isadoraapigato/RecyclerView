package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {
    EditText campoNome, campoTipo, campoPreco;
    Button btn;
    static ArrayList<Produto> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        campoNome = findViewById(R.id.campoNome);
        campoTipo = findViewById(R.id.campoTipo);
        campoPreco = findViewById(R.id.campoPreco);
        btn = findViewById(R.id.btnCadastrarProduto);
    }

    public boolean verificarCampos(){
        if(campoNome.getText().toString().isEmpty() || campoTipo.getText().toString().isEmpty() || campoPreco.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    public void cadastrar(View v) {
        if(verificarCampos()){
            String infoNome = campoNome.getText().toString();
            String infoTipo = campoTipo.getText().toString();
            float infoPreco = Float.parseFloat(campoPreco.getText().toString());

            Produto p = new Produto (infoNome, infoTipo, infoPreco);
            listaProdutos.add(p);
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Favor preencher todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }
}