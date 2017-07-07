package com.nh31gmail.natthiya.app2test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Natth on 10/23/2016.
 */
public class Content extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
      return  inflater.inflate(R.layout.fragmemt_content,container,false);

    }
}
