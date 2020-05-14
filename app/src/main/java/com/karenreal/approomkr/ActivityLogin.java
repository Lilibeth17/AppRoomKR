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

public class ActivityLogin extends AppCompatActivity {
    private EditText correologin, passlogin;
    private Button btnLogin;
    private ProgressBar progressBarlogin;
    private TextView olviContra;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correologin = findViewById(R.id.logincorreo);
        passlogin = findViewById(R.id.logincontraseña);
        btnLogin = findViewById(R.id.btnlogin);
        olviContra = findViewById(R.id.olvcontra);
        progressBarlogin = findViewById(R.id.progressBarlogin);
        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginemail = correologin.getText().toString().trim();
                String passwordlogin = passlogin.getText().toString();

                if (TextUtils.isEmpty(loginemail)) {
                    correologin.setError("Correo requerido");
                    return;
                }
                if (TextUtils.isEmpty(passwordlogin)) {
                    passlogin.setError("Contraseña requerida");
                    return;

                }
                if (passwordlogin.length() < 6) {
                    passlogin.setError("La contraseña debe tener minimo 6 caracteres");
                    return;
                }
                progressBarlogin.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(loginemail, passwordlogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ActivityLogin.this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ActivityMenu.class));
                            finish();
                        } else {
                            Toast.makeText(ActivityLogin.this, "Error" + task.getException(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });



    }

}
