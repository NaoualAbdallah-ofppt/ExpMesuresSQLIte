package com.example.mesuressqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.GregorianCalendar;

public class SaveActivity extends AppCompatActivity {
TextView txt;
EditText ETP;
Button btn1,btn2;
Date D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        txt=(TextView)findViewById(R.id.txtAccueil);
        ETP=(EditText)findViewById(R.id.txtPoids);
        btn1=(Button) findViewById(R.id.btnEnregistrer);
        btn2=(Button) findViewById(R.id.btnQuitter);
        D = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(D);
        int mois=calendar.get(GregorianCalendar.MONTH) + 1;
        int annee=calendar.get(GregorianCalendar.YEAR) ;
        int jour=calendar.get(GregorianCalendar.DATE);

txt.setText("Bonjour\nNous sommes le " + jour+"/" + mois +"/" + annee);
ETP.requestFocus();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Mesure M = new Mesure(D,Float.parseFloat(ETP.getText().toString()));
BDMesure BD = new BDMesure(getApplicationContext());
BD.ajouter(M);
                Toast.makeText(getApplicationContext(),"Mesure ajoutée", Toast.LENGTH_SHORT).show();
                CountDownTimer CDT = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        finish();
                    }
                };
         CDT.start();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
