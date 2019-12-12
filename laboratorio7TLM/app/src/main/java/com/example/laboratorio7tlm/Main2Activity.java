package com.example.laboratorio7tlm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public TextView txt_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt_mensaje =  findViewById(R.id.txt_mensaje);

        Bundle info  =  getIntent().getBundleExtra("info");

        String mensaje = "Bienvenido " + info.get("Nombres") + " " + info.get("Apellidos") + "\n \n" +
                "Sus datos de Contacto:\n" +"Teléfono:" + info.get("Telefono") + "\n" +
                "Correo Electrónico:" + info.get("Correo");

        txt_mensaje.setText(mensaje);
    }


}
