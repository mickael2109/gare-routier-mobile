package com.example.exam_l3_ird2_si20200033;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class search_rapide extends AppCompatActivity{
    ListView listV;
    ArrayList<DestionationRapide> destList;
    ArrayAdapter<DestionationRapide> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_rapide);

        listV = (ListView) findViewById(R.id.listViewId);
        destList = new ArrayList<>();

        destList.add(new DestionationRapide("Fasan'karana","Axe Nord","Ambanja","6h, 17h", 30000, 550));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord","Ambilobe","7h, 9h", 40000, 750));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Ambositra","7h, 9h", 50000, 550));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord Ouest","Ambondromamy","7h, 9h, 16h", 35000, 410));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Ouest","Ampefy", "8h, 9h", 12000, 110));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Ambatolampy", "7h, 9h, 14h, 16h", 10000, 110));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Antsirabe","7h, 9h, 13h, 16h", 20000, 170));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord Est","Antalaha","7h, 16h", 48000, 605));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Ankaramena","7h, 9h, 17h", 60000, 750));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord","Antsohihy", "6h, 17h", 25000, 410));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord","Antsiranana","7h, 9h, 16h", 56000, 1012));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Ouest","Arivonimamo","7h, 9h, 16h", 10000, 95));
        destList.add(new DestionationRapide("Fasan'karana","Axe Est","Brickaville","8h, 10h, 16h", 20000, 250));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Farafangana","7h, 9h, 17h", 32000, 598));
        destList.add(new DestionationRapide("Fasan'karana","Axe Est","Fénerive Est","8h, 17h", 40000, 420));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Fianarantsoa","7h 30min, 17h 30min", 38000, 406));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Ifanadiana", "7h, 9h, 16h", 20000, 350));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Ihosy","7h, 17h 15min", 50000, 670));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord Ouest","Maevatanana", "8h, 10h, 15h", 25000, 350));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord Ouest","Mahajanga","7h, 17h", 45000, 650));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Mananjary","7h, 17h", 28000, 450));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Manakara","7h, 17h", 30000, 520));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Ouest","Miarinarivo", "7h, 9h, 15h", 5000, 60));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Ouest","Miandrivazo", "8h, 17h", 25000, 350));
        destList.add(new DestionationRapide("Fasan'karana","Axe Est","Moramanga", "7h, 9h, 13h, 16h", 12000, 150));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Ouest","Morondava","7h, 17h", 35000, 410));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Rondro","7h, 9h, 16h", 25000, 400));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord Est","Sambava", "7h, 18h", 62000, 712));
        destList.add(new DestionationRapide("Fasan'karana","Axe Est","Toamasina","7h, 17h", 38000, 325));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud","Toliara","8h, 17h", 75000, 988));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Ouest","Tsiroromandidy","7h, 17h", 21000, 230));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Vaingadrano","7h, 17h", 39000, 620));
        destList.add(new DestionationRapide("Fasan'karana","Axe Nord Est","Vohemar", "7h, 15h", 35000, 550));
        destList.add(new DestionationRapide("Maki Andotapenaka","Axe Sud-Est","Vohipeno","7h, 9h, 17h", 31000, 550));

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, destList);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StringBuilder result = new StringBuilder();
                String text = adapterView.getItemAtPosition(i).toString();
                result.append("Gare :"+destList.get(i).getGare());
                result.append("\nAxe :"+destList.get(i).getAxe());
                result.append("\nDestination :"+text);
                result.append("\nDépart : "+destList.get(i).getH_depart());
                result.append("\nPrix : "+destList.get(i).getPrix()+" Ar");
                result.append("\nDistance : "+destList.get(i).getDistance()+" Km");

                Toast.makeText(adapterView.getContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });


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
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}


class DestionationRapide{
    String destionation, h_depart, gare, axe;
    float prix;
    int distance;

    public DestionationRapide(){}

    public DestionationRapide(String gare, String axe, String destionation, String h_depart, float prix, int distance){
        this.gare = gare;
        this.axe = axe;
        this.destionation = destionation;
        this.h_depart = h_depart;
        this.prix = prix;
        this.distance = distance;
    }

    public String getGare(){ return gare; }
    public String getAxe(){ return axe; }
    public String getDestionation(){ return destionation; }
    public String getH_depart(){ return h_depart; }
    public float getPrix(){ return prix; }
    public int getDistance(){ return distance; }

    public String toString(){
        return getDestionation();
    }

}