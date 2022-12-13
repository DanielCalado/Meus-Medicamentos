package com.example.myapplication.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Alarme;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Context context;
    private ArrayList<Alarme> itens;

    public RecyclerViewAdapter(Context context, ArrayList<Alarme> itens) {
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recycler_view, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Alarme alarme = itens.get(position);
        holder.id.setText(alarme.getId());
        holder.nomeMedicamento.setText(alarme.getNomeMedicamento());
        holder.dataFinal.setText(alarme.getDataFinal());
        holder.horarios.setText(alarme.getHorarioSelecionado());

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
