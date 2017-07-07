package com.nh31gmail.natthiya.basicsolite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Natth on 11/4/2016.
 */
public class PersonAdapter extends BaseAdapter {
    Activity activity;
    List<Person> lstPerson;
    LayoutInflater inflater;
    EditText editID;
    EditText editName;
    EditText editEmail;


    public PersonAdapter(Activity activity, List<Person> lstPerson, LayoutInflater inflater, EditText editID, EditText editName, EditText editEmail) {
        this.activity = activity;
        this.lstPerson = lstPerson;
        this.inflater = inflater;
        this.editID = editID;
        this.editName = editName;
        this.editEmail = editEmail;
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
        return lstPerson.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;
        rowView = inflater.inflate(R.layout.row,null);
        final TextView txtRowID,txtRowNAME,txtRowEMAIL;
        txtRowID = (TextView)rowView.findViewById(R.id.txtRowID);
        txtRowNAME = (TextView)rowView.findViewById(R.id.txtRowName);
        txtRowEMAIL = (TextView)rowView.findViewById(R.id.txtRowEmail);

        txtRowID.setText(""+lstPerson.get(i).getId());
        txtRowNAME.setText(""+lstPerson.get(i).getName());
        txtRowEMAIL.setText(""+lstPerson.get(i).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editID.setText(""+txtRowID.getText());
                editName.setText(""+txtRowNAME.getText());
                editEmail.setText(""+txtRowEMAIL.getText());
            }
        });
        return rowView;


    }
}
