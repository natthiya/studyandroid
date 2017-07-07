package com.nh31gmail.natthiya.natthiya09122016;

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

public class Main2Activity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gestureObject = new GestureDetectorCompat(this,new MyGesture());

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() < e2.getX()) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                finish();
                startActivity(intent);

            }
            return true;
        }
    }
}