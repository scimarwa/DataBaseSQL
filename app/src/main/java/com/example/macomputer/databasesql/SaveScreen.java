package com.example.macomputer.databasesql;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveScreen extends AppCompatActivity implements View.OnClickListener {
    private EditText et1,et2,et3;
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_screen);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        btn=findViewById(R.id.save);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.save){
            Strore s=new Strore(Integer.parseInt(et1.getText().toString()),et2.getText().toString(),et3.getText().toString());
            DatabaseHelper helper=new DatabaseHelper(this);
            helper.addStore(s);
            Intent empInt=new Intent(this,AddEmployee.class);
            startActivity(empInt);
        }
    }
}
