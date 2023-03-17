package com.example.sqlitepractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String filename="";
    String filecontent="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        filename = "CRICKET.sql";
        Intent nextpage = new Intent(getApplicationContext(),DataDisplay.class);
        Databasep db = new Databasep(this);
        Log.d("ContactInfo", "check8");
//        db.deleteDatatable();
//        Log.d("ContactInfo ","Check1");
//        db.addContact("Rushi","Swami","Male","20","9876594320");
//        db.addContact("Ram","Swami","Male","20","8654567960");
//        db.addContact("Vikram","Swami","Male","16","9124594320");
//        db.addContact("Vijay","Swami","Male","23","956775320");
//        ArrayList<ContactModel> l = db.fetchdata();
//        for(int i=0;i<l.size();i++)
//        {
//            Log.d("ContactInfo "," ID: "+ l.get(i).id + " Name: "+l.get(i).name +" Phone: "+l.get(i).phone);
//        }
        TextView name = findViewById(R.id.textName);
        TextView surname = findViewById(R.id.textSurname);
        TextView gender = findViewById(R.id.textGender);
        TextView age = findViewById(R.id.textAge);
        TextView phone_no = findViewById(R.id.textPhone);
        Button sumbit = findViewById(R.id.submit);
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString()!="" && surname.getText().toString()!=""
                        && gender.getText().toString()!="" && age.getText().toString()!="" && phone_no.getText().toString().length()==10)
                {
                    db.addContact(name.getText().toString(),
                            surname.getText().toString(),
                            gender.getText().toString(),
                            age.getText().toString(),
                            phone_no.getText().toString());
                    Log.d("ContactInfo", "check7");
                    startActivity(nextpage);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Enter Valid data", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button detail = findViewById(R.id.details);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                File myExternalFile = new File(getExternalFilesDir("DataBaseTry"),filename);
//                FileOutputStream fos = null;
//                try {
//                    fos = openFileOutput("Check.txt",MODE_PRIVATE);
//                    fos.write("Hello".getBytes());
//
//                    Toast.makeText(MainActivity.this, "Saved successful saved to"+
//                            getFilesDir()+"/"+filename, Toast.LENGTH_SHORT).show();
//                    Log.d("ContactInfo",getFilesDir()+"");
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
                startActivity(nextpage);

            }
        });
    }
}