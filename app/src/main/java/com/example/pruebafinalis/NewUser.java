package com.example.pruebafinalis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

                // Aquí puedes agregar la lógica para guardar el usuario en tu base de datos o realizar cualquier otra acción necesaria
                // Por ahora, simplemente mostramos un mensaje de éxito
                Toast.makeText(NewUser.this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();

                // Dirigir al usuario a la actividad Usuario
                Intent intent = new Intent(NewUser.this, Usuario.class);
                startActivity(intent);
                finish(); // Opcional: para cerrar la actividad actual después de iniciar la actividad Usuario
            }
        });
    }
}
