package com.example.sqlitepractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class DataDisplay extends AppCompatActivity {
    ListView list;
//    ArrayList<ContactModel> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        Intent userdetails = new Intent(getApplicationContext(),UserDetails.class);
//        Log.d("ContactInfo", "check7");
        Databasep db = new Databasep(this);
        ArrayList<ContactModel> l = db.fetchdata();
        ArrayList<String > name = new ArrayList<>();
        for(int i=0;i<l.size();i++) name.add(l.get(i).name);
//            Log.d("ContactInfo", name.get(i));
        list = findViewById(R.id.listview);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
        list.setAdapter(adp);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ArrayList<ContactModel> u = db.fetchdata();
                for (int i=0;i< u.size();i++)
                {
                    if(i==position)
                    {
                        userdetails.putExtra("ID",u.get(i).id+"");
                        userdetails.putExtra("NAME",u.get(i).name);
                        userdetails.putExtra("SURNAME",u.get(i).surname);
                        userdetails.putExtra("GENDER",u.get(i).gender);
                        userdetails.putExtra("AGE",u.get(i).age);
                        userdetails.putExtra("PHONE",u.get(i).phone);
                        startActivity(userdetails);
                    }
                }
            }
        });
//        Log.d("ContactInfo", "check9");
        Intent nexpage = new Intent(getApplicationContext(),MainActivity.class);
        Button add = findViewById(R.id.addentry);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nexpage);
            }
        });
    }
}