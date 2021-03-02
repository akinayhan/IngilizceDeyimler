package com.example.ingilizcedeyimler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeyimEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deyim_ekle);

        final EditText txting = (EditText)findViewById(R.id.txting);
        final EditText txttr = (EditText)findViewById(R.id.txttr);
        Button btnekle = (Button)findViewById(R.id.btnekle);
        Button btnlistele = (Button)findViewById(R.id.btnlistele);

        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ing = txting.getText().toString();
                String tr = txttr.getText().toString();

                if (ing.isEmpty() || tr.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Alanları Boş Geçemezsiniz",Toast.LENGTH_LONG).show();
                    return;
                }

                Deyimler deyimler = new Deyimler(ing,tr);
                Database db = new Database(getApplicationContext());
                long id = db.kaydetDeyim(deyimler);

                if(id>0){
                    Toast.makeText(getApplicationContext(),"Ekleme Başarılı! ID = " + id,Toast.LENGTH_LONG).show();
                    txting.setText("");
                    txttr.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Ekleme Başarısız! " ,Toast.LENGTH_LONG).show();
                }
            }
        });

        btnlistele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DeyimListele.class);
                startActivity(intent);
            }
        });
    }
}
