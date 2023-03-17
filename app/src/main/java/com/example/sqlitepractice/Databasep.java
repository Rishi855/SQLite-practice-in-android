package com.example.sqlitepractice;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class Databasep extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CRICKET";
    private static final int DATABASE_ID = 1;
    private static final String TABLE_CONTACT  = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SURNAME = "surname";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_AGE = "age";
    private static final String KEY_PHONE_NO = "phone_no";

    //, @Nullable String name
    public Databasep(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_ID);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
//        Log.d("ContactInfo ","Check");
        db.execSQL("CREATE TABLE " + TABLE_CONTACT + " ( "+
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME + " TEXT,"+
                KEY_SURNAME + " TEXT,"+
                KEY_GENDER + " TEXT,"+
                KEY_AGE + " TEXT,"+
                KEY_PHONE_NO + " TEXT "+ ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
//        Log.d("ContactInfo ","Check2");
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_CONTACT);
        onCreate(db);
    }
    public void addContact(String name,String surname, String gender, String age ,String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(KEY_NAME,name);
        val.put(KEY_SURNAME,surname);
        val.put(KEY_GENDER,gender);
        val.put(KEY_AGE,age);
        val.put(KEY_PHONE_NO,phone);

        db.insert(TABLE_CONTACT,null,val);
    }
    public ArrayList<ContactModel> fetchdata()
    {
//        Log.d("ContactInfo ","Check4");
        ArrayList<ContactModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
//        Log.d("ContactInfo ","Check5");

        Cursor cur = db.rawQuery("SELECT * FROM "+TABLE_CONTACT,null);
//        Log.d("ContactInfo ","Check6");

        while(cur.moveToNext())
        {
            ContactModel model = new ContactModel();
            model.id = cur.getInt(0);
            model.name = cur.getString(1);
            model.surname=cur.getString(2);
            model.gender=cur.getString(3);
            model.age=cur.getString(4);
            model.phone = cur.getString(5);
//            Log.d("ContactInfo ","Check");

            list.add(model);
        }
        return list;
    }

    public void updateData(int id,String name,String surname,String gender,String age,String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("here1 ",id+" "+name);
        String str = "UPDATE "+TABLE_CONTACT+
                " SET "+KEY_NAME +" = '"+name+"'"+
//                KEY_SURNAME +" = "+surname+
//                KEY_GENDER +" = "+gender+
//                KEY_AGE +" = "+age+
//                KEY_PHONE_NO+" = "+phone+
                " WHERE "+KEY_ID+" = "+id;
        Log.d("here1",str);
        db.execSQL(str);

    }
    public void deleteDatatable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE "+TABLE_CONTACT);
        Log.d("ContactInfo ","Deleted");
    }

}
