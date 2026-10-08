package com.example.cursosunir_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class DetalhesActivity2 extends AppCompatActivity {

    private ImageView imgeDetalhe;
    private TextView textNomeDetalhe;
    private TextView textCampusDetalhe;
    private TextView textGrauDetalhe;
    private TextView textTurnoDetalhe;
    private TextView textDescricaoDetalhe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes2);
        imgeDetalhe = findViewById(R.id.imageDetalhes);
        textNomeDetalhe = findViewById(R.id.textNomeDetalhes);
        textCampusDetalhe = findViewById(R.id.textCampusDetalhes);
        textGrauDetalhe = findViewById(R.id.textGrauDetalhes);
        textTurnoDetalhe = findViewById(R.id.textTurnoDetalhes);
        textDescricaoDetalhe = findViewById(R.id.textDescricaoDetalhes);

        String nome = getIntent().getStringExtra("nome");
        String campus = getIntent().getStringExtra("campus");
        String grau = getIntent().getStringExtra("grau");
        String turno = getIntent().getStringExtra("turno");
        String descricao = getIntent().getStringExtra("descricao");
        String imagem = getIntent().getStringExtra("imagem");


        textNomeDetalhe.setText(nome);
        textCampusDetalhe.setText("Campus: " + campus);
        textGrauDetalhe.setText("Grau: " + grau);
        textTurnoDetalhe.setText("Turno:" + turno);
        textDescricaoDetalhe.setText(descricao);

        Glide.with(this)
               .load(imagem)
              .into(imgeDetalhe);

    }
}