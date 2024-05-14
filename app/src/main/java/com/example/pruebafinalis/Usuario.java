package com.example.pruebafinalis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Usuario extends AppCompatActivity {
    private ImageView imageViewModificar, imageViewBuscar, imageViewEliminar;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);

        imageViewModificar = findViewById(R.id.imageViewModificar);
        imageViewBuscar = findViewById(R.id.imageViewBuscar);
        imageViewEliminar = findViewById(R.id.imageViewEliminar);

        imageViewModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la nueva actividad EditarActivity
                Intent intent = new Intent(Usuario.this, Clientes.class);
                startActivity(intent);
            }
        });

        // Implementar la lógica para los otros ImageView (buscar y eliminar)

        sessionManager = new SessionManager(this);

        // Agregar el botón de cerrar sesión
        @SuppressLint("WrongViewCast") Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutClick(v);
            }
        });
    }

    public void onNuevoBotonClick(View view) {
        Intent intent = new Intent(this, Clientes.class);
        startActivity(intent);
    }

    public void onLogoutClick(View view) {
        // Cerrar la sesión y volver a la pantalla de inicio de sesión
        sessionManager.clearSession();
        startActivity(new Intent(Usuario.this, MainActivity.class));
        finish();
    }
}