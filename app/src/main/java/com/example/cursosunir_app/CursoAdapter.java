package com.example.cursosunir_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;

import java.util.List;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.CursoViewHolder> {

    private List<Curso> lista;
    private OnCursoClickListener listener;

    public interface OnCursoClickListener {
        void onCursoClick(Curso curso);
    }

    public CursoAdapter(List<Curso> lista, OnCursoClickListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itens, parent, false);

        return new CursoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoViewHolder holder, int position) {

        Curso curso = lista.get(position);

        holder.textNome.setText(curso.getNome());
        holder.textCampus.setText(curso.getCampus());
        holder.textGrau.setText(curso.getGrau());

        Glide.with(holder.itemView.getContext())
                .load(curso.getImagem())
                .into(holder.imageCurso);

        // Clique normal
        holder.itemView.setOnClickListener(v -> {

            if (listener != null) {
                listener.onCursoClick(curso);
            }

        });


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class CursoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCurso;
        TextView textNome;
        TextView textCampus;
        TextView textGrau;

       public CursoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCurso = itemView.findViewById(R.id.imageCurso);
            textNome = itemView.findViewById(R.id.textNomeCurso);
            textCampus = itemView.findViewById(R.id.textCampus);
            textGrau= itemView.findViewById(R.id.textGrau);
        }
    }
}