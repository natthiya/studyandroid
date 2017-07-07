package com.nh31gmail.natthiya.natthiya9122016;

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
    private GestureDetectorCompat gestureObject;

    EditText editName;
    Button btnAdd;
    ListView lstPerson;
    List<Person> data;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this,new MyGesture());

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

    void refreshData(){
        data = db.getAllPerson();
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,inflater,editName);
        lstPerson.setAdapter(adapter);
    }


}



