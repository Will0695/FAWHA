package com.example.pruebafinalis;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.text.InputType;
import android.util.Log;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private ProgressBar progressBar;
    private TextView errorTextView; // Añade una referencia al TextView
    private ImageButton showPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView); // Inicializa el TextView
       // showPasswordButton = findViewById(R.id.showPasswordButton);
    }
    public void onShowPasswordClicked(View view) {
        if (passwordEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            // Si la contraseña es visible, cambiar a contraseña oculta
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            showPasswordButton.setImageResource(R.drawable.seeoff);
        } else {
            // Si la contraseña está oculta, cambiar a contraseña visible
            passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            showPasswordButton.setImageResource(R.drawable.see);
        }
        // Mover el cursor al final del texto
        passwordEditText.setSelection(passwordEditText.length());
    }
   public void onLoginClicked(View view) {
       progressBar.setVisibility(View.VISIBLE); // Mostrar el ProgressBar al iniciar la solicitud de inicio de sesión
        loginPost();

    }

    public void loginPost(){
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String postUrl = "https://api-production-c57e.up.railway.app/api/login";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

            JSONObject postData = new JSONObject();
            try {
                postData.put("nombre_usuario", username);
                postData.put("password", password);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    System.out.println("token12" + response);
                    progressBar.setVisibility(View.GONE); // Ocultar el ProgressBar cuando se recibe la respuesta
                    setContentView(R.layout.activity_usuario);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.GONE); // Ocultar el ProgressBar en caso de error
                    errorTextView.setVisibility(View.VISIBLE); // Mostrar el TextView de error
                    usernameEditText.setText("");
                    passwordEditText.setText("");
                    usernameEditText.requestFocus();
                    error.printStackTrace();
                }
            });
            requestQueue.add(jsonObjectRequest);
        }

}