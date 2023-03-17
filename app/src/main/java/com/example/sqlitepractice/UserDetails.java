package com.example.sqlitepractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Intent get = getIntent();
        String id = get.getStringExtra("ID");
        String name = get.getStringExtra("NAME");
        String surname = get.getStringExtra("SURNAME");
        String gender = get.getStringExtra("GENDER");
        String age = get.getStringExtra("AGE");
        String phone = get.getStringExtra("PHONE");

        TextView idt =findViewById(R.id.textIdU);
        EditText namet = findViewById(R.id.textNameU);
        namet.setEnabled(false);
        EditText surnamet = findViewById(R.id.textSurnameU);
        surnamet.setEnabled(false);
        EditText gendert = findViewById(R.id.textGenderU);
        gendert.setEnabled(false);
        EditText aget = findViewById(R.id.textAgeU);
        aget.setEnabled(false);
        EditText phonet = findViewById(R.id.textPhoneU);
        phonet.setEnabled(false);

        idt.setText(""+id);
        namet.setText(""+name);
        surnamet.setText(""+surname);
        gendert.setText(""+gender);
        aget.setText(""+age);
        phonet.setText(""+phone);

        Intent nextpage = new Intent(getApplicationContext(),MainActivity.class);
        Button add = findViewById(R.id.addentryU);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nextpage);
            }
        });

//        Intent details = new Intent(getApplicationContext(),DataDisplay.class);
        Button edit = findViewById(R.id.editU);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namet.setEnabled(true);
                surnamet.setEnabled(true);
                gendert.setEnabled(true);
                aget.setEnabled(true);
                phonet.setEnabled(true);
            }
        });

        Button update = findViewById(R.id.updateU);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ok2","here 1");
              int id = Integer.parseInt(idt.getText().toString()+"");
              Databasep dp = new Databasep(getApplicationContext());
              String name = namet.getText().toString().trim().toLowerCase();
              String surname = surnamet.getText().toString().trim().toLowerCase();
              String gender = gendert.getText().toString().trim().trim().toLowerCase();
              String age = aget.getText().toString().trim().toLowerCase();
              String phone = phonet.getText().toString().trim().toLowerCase();
              dp.updateData(id,name,surname,gender,age, phone);
            }
        });

    }
}