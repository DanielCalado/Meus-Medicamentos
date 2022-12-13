package com.example.myapplication.firebase;

import androidx.annotation.NonNull;

import com.example.myapplication.model.Alarme;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Banco {
    FirebaseDatabase database;
    DatabaseReference reference;

    public Banco() {

    }

    public void salvar(Alarme a) {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Alarmes");
        String id = reference.push().getKey().toString();
        a.setId(id);
        reference.child(id).setValue(a);

    }

    public ArrayList<Alarme> listar() {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Alarmes");
        ArrayList<Alarme> listados = new ArrayList<Alarme>();
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

        return listados;
    }

}
