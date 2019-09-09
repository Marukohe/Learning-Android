package com.example.beeradvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Called then the user clicks the button
    public void onClickFindBeer(View view){

        //Get a reference to the TextView
        TextView brans = (TextView)findViewById(R.id.brands);

        //Get a reference to the Spinner
        Spinner color  = (Spinner)findViewById(R.id.color);

        //Get selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //Display the selected item
//        brans.setText(beerType);
        //Get recommendations from the BeerExpert class

        List<String> brandsList = expert.getBrands(beerType);

        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandsList){
            brandsFormatted.append(brand).append("\n");
        }

        brans.setText(brandsFormatted);
    }
}
