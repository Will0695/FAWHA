package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;


public class Usuario extends AppCompatActivity {

        private static final String PREFS_NAME = "MyPrefsFile";
        private static final String TOKEN_KEY = "token";
        private SessionManager sessionManager;

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
