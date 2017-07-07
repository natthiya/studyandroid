package com.nh31gmail.natthiya.natthiya9122016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natth on 11/5/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    static final int DATABASE_VER = 1;
    static final String DATABASE_NAME = "BasicSQLiteExmple";
    static final  String TABLE_NAME= "Person";

    static final  String KEY_NAME= "Name";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME+"("

                + KEY_NAME + " TEXT)";

        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);


    }



    public void addPerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME,person.getName());


        db.insert(TABLE_NAME,null,values);
        db.close();
    }


    public List<Person> getAllPerson(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Person> lstPerson = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor curson = db.rawQuery(sql,null);
        if (curson.moveToFirst()){
            do{
                Person person = new Person();
                person.setName(curson.getString(0));

                lstPerson.add(person);
            }while (curson.moveToNext());
        }
        return lstPerson;
    }
}
