package com.example.macomputer.databasesql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StroreAdapter extends ArrayAdapter<Strore> {
    private ArrayList<Strore> strores;
    private Context context;
    public StroreAdapter(@NonNull Context context, @NonNull ArrayList<Strore> strores) {
        super(context, R.layout.listview_design, strores);
        this.strores=strores;
        this.context=context;
    }



    @Override
    public int getCount() {
        return strores.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.listview_design,parent,false);
        TextView id=view.findViewById(R.id.id);
        TextView name=view.findViewById(R.id.name);
        TextView job=view.findViewById(R.id.job);
        id.setText(String.valueOf(strores.get(position).getId()));
        name.setText(strores.get(position).getName());
        job.setText(strores.get(position).getJob());

        return view;
    }
}
