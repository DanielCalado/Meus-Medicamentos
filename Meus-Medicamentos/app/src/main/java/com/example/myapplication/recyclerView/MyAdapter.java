package com.example.myapplication.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Alarme;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Alarme> list;

    public MyAdapter(Context context, ArrayList<Alarme> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recycler_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Alarme alarme = list.get(position);
        holder.id.setText(alarme.getId());
        holder.nomeMedicamento.setText(alarme.getNomeMedicamento());
        holder.dataFinal.setText(alarme.getDataFinal());
        holder.horarios.setText(alarme.getHorarioSelecionado());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeMedicamento, dataFinal, horarios, id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idRecycleView);
            nomeMedicamento = itemView.findViewById(R.id.recycleView_nome);
            dataFinal = itemView.findViewById(R.id.recycleView_data);
            horarios = itemView.findViewById(R.id.recycleView_hora);
        }
    }
}