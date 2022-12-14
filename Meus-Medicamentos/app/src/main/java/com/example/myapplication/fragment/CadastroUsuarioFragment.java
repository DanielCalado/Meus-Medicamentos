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
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.bancoUsuario.Controller;
import com.example.myapplication.databinding.FragmentCadastroUsuarioBinding;
import com.example.myapplication.model.entidades.Usuario;


public class CadastroUsuarioFragment extends Fragment {
    FragmentCadastroUsuarioBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastroUsuarioBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        chamarTelaLogin();
        salvarUsuario();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    public void salvarUsuario(){
        String email = binding.email.getText().toString();
        String senha = binding.senha.getText().toString();
        if(!email.isEmpty()){
            if(!senha.isEmpty()){
                Usuario usuario = new Usuario();
                Controller controller = new Controller();
                usuario.setEmail(email);
                usuario.setSenha(senha);
                controller.CadastrarPessoas(usuario);
            }else{
                Toast.makeText(getActivity(), "Campo senha vazio", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(), "Campo email vazio", Toast.LENGTH_SHORT).show();
        }

    }
    public void chamarTelaLogin(){
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarUsuario();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout,new LoginFragment());
                fragmentTransaction.commit();
            }
        });
    }
}