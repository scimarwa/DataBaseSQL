package com.example.macomputer.databasesql;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class AddEmployee extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private ListView listView;
    private Button button;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee);
        imageView=findViewById(R.id.image);
        button=findViewById(R.id.add);
        imageView.setOnClickListener(this);
        button.setOnClickListener(this);

        Strore s=new Strore(2,"nour","accountant");
        DatabaseHelper helper=new DatabaseHelper(this);
    // helper.addStore(s);
        ArrayList<Strore> stores=helper.getAllStores();
        for(int i=0;i<stores.size();i++){
            listView=findViewById(R.id.lv);
            StroreAdapter adapter=new StroreAdapter(this,stores);
            listView.setAdapter(adapter);

        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.image){
            Intent mainIntent=new Intent(this,MainActivity.class);
            startActivity(mainIntent);
        }
        if (v.getId()==R.id.add){
            Intent saveIntent=new Intent(this,SaveScreen.class);
            startActivity(saveIntent);

        }

    }
}
