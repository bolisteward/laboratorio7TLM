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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_Nombres = findViewById(R.id.edit_Nombres);
        edit_Apellidos = findViewById(R.id.edit_Apellidos);
        edit_Telefono = findViewById(R.id.edit_Telefono);
        edit_Mail = findViewById(R.id.edit_Mail);
    }

    public void enviar (View v) {
        Bundle info = new Bundle();

        if (edit_Nombres.getText() != null && edit_Apellidos.getText() != null && edit_Telefono.getText()!= null &&
                edit_Mail.getText()!= null){
            System.out.println(edit_Nombres.getText().toString());
            info.putString("Nombres", edit_Nombres.getText().toString());
            info.putString("Apellidos",  edit_Apellidos.getText().toString());
            info.putString("Telefono", edit_Telefono.getText().toString());
            info.putString("Correo",  edit_Mail.getText().toString());

            Intent intent = new Intent( this, Main2Activity.class);
            intent.putExtra("info", info);
            startActivity(intent);
        } else{
            Toast.makeText(this, "Falta ingresar campos, verifique y velva a intentar.", Toast.LENGTH_SHORT).show();
        }
    }
}



