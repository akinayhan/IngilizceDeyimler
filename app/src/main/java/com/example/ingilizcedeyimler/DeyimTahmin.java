package com.example.ingilizcedeyimler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.AbstractCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DeyimTahmin extends AppCompatActivity {


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deyim_tahmin);

        final TextView txting = (TextView) findViewById(R.id.txting2);
        final TextView txttr = (TextView) findViewById(R.id.txttr2);
        Button btnyeni = (Button)findViewById(R.id.btnyeni);
        Button btngost = (Button)findViewById(R.id.btngost);


        btnyeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getApplicationContext());

                List<Deyimler> deyimlerList = new ArrayList<Deyimler>();
                deyimlerList = db.getirDeyimlerListesi();
                StringBuilder sb = new StringBuilder();
                for (Deyimler _deyimler : deyimlerList) {
                    txting.setText(_deyimler.getIng());
                }
            }
        });

        btngost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getApplicationContext());
                List<Deyimler> deyimlerList = new ArrayList<Deyimler>();
                deyimlerList = db.getirDeyimlerListesi();
                int aa = deyimlerList.size();
                StringBuilder sb = new StringBuilder();
                for(Deyimler _deyimler : deyimlerList)
                {
                    txttr.setText(_deyimler.getTr());
                }
            }
        });


    }
}