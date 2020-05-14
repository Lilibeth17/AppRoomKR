package com.karenreal.approomkr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityRegistrarse extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText  correo, pass;
    private Button btnregistro;
    private TextView mlogin;
    private ProgressBar progressBar;
    private EditText usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        //variables de datos
        usuario= findViewById(R.id.nomUser);
        correo= findViewById(R.id.correo);
        pass = findViewById(R.id.contraseña);
        btnregistro = findViewById(R.id.btnregistrarse);
        mlogin= findViewById(R.id.loginregistrarse);

        mAuth = FirebaseAuth.getInstance();
        progressBar= findViewById(R.id.progressBar);

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), ActivityMenu.class));
            finish();
        }
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = correo.getText().toString().trim();
                String password = pass.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    correo.setError("Correo requerido");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    pass.setError("Se requiere contraseña");
                    return;
                }
                if (password.length() < 6){
                    pass.setError("Contraseña minimo 6 caracteres");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //REGISTRO
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ActivityRegistrarse.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), ActivityMenu.class));
                                } else {

                                    Toast.makeText(ActivityRegistrarse.this, "Usuario ya registrado"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ActivityLogin.class));
            }
        });
    }
}
