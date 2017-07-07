package com.nh31gmail.natthiya.basicsolite;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editID;
    EditText editName;
    EditText editEmail;
    Button btnAdd;
    Button btnUpdate;
    Button btnDelete;
    ListView lstPerson;
    List<Person> data;
    DataBaseHelper db;

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureObject = new GestureDetectorCompat(this,new MyGesture());

        data = new ArrayList<>();
        db = new DataBaseHelper(this);
        btnAdd =(Button)findViewById(R.id.btnAdd);
        btnUpdate =(Button)findViewById(R.id.btnUpdate);
        btnDelete =(Button)findViewById(R.id.btnDelete);

        lstPerson =(ListView) findViewById(R.id.list);

        editID =(EditText) findViewById(R.id.editID);
        editName =(EditText) findViewById(R.id.editName);
        editEmail =(EditText) findViewById(R.id.editEmail);

        refreshData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();
                person.setId(Integer.parseInt(editID.getText().toString()));
                person.setName(editName.getText().toString());
                person.setEmail(editEmail.getText().toString());
                db.addPerson(person);
                refreshData();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();
                person.setId(Integer.parseInt(editID.getText().toString()));
                person.setName(editName.getText().toString());
                person.setEmail(editEmail.getText().toString());
                db.updatePerson(person);
                refreshData();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();
                person.setId(Integer.parseInt(editID.getText().toString()));
                person.setName(editName.getText().toString());
                person.setEmail(editEmail.getText().toString());
                db.deletePerson(person);
                refreshData();
            }
        });



    }
    void refreshData(){
        data = db.getAllPerson();
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,inflater,editID,editName,editEmail);
        lstPerson.setAdapter(adapter);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() >e2.getX()) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                finish();
                startActivity(intent);

            }
            return true;
        }
    }
}


