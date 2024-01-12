package com.example.exam_l3_ird2_si20200033;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnFasanKarana;
    Button btnMaki;
    private ImageButton btnSearch;
    private ImageButton btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnFasanKarana = (Button) findViewById(R.id.btn_fasan_karana);
        btnMaki = (Button) findViewById(R.id.btn_maki);
        btnSearch = (ImageButton) findViewById(R.id.imageButtonSearch);
        btnExit = (ImageButton) findViewById(R.id.imageButtonExit);

        btnFasanKarana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFasanKarana();
            }
        });

        btnMaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaki();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchRapide();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              moveTaskToBack(true);
              android.os.Process.killProcess(android.os.Process.myPid());
              System.exit(1);
            }
        });


    }

    public void openFasanKarana() {
        Intent intent = new Intent(this, Accueil.class);
        startActivity(intent);
    }

    public void openMaki() {
        Intent intent = new Intent(this, GareRoutierMaki.class);
        startActivity(intent);
    }

    public void openSearchRapide() {
        Intent intent = new Intent(this, search_rapide.class);
        startActivity(intent);
    }
}

