package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.Nullable;

public class NewUser extends AppCompatActivity {
    public void onIrANewUserClick(View view) {
        Intent intent = new Intent(this, NewUser.class);
        startActivity(intent);
    }
}