package com.example.cursosunir_app;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaCursoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CursoAdapter adapter;
    private List<Curso> listaCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_curso_main2);

        recyclerView = findViewById(R.id.recyclerView);

        listaCursos = CursoData.getCursos();

        adapter = new CursoAdapter(listaCursos, curso -> {

            Intent intent = new Intent(
                    ListaCursoActivity.this,
                    DetalhesActivity2.class
            );

            intent.putExtra("nome", curso.getNome());
            intent.putExtra("campus", curso.getCampus());
            intent.putExtra("grau", curso.getGrau());
            intent.putExtra("turno", curso.getTurno());
            intent.putExtra("imagem", curso.getImagem());
            intent.putExtra("descricao", curso.getDescricao());

            startActivity(intent);
        });

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setAdapter(adapter);
    }
}