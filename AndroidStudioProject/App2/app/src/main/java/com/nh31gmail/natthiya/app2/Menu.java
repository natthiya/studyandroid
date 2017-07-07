package com.nh31gmail.natthiya.app2;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Natth on 10/20/2016.
 */
public class Menu extends Fragment{
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] text;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        listView = (ListView)view.findViewById(R.id.list_view);
        text = getResources().getStringArray(R.array.my_colors);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_view_layout,R.id.row_item,text);
        listView.setAdapter(adapter);
        return view;
    }
}
