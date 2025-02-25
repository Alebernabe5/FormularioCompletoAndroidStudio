package com.example.formulariocompleto;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GeneroActivity extends AppCompatActivity {

    protected TextView texto1;
    protected ImageButton imaBoton1;
    protected ImageButton imaBoton2;
    protected String paquete1 ="";
    protected String paquete2 ="";
    protected Bundle extras;//Estructura para almacenar los paquetes que llegan
    protected Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_genero);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texto1 = (TextView) findViewById(R.id.texto1_genero);
        imaBoton1 = (ImageButton) findViewById(R.id.imaboton1_genero);
        imaBoton2 = (ImageButton) findViewById(R.id.imaboton2_genero);

        extras = getIntent().getExtras(); //Cojo todos los paquetes que llegan a la actividad
        if(extras!=null) //Ha llegado algun paquete
        {
            paquete1 = extras.getString("NOMBRE");
            paquete2 = extras.getString("APELLIDOS");
            Toast.makeText(this, "Este es" +paquete1+paquete2, Toast.LENGTH_SHORT).show();

            imaBoton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pasarPantalla = new Intent(GeneroActivity.this, EdadActivity.class);
                    //Crear un paquete para hombre
                    pasarPantalla.putExtra("GENERO", "hombre");
                    //Enviar tambien paquete 1 y 2
                    pasarPantalla.putExtra("NOMBRE", paquete1);
                    pasarPantalla.putExtra("APELLIDOS", paquete2);
                    startActivity(pasarPantalla);

                }
            });

            imaBoton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pasarPantalla = new Intent(GeneroActivity.this, EdadActivity.class);
                    //Crear un paquete para mujer
                    pasarPantalla.putExtra("GENERO", "mujer");
                    //Enviar tambien paquete 1 y 2
                    pasarPantalla.putExtra("MUJER", paquete1);
                    pasarPantalla.putExtra("APELLIDOS", paquete2);
                    startActivity(pasarPantalla);
                }
            });

        }
        else {
            Toast.makeText(this, "No se han recibido paquetes", Toast.LENGTH_SHORT).show();
        }

    }
}