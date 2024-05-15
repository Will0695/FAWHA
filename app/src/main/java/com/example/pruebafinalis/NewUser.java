package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.Nullable;

import androidx.appcompat.app.AppCompatActivity;

public class NewUser extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        Button crearButton = findViewById(R.id.crearButton);
        crearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });
    }

    private void crearUsuario() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Aquí puedes agregar la lógica para crear un nuevo usuario, por ejemplo, enviando los datos a un servidor
        // Para este ejemplo, solo mostraré un mensaje de éxito

        Toast.makeText(this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();

        // Opcionalmente, podrías redirigir al usuario a otra actividad
        // Intent intent = new Intent(NewUser.this, AnotherActivity.class);
        // startActivity(intent);
        // finish();
    }

}