package com.example.helomyblair;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListVIewActivity extends AppCompatActivity {

    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listview = findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("this");
        arrayList.add("is ");
        arrayList.add("Android");
        arrayList.add("programming");
        arrayList.add("welcome");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(arrayAdapter);

        // adding a listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(ListVIewActivity.this,"clicked item"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
