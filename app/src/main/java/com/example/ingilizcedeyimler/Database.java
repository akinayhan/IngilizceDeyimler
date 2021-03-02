package com.example.ingilizcedeyimler;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public class Database extends SQLiteOpenHelper {

    private static final String veritabani_adi = "veritabani_deyimler";
    private static final String deyimler_tablosu = "tbl_deyimler";
    private static final int veritabani_versiyon = 1;

    public Database(@Nullable Context context) {
        super(context, veritabani_adi, null, veritabani_versiyon);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_deyimlerTablosuOlusturma = "CREATE TABLE " + deyimler_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, IngDeyim TEXT, TrDeyim TEXT)";
        db.execSQL(sql_deyimlerTablosuOlusturma);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + deyimler_tablosu);
    }

    public long kaydetDeyim(Deyimler deyimler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IngDeyim", deyimler.getIng());
        cv.put("TrDeyim", deyimler.getTr());
        long id = db.insert(deyimler_tablosu, null, cv);
        return id;
    }

    public List<Deyimler> getirDeyimlerListesi() {
        List<Deyimler> deyimlerList = new ArrayList<Deyimler>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlSorgusu = "Select * from " + deyimler_tablosu;
        Cursor c = db.rawQuery(sqlSorgusu, null);
        int siraNoID = c.getColumnIndex("ID");
        int siraNoIng = c.getColumnIndex("IngDeyim");
        int siraNoTR = c.getColumnIndex("TrDeyim");
        try {
            while (c.moveToNext()) {
                Deyimler _deyimler = new Deyimler();
                _deyimler.setId(c.getInt(siraNoID));
                _deyimler.setIng(c.getString(siraNoIng));
                _deyimler.setTr(c.getString(siraNoTR));
                deyimlerList.add(_deyimler);
            }
        } finally {
            c.close();
            db.close();
        }
        return deyimlerList;
        }
    }


