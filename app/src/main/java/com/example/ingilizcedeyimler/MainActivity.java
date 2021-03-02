package com.example.ingilizcedeyimler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gitekle(View view) {
        Intent ekle_intent =  new Intent(getApplicationContext(),DeyimEkle.class);
        startActivity(ekle_intent);
    }

    public void gittahmin(View view) {
        Intent tahmin_intent =  new Intent(getApplicationContext(), DeyimTahmin.class);
        startActivity(tahmin_intent);

    }

    public void gitlistele(View view) {
        Intent listele_intent =  new Intent(getApplicationContext(), DeyimListele.class);
        startActivity(listele_intent);
    }
}
