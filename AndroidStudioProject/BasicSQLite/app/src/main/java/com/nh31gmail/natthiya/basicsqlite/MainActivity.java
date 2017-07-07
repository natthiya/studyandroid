package com.nh31gmail.natthiya.basicsqlite;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText editName;

    Button btnAdd;

    ListView lstPerson;
    List<Person> data;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        db = new DataBaseHelper(this);
        btnAdd =(Button)findViewById(R.id.btnAdd);


        lstPerson =(ListView) findViewById(R.id.list);


        editName =(EditText) findViewById(R.id.editName);


        refreshData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();

                person.setName(editName.getText().toString());

                db.addPerson(person);
                refreshData();
            }
        });

    }
    void refreshData(){
        data = db.getAllPerson();
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,inflater,editName);
        lstPerson.setAdapter(adapter);
    }

}
