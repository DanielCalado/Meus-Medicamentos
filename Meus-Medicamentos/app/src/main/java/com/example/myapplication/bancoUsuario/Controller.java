package com.example.myapplication.bancoUsuario;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.model.entidades.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Controller {
    private static FirebaseAuth auth;
    String txt = "";

    public Controller(){

    }

    public static FirebaseAuth getAuth() {
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    public void CadastrarPessoas(Usuario usuario){
        FirebaseAuth firebaseAuth = getAuth();
        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                }else{
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        e.printStackTrace();
                    }catch (FirebaseAuthUserCollisionException e){
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    public void logar(Usuario usuario){

        FirebaseAuth firebaseAuth = getAuth();
        firebaseAuth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                }else {
                }
            }
        });
    }

}
