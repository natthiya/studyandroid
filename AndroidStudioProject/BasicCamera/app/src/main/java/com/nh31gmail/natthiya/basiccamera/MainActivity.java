package com.nh31gmail.natthiya.basiccamera;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
//import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView);
        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File imageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String fileName = getFileName();
                File imageFile = new File(imageDirectory,fileName);
                Uri imageUri = Uri.fromFile(imageFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);


                startActivityForResult(intent,0);

            }

        });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 0){
           // Bitmap image = (Bitmap) data.getExtras().get("data");
           // imageView.setImageBitmap(image);

        }
    }

    String getFileName(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date()
        );
        return "class_mobile_programmimg_"+timestamp+".jpg";
    }
}
