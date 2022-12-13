package com.example.myapplication.recyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView nomeMedicamento, dataFinal, horarios, id;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.idRecycleView);
        nomeMedicamento = itemView.findViewById(R.id.recycleView_nome);
        dataFinal = itemView.findViewById(R.id.recycleView_data);
        horarios = itemView.findViewById(R.id.recycleView_hora);
    }
}
