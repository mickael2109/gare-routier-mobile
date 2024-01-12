package com.example.exam_l3_ird2_si20200033;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ArrayList<Destionation> dest_axe_sud, dest_axe_est, dest_axe_sudOuest, dest_axe_Ouest;
    Spinner spinnerSud, spinnerEst, spinnerSudOuest, spinnerOuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        spinnerSud = findViewById(R.id.spinner_axe_sud);
        spinnerEst = findViewById(R.id.spinner_axe_est);
        spinnerSudOuest = findViewById(R.id.spinner_axe_sudOuest);
        spinnerOuest = findViewById(R.id.spinner_axe_Ouest);
        axe_sud();
        axe_est();
        axe_sud_ouest();
        axe_Ouest();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    public void axe_sud(){
        dest_axe_sud = new ArrayList<>();
        dest_axe_sud.add(new Destionation("Ambatolampy", "7h, 9h, 14h, 16h", 10000, 110));
        dest_axe_sud.add(new Destionation("Antsirabe","7h, 9h, 13h, 16h", 20000, 170));
        dest_axe_sud.add(new Destionation("Ambositra","7h, 9h", 50000, 550));
        dest_axe_sud.add(new Destionation("Fianarantsoa","7h 30min, 17h 30min", 38000, 406));
        dest_axe_sud.add(new Destionation("Ihosy","7h, 17h 15min", 50000, 670));
        dest_axe_sud.add(new Destionation("Ankaramena","7h, 9h, 17h", 60000, 750));
        dest_axe_sud.add(new Destionation("Toliara","8h, 17h", 75000, 988));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_sud);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSud.setAdapter(adapter);
        spinnerSud.setOnItemSelectedListener(this);
    }

    public void axe_est(){
        dest_axe_est = new ArrayList<>();
        dest_axe_est.add(new Destionation("Ifanadiana", "7h, 9h, 16h", 20000, 350));
        dest_axe_est.add(new Destionation("Rondro","7h, 9h, 16h", 25000, 400));
        dest_axe_est.add(new Destionation("Mananjary","7h, 17h", 28000, 450));
        dest_axe_est.add(new Destionation("Manakara","7h, 17h", 30000, 520));
        dest_axe_est.add(new Destionation("Vohipeno","7h, 9h, 17h", 31000, 550));
        dest_axe_est.add(new Destionation("Farafangana","7h, 9h, 17h", 32000, 598));
        dest_axe_est.add(new Destionation("Vaingadrano","7h, 17h", 39000, 620));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_est);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEst.setAdapter(adapter);
        spinnerEst.setOnItemSelectedListener(this);
    }

    public void axe_sud_ouest(){
        dest_axe_sudOuest = new ArrayList<>();
        dest_axe_sudOuest.add(new Destionation("Miandrivazo", "8h, 17h", 25000, 350));
        dest_axe_sudOuest.add(new Destionation("Morondava","7h, 17h", 35000, 410));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_sudOuest);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSudOuest.setAdapter(adapter);
        spinnerSudOuest.setOnItemSelectedListener(this);
    }

    public void axe_Ouest(){
        dest_axe_Ouest = new ArrayList<>();
        dest_axe_Ouest.add(new Destionation("Miarinarivo", "7h, 9h, 15h", 5000, 60));
        dest_axe_Ouest.add(new Destionation("Arivonimamo","7h, 9h, 16h", 10000, 95));
        dest_axe_Ouest.add(new Destionation("Ampefy", "8h, 9h", 12000, 110));
        dest_axe_Ouest.add(new Destionation("Tsiroromandidy","7h, 17h", 21000, 230));

        ArrayAdapter<Destionation> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dest_axe_Ouest);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOuest.setAdapter(adapter);
        spinnerOuest.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        StringBuilder result = new StringBuilder();

        if(adapterView.getId()==R.id.spinner_axe_sud){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_sud.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_sud.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_sud.get(i).getDistance()+" Km");

        }else if(adapterView.getId()==R.id.spinner_axe_est){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_est.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_est.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_est.get(i).getDistance()+" Km");

        }else if(adapterView.getId()==R.id.spinner_axe_sudOuest){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_sudOuest.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_sudOuest.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_sudOuest.get(i).getDistance()+" Km");

        }else if(adapterView.getId()==R.id.spinner_axe_Ouest){
            String text = adapterView.getItemAtPosition(i).toString();
            result.append("Destination :"+text);
            result.append("\nDépart : "+dest_axe_Ouest.get(i).getH_depart());
            result.append("\nPrix : "+dest_axe_Ouest.get(i).getPrix()+" Ar");
            result.append("\nDistance : "+dest_axe_Ouest.get(i).getDistance()+" Km");
        }


        Toast.makeText(adapterView.getContext(), result.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



class Destionation{
    String destionation, h_depart;
    float prix;
    int distance;

    public Destionation(){}

    public Destionation(String destionation, String h_depart, float prix, int distance){
        this.destionation = destionation;
        this.h_depart = h_depart;
        this.prix = prix;
        this.distance = distance;
    }

    public String getDestionation(){ return destionation; }
    public String getH_depart(){ return h_depart; }
    public float getPrix(){ return prix; }
    public int getDistance(){ return distance; }

    public String toString(){
        return getDestionation();
    }

}