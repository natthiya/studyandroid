package com.nh31gmail.natthiya.gesture;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            if (e1.getX() >e2.getX()) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                finish();
                startActivity(intent);

            }
            return true;
        }
    }
}
