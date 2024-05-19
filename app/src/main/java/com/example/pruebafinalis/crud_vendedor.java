package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class crud_vendedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crud_vendedor);

    }
    public void solicitudes(View vista){
        Intent solicitado = new Intent(this, solicitudes.class);
        startActivity(solicitado);
    }
    public void modificar(View vista){
        Intent modific = new Intent(this, modificar.class);
        startActivity(modific);
    }
    public void MainActivity(View vista){
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }
}
