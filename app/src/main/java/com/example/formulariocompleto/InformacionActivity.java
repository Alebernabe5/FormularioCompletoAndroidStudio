package com.example.formulariocompleto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InformacionActivity extends AppCompatActivity {

    protected TextView texto1;
    protected TextView texto2;
    protected EditText caja1;
    protected EditText caja2;
    protected Button boton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texto1 = (TextView) findViewById(R.id.texto1_informacion);
        texto2 = (TextView) findViewById(R.id.texto2_informacion);
        caja1 = (EditText) findViewById(R.id.caja1_informacion);
        caja2 = (EditText) findViewById(R.id.caja2_informacion);
        boton1 = (Button) findViewById(R.id.boton1_informacion);


    }
}