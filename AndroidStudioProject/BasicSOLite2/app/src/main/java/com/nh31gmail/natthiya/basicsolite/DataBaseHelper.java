package com.nh31gmail.natthiya.basicsolite;

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
    static final  String KEY_ID= "ID";
    static final  String KEY_NAME= "Name";
    static final  String KEY_EMAIL= "Email";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME+"("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT )";
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
        values.put(KEY_ID,person.getId());
        values.put(KEY_NAME,person.getName());
        values.put(KEY_EMAIL,person.getEmail());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public  int updatePerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,person.getName());
        values.put(KEY_EMAIL,person.getEmail());

        return db.update(TABLE_NAME,values,KEY_ID + " =?",new  String[]{
                String.valueOf(person.getId())
        });
    }
    public  void deletePerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID + " =?",new String[]{
                String.valueOf(person.getId())
        });
        db.close();
    }
   public  Person getPerson(int id){
       SQLiteDatabase db = this.getWritableDatabase();
       Cursor cursor = db.query(
               TABLE_NAME,
               new String[]{KEY_ID,KEY_NAME,KEY_EMAIL},
               KEY_ID + " =?",
               new String[]{String.valueOf(id)},null,null,null,null);
       if (cursor != null)
           cursor.moveToFirst();
       return  new Person(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
   }
    public List<Person> getAllPerson(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Person> lstPerson = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor curson = db.rawQuery(sql,null);
        if (curson.moveToFirst()){
            do{
                Person person = new Person();
                person.setId(curson.getInt(0));
                person.setName(curson.getString(1));
                person.setEmail(curson.getString(2));
                lstPerson.add(person);
            }while (curson.moveToNext());
        }
        return lstPerson;
    }
}
