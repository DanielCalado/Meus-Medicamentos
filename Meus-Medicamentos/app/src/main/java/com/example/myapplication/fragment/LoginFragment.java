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
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.model.entidades.Usuario;


public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    Usuario usuario = new Usuario("Daniel Calado", "daniel12", "saosao", "(87)98123-4345", 25);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chamarTelaCadastro();
        logar();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    public void logar(){
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.login.getText().toString().equals(usuario.email)
                        && binding.senha2.getText().toString().equals(usuario.senha)) {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setReorderingAllowed(true);
                    fragmentTransaction.replace(R.id.frameLayout, new FragmentListaAlarmes());
                    fragmentTransaction.commit();
                }
            }
        });

    }
    public void chamarTelaCadastro(){
        binding.obtercadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout,new CadastroUsuarioFragment());
                fragmentTransaction.commit();

            }
        });
    }
}