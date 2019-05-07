package com.example.macomputer.databasesql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText e1,e2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.password);
        button=findViewById(R.id.log);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.log){
            if (e1.getText().toString().equals("marwa")&&e2.getText().toString().equals("abc")){
                Intent addemployeeintent=new Intent(this,AddEmployee.class);
                startActivity(addemployeeintent);
            }
            else{
                Toast.makeText(this,"not matching",Toast.LENGTH_LONG).show();
            }
        }

    }
}
