package com.example.formulariocompleto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    protected ImageView ima1;
    protected TextView texto1;
    protected TimerTask tt;
    protected Timer t;
    protected Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ima1 = ( ImageView) findViewById(R.id.ima1_main);
        texto1 = ( TextView) findViewById(R.id.texto1_main);

        tt= new TimerTask() {
            @Override
            public void run() {
                pasarPantalla = new Intent(MainActivity.this, InformacionActivity.class);
                startActivity(pasarPantalla);

            }
        };
        t= new Timer();
        t.schedule(tt,2000);


    }
}