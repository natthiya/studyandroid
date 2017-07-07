package com.nh31gmail.natthiya.swipmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Natth on 11/13/2016.
 */
public class Fragment_Productos extends Fragment {
    View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_productos, container, false);
        return rootView;
    }
}