package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewUser extends AppCompatActivity {

    private EditText usernameEditText, apellidoEditText, nombre_usuarioEditText, correoEditText, passwordEditText, confirpasswordEditText;
    private Button crearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        // Inicializar vistas
        usernameEditText = findViewById(R.id.usernameEditText);
        apellidoEditText = findViewById(R.id.apellidoEditText);
        nombre_usuarioEditText = findViewById(R.id.nombre_usuarioEditText);
        correoEditText = findViewById(R.id.correoEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirpasswordEditText = findViewById(R.id.confirpasswordEditText);
        crearButton = findViewById(R.id.crearButton);

        // Configurar el botón de crear usuario
        crearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados por el usuario
                String nombre = usernameEditText.getText().toString();
                String apellido = apellidoEditText.getText().toString();
                String nombreUsuario = nombre_usuarioEditText.getText().toString();
                String correo = correoEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirpasswordEditText.getText().toString();

                // Verificar si se han ingresado todos los campos
                if (nombre.isEmpty() || apellido.isEmpty() || nombreUsuario.isEmpty() || correo.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(NewUser.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificar si las contraseñas coinciden
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(NewUser.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Crear un objeto JSON con los datos del nuevo usuario
                JSONObject newUser = new JSONObject();
                try {
                    newUser.put("nombre", nombre);
                    newUser.put("apellido", apellido);
                    newUser.put("nombre_usuario", nombreUsuario);
                    newUser.put("correo", correo);
                    newUser.put("password", password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Enviar la solicitud HTTP para guardar el nuevo usuario
                guardarNuevoUsuario(newUser);
            }
        });
    }

    private void guardarNuevoUsuario(JSONObject newUser) {
        // URL de la API para guardar el nuevo usuario
        String url = "http://api-production-c57e.up.railway.app/api/register";

        // Crear una instancia de OkHttpClient para enviar la solicitud HTTP
        OkHttpClient client = new OkHttpClient();

        // Crear el cuerpo de la solicitud HTTP con el objeto JSON
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), newUser.toString());

        // Crear la solicitud HTTP POST
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        // Enviar la solicitud HTTP de forma asíncrona
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
                // Manejar el fallo de la solicitud HTTP (por ejemplo, mostrar un mensaje de error)
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(NewUser.this, "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                // Verificar si la solicitud HTTP fue exitosa
                if (response.isSuccessful()) {
                    // Manejar la respuesta del servidor (por ejemplo, mostrar un mensaje de éxito)
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NewUser.this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Dirigir al usuario a la actividad Usuario
                    Intent intent = new Intent(NewUser.this, Usuario.class);
                    startActivity(intent);
                    finish(); // Opcional: para cerrar la actividad actual después de iniciar la actividad Usuario
                } else {
                    // Manejar la respuesta de error del servidor (por ejemplo, mostrar un mensaje de error)
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NewUser.this, "Error al guardar el usuario", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
