package com.example.laboratorio7tlm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_Nombres, edit_Apellidos, edit_Telefono, edit_Mail;
    Intent emailIntent = new Intent(Intent.ACTION_SEND);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_Nombres = (EditText)findViewById(R.id.edit_Nombre);
        edit_Apellidos = (EditText)findViewById(R.id.edit_Apellidos);
        edit_Telefono = (EditText)findViewById(R.id.edit_Telefono);
        edit_Mail = (EditText)findViewById(R.id.edit_Mail);
    }

    public void enviar (View v) {
        String[] to = {"cvaccaro@espol.edu.ec"};
        String[] cc = {"cvaccaro@fiec.espol.edu.ec"};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Formulario de Registro PST");


        emailIntent.putExtra(Intent.EXTRA_TEXT, "Datos de Contacto\n" +
                "Nombres:" + edit_Nombres.getText().toString() + "\n" +
                "Apellidos:" + edit_Apellidos.getText().toString() + "\n" +
                "Teléfono:" + edit_Telefono.getText().toString() + "\n" +
                "Correo Electrónico:" + edit_Mail.getText().toString() + "\n");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviando Email"));
            Log.i("termina envio de email", "");
        }catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No existe cliente Email instalado.", Toast.LENGTH_SHORT).show();
        }
    }
}



