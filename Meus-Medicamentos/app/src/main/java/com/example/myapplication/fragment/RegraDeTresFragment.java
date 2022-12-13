package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentGotejamentoBinding;
import com.example.myapplication.databinding.FragmentRegraDeTresBinding;
import com.example.myapplication.model.CalcularMedidas;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class RegraDeTresFragment extends Fragment {
    FragmentRegraDeTresBinding binding;
    public RegraDeTresFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegraDeTresBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calcular();
        chamarAnterior();
        limparCampos();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    public void calcular(){
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularMedidas calc = new CalcularMedidas();
                String resultado = "RESOLUÇAO\n Volume Disponivel * Prescrição)/\n Disponivel\n R = ("+ binding.editTextTextPersonName4.getText().toString() + " * "
                        + binding.editTextTextPersonName.getText().toString() + ") / "+ binding.editTextTextPersonName.getText().toString() + ")\n R= "+
                        calc.regraDeTres(Double.parseDouble(binding.editTextTextPersonName.getText().toString()),Double.parseDouble(binding.editTextTextPersonName2.getText().toString()),
                                Double.parseDouble(binding.editTextTextPersonName4.getText().toString()));
                binding.textView7.setText(resultado);
            }
        });
    }
    public void limparCampos(){
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView7.setText("");
                binding.editTextTextPersonName.setText("");
                binding.editTextTextPersonName2.setText("");
                binding.editTextTextPersonName4.setText("");

            }
        });
    }
    public void chamarAnterior(){
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout,new CalcularFragment());
                fragmentTransaction.commit();

            }
        });
    }
}