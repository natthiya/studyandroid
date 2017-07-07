package com.nh31gmail.natthiya.basicsqlite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Natth on 11/3/2016.
 */
public class PersonAdapter extends BaseAdapter {
    Activity activity;
    List<Person> lstPerson;
    LayoutInflater inflater;
    EditText editName;



    public PersonAdapter(Activity activity, List<Person> lstPerson, LayoutInflater inflater, EditText editName) {
        this.activity = activity;
        this.lstPerson = lstPerson;
        this.inflater = inflater;

        this.editName = editName;

    }



    @Override
    public int getCount() {
        return lstPerson.size();
    }

    @Override
    public Object getItem(int i) {
        return lstPerson.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;
        rowView = inflater.inflate(R.layout.row,null);
        final TextView txtRowNAME;

        txtRowNAME = (TextView)rowView.findViewById(R.id.txtRowName);



        txtRowNAME.setText(""+lstPerson.get(i).getName());


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editName.setText(""+txtRowNAME.getText());

            }
        });
        return rowView;


    }
}
