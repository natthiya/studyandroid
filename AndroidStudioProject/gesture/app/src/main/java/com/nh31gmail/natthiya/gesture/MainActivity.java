package com.nh31gmail.natthiya.gesture;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = MediaPlayer.create(this,R.raw.sound0614);
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
            if (e1.getX() >e2.getX()){
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                finish();
                startActivity(intent);

                if (sound.isPlaying()){
                    sound.stop();
                }
            }else if (e1.getX() < e2.getX()){
                sound.start();
            }
            return true;
        }
    }
}
