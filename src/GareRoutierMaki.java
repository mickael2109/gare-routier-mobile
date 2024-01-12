package com.example.exam_l3_ird2_si20200033;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class GareRoutierMaki extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    CardView cardEst;
    CardView cardNord;
    CardView cardNordEst;
    CardView cardNordOuest;

    ArrayList<Destionation> dest_axe_Nord, dest_axe_NordOuest, dest_axe_NordEst, dest_axe_Est2;
    Spinner spinnerNord, spinnerNordOuest, spinnerNordEst, spinnerEst2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gare_routier_maki);
        spinnerNord = findViewById(R.id.spinner_axe_nord);
        spinnerNordOuest = findViewById(R.id.spinner_axe_nordOuest);
        spinnerNordEst = findViewById(R.id.spinner_axe_nordEst);
        spinnerEst2 = findViewById(R.id.spinner_axe_Est2);

        axe_Nord();
        axe_Est2();
        axe_NordOuest();
        axe_NordEst();
    }


    public void axe_Nord(){
        dest_axe_Nord = new ArrayList<>();
        dest_axe_Nord.add(new Destionation("Antsohihy", "6h, 17h", 25000, 410));
        dest_axe_Nord.add(new Destionation("Ambanja","6h, 17h", 30000, 550));
        dest_axe_Nord.add(new Destionation("Ambilobe","7h, 9h", 40000, 750));
        dest_axe_Nord.add(new Destionation("Antsiranana","7h, 9h, 16h", 56000, 1012));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_Nord);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNord.setAdapter(adapter);
        spinnerNord.setOnItemSelectedListener(this);
    }

    public void axe_Est2(){
        dest_axe_Est2 = new ArrayList<>();
        dest_axe_Est2.add(new Destionation("Moramanga", "7h, 9h, 13h, 16h", 12000, 150));
        dest_axe_Est2.add(new Destionation("Brickaville","8h, 10h, 16h", 20000, 250));
        dest_axe_Est2.add(new Destionation("Toamasina","7h, 17h", 38000, 325));
        dest_axe_Est2.add(new Destionation("Fénerive Est","8h, 17h", 40000, 420));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_Est2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEst2.setAdapter(adapter);
        spinnerEst2.setOnItemSelectedListener(this);
    }

    public void axe_NordOuest(){
        dest_axe_NordOuest = new ArrayList<>();
        dest_axe_NordOuest.add(new Destionation("Maevatanana", "8h, 10h, 15h", 25000, 350));
        dest_axe_NordOuest.add(new Destionation("Ambondromamy","7h, 9h, 16h", 35000, 410));
        dest_axe_NordOuest.add(new Destionation("Mahajanga","7h, 17h", 45000, 650));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_NordOuest);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNordOuest.setAdapter(adapter);
        spinnerNordOuest.setOnItemSelectedListener(this);
    }

    public void axe_NordEst(){
        dest_axe_NordEst = new ArrayList<>();
        dest_axe_NordEst.add(new Destionation("Vohemar", "7h, 15h", 35000, 550));
        dest_axe_NordEst.add(new Destionation("Antalaha","7h, 16h", 48000, 605));
        dest_axe_NordEst.add(new Destionation("Sambava", "7h, 18h", 62000, 712));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_NordEst);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNordEst.setAdapter(adapter);
        spinnerNordEst.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        StringBuilder result = new StringBuilder();

        if(adapterView.getId()==R.id.spinner_axe_nord){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_Nord.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_Nord.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_Nord.get(i).getDistance()+" Km");

        }else if(adapterView.getId()==R.id.spinner_axe_Est2){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_Est2.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_Est2.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_Est2.get(i).getDistance()+" Km");

        }else if(adapterView.getId()==R.id.spinner_axe_nordOuest){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_NordOuest.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_NordOuest.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_NordOuest.get(i).getDistance()+" Km");

        }else if(adapterView.getId()==R.id.spinner_axe_nordEst){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_NordEst.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_NordEst.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_NordEst.get(i).getDistance()+" Km");
        }


        Toast.makeText(adapterView.getContext(), result.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

