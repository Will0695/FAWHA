package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class Usuario extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String TOKEN_KEY = "token";
    private SessionManager sessionManager;
    // Obtén una referencia al botón ImageButton


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        sessionManager = new SessionManager(this);

        // Inicializar el ImageButton de cerrar sesión
        ImageButton botonCerrarSesion = findViewById(R.id.CerrarSesion);
        if (botonCerrarSesion != null) {
            botonCerrarSesion.setOnClickListener(v -> cerrarSesion());
        }

        // Inicializar el botón de crear usuario
        Button botonCrearUsuario = findViewById(R.id.crearUsuario);
        if (botonCrearUsuario != null) {
            botonCrearUsuario.setOnClickListener(v -> {
                // Llamar al método para ir a la actividad NewUser
                Intent intent = new Intent(Usuario.this, NewUser.class);
                startActivity(intent);
            });
        }

        // Inicializar el ImageButton de visualizar
        ImageButton visualizarButton = findViewById(R.id.visualizar);
        if (visualizarButton != null) {
            visualizarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Crea un Intent para iniciar la actividad VerUsuarios
                    Intent intent = new Intent(Usuario.this, verusuarios.class);
                    // Inicia la actividad VerUsuarios
                    startActivity(intent);
                }
            });
        }
    }

    // Método para cerrar sesión
    private void cerrarSesion() {
        sessionManager.clearSession();

        // Redirigir a la actividad de inicio de sesión
        Intent intent = new Intent(Usuario.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
