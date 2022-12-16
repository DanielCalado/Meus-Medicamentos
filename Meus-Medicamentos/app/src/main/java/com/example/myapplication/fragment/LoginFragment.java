package com.example.myapplication.fragment;

import android.content.Intent;
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
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.model.entidades.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    FirebaseAuth auth;
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
//                if(binding.login.getText().toString().equals(usuario.email)
//                        && binding.senha2.getText().toString().equals(usuario.senha)) {
//                    FragmentManager fragmentManager = getParentFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.setReorderingAllowed(true);
//                    fragmentTransaction.replace(R.id.frameLayout, new FragmentListaAlarmes());
//                    fragmentTransaction.commit();
//                }
                String email = binding.login.getText().toString();
                String senha = binding.senha2.getText().toString();
                if(!email.isEmpty()){
                    if(!senha.isEmpty()){
                        Usuario usuario = new Usuario();

                        Controller controller = new Controller();
                        usuario.setEmail(email);
                        usuario.setSenha(senha);
                        //controller.logar(usuario);
                        logarBanco(usuario);
                    }else {
                        Toast.makeText(getActivity(), "Campo senha vazio", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Campo email vazio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void logarBanco(Usuario usuario) {
        auth =Controller.getAuth();
        auth.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getActivity(), "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setReorderingAllowed(true);
                    fragmentTransaction.replace(R.id.frameLayout, new FragmentListaAlarmes());
                    fragmentTransaction.commit();

                }else{
                    Toast.makeText(getActivity(), "Deu ruim", Toast.LENGTH_SHORT).show();
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