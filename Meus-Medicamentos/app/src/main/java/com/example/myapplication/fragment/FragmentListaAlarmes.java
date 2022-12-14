package com.example.myapplication.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentListaAlarmesBinding;
import com.example.myapplication.model.entidades.Alarme;
import com.example.myapplication.recyclerView.MyAdapter;
import com.example.myapplication.recyclerView.RecyclerViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FragmentListaAlarmes extends Fragment {

    FragmentListaAlarmesBinding binding;
    ArrayList<Alarme> listados;
    RecyclerViewAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference;
    MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListaAlarmesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Alarmes");
        binding.recycle.setHasFixedSize(true);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        listados = new ArrayList<Alarme>();
        myAdapter = new MyAdapter(getActivity(), listados);
        binding.recycle.setAdapter(myAdapter);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Alarme a = dataSnapshot.getValue(Alarme.class);
                    listados.add(a);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        adapter = new RecyclerViewAdapter(getActivity(), banco.listar());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
//        binding.recycle.setLayoutManager(layoutManager);
//        binding.recycle.setAdapter(adapter);
        chamarTelaCadastro();
        chamarTelaCalcular();
//        recyclerView = binding.recycle;
//        lista = new ArrayList<Alarme>();
//        lista.add(new Alarme("Dipirona","14/11/2022","10 20 01"));
//        lista.add(new Alarme("Anti-Alergico","17/11/2022","10 20 01"));
//        adapter = new RecyclerViewAdapter(getActivity(), banco.listar());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.VERTICAL, false);
//        binding.recycle.setLayoutManager(layoutManager);
//        binding.recycle.setAdapter(adapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    public void chamarTelaCadastro() {
        binding.btFlutuante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout, new FragmentCadastroRemedio());
                fragmentTransaction.commit();

            }
        });
    }
    public void chamarTelaCalcular() {
        binding.btFlutuante2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout, new CalcularFragment());
                fragmentTransaction.commit();

            }
        });
    }

}