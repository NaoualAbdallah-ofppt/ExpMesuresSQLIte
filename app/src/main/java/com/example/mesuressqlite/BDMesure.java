package com.example.mesuressqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class BDMesure {
    MyHelper H;
    SQLiteDatabase db;

    public BDMesure(Context C) {
        H= new MyHelper(C,"MesMesures", null,1);

    }
    public void ajouter(Mesure M)
    {
      db=H.getWritableDatabase();
GregorianCalendar GC= new GregorianCalendar();
GC.setTime(M.getDateM());
Long L =GC.getTimeInMillis();

      db.execSQL("insert into Mesure values(" + L + "," + M.getPoidsM() + ")");

    }
    public  ArrayList<Mesure> getListe()
    {
        ArrayList<Mesure> AL = new ArrayList<Mesure>();



        db=H.getReadableDatabase();

        Cursor cur = db.rawQuery("select * from Mesure",null);
        cur.moveToFirst();
        while (!cur.isAfterLast()) {

            Long L=cur.getLong(0);

            Date D=  new Date(L);
            Float P = cur.getFloat(1);

            Mesure M = new Mesure(D,P);


            AL.add(M);
            cur.moveToNext();

        }
        cur.close();



        return  AL;
    }
}
