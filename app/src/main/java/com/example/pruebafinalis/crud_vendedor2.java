package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class crud_vendedor2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_vendedor2);
    }
public void solicitudes2(View vista){
        Intent solicitado = new Intent(this, solicitudes2.class);
        startActivity(solicitado);
}
public void modificados(View vista){
        Intent modific = new Intent(this, modificados.class);
        startActivity(modific);
}
    public void MainActivity(View vista){
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }
}
