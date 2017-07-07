package com.nh31gmail.natthiya.hw;

/**
 * Created by Natth on 11/24/2016.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by P on 03-Nov-16.
 */
public class PersonAdapter extends BaseAdapter {
    Activity activity;
    List<Person> lstPerson;
    LayoutInflater inflater;
    EditText editID , editName , editEmail;

    public PersonAdapter(Activity activity, List<Person> lstPerson, LayoutInflater inflater, EditText editID, EditText editName, EditText editEmail){
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
    public Object getItem(int position) {
        return lstPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstPerson.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.row,null);
        final TextView txtRowID,txtRowName,txtRowEmail;
        txtRowID = (TextView)rowView.findViewById(R.id.txtRowID);
        txtRowName = (TextView)rowView.findViewById(R.id.txtRowName);
        txtRowEmail = (TextView)rowView.findViewById(R.id.txtRowEmail);

        txtRowID.setText(""+lstPerson.get(position).getId());
        txtRowName.setText(""+lstPerson.get(position).getName());
        txtRowEmail.setText(""+lstPerson.get(position).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editID.setText(""+txtRowID.getText());
                editName.setText(""+txtRowName.getText());
                editEmail.setText(""+txtRowEmail.getText());

            }
        });
        return rowView;
    }
}
