package com.nh31gmail.natthiya.camera;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
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
    static final int CAM_RE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView);
        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));


                startActivityForResult(camera_intent,CAM_RE);

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       String path = "sdcard/camera/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));

    }

    private File getFile() {
        File folder = new File("sdcard/camera");
        if (!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");
        return image_file;
    }



}