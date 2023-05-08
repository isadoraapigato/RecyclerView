package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    RecyclerView recycler;
    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
//        cadastroInicial();
        adaptador = new Adaptador(this, listaProdutos, new Adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Produto p) {
                Toast.makeText(MainActivity.this, p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
    }

    public void cadastrarProduto(View v) {
        Intent i = new Intent(this, Cadastro.class);
        startActivity(i);
        Cadastro.listaProdutos = listaProdutos;
    }

    public void cadastroInicial() {
        Produto p1 = new Produto("Arroz", "Alimento", (float) 15.99);
        Produto p2 = new Produto("Feijão", "Alimento", (float) 18.99);
        Produto p3 = new Produto("Batata frita", "Alimento", (float) 12.99);
        Produto p4 = new Produto("Papel higiênico", "Item de higiene", (float) 32.99);
        Produto p5 = new Produto("Pasta de dente", "Item de higiene", (float) 1.35);
        Produto p6 = new Produto("Geladeira Consul Frost Free Duplex 386 litros com Altura Flex cor  Inox  CRM44AK", "Eletrodoméstico", (float) 3050.10);
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);
        listaProdutos.add(p6);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adaptador.notifyDataSetChanged();
    }
}
