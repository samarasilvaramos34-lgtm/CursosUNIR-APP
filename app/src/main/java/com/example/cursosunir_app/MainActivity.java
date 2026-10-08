package com.example.cursosunir_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnVerCursos;
    private Spinner spinnerCampus;
    private RadioGroup radioGroupGrau;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        EdgeToEdge.enable( this );

        setContentView(R.layout.activity_main);


        btnVerCursos = findViewById(R.id.btnVerCursos);
        spinnerCampus = findViewById(R.id.spinnerCampus);
        radioGroupGrau = findViewById(R.id.radioGroupGrau);



        String opcoes[] = {"Porto Velho", "Vilhena", "Guajara-Mirim", "Cacoal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, opcoes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCampus.setAdapter(adapter);


        btnVerCursos.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this ,
                    ListaCursoActivity.class
            );

            startActivity(intent);

        });
    }


}

