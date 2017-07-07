package com.nh31gmail.natthiya.hw;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
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

    ImageView imageView;
    static final int CAM_RE = 1;


    void refreshData(){
        data = db.getAllPerson();
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,inflater,editID,editName,editEmail);
        lstPerson.setAdapter(adapter);
    }

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



