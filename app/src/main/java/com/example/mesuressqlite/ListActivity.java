package com.example.mesuressqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
Button btn;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
btn=(Button) findViewById(R.id.btnQuitter);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
        BDMesure BD = new BDMesure(getApplicationContext());
        ArrayList<Mesure> AL = BD.getListe();

        ArrayAdapter AA = new ArrayAdapter(this,android.R.layout.simple_list_item_1,AL);
Intent it=getIntent();

lv=(ListView) findViewById(R.id.lvMesures);
        lv.setAdapter(AA);
    }
}
