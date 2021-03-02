package com.example.ingilizcedeyimler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DeyimListele extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deyim_listele);

        final EditText txtDeyimlerListesi = (EditText)findViewById(R.id.txtDeyimlerListesi);
        Database db = new Database(getApplicationContext());

        List<Deyimler> deyimlerList = new ArrayList<Deyimler>();
        deyimlerList = db.getirDeyimlerListesi();

        StringBuilder sb = new StringBuilder();

        for(Deyimler _deyimler : deyimlerList)
        {
            String icerik = "";
            icerik = "ID: " + _deyimler.getId() + " İngilizce: " + _deyimler.getIng() + " Türkçe: " + _deyimler.getTr() + "\n\n";
            sb.append(icerik);
            String ing = "";
        }
        txtDeyimlerListesi.setText(sb);
    }
}
