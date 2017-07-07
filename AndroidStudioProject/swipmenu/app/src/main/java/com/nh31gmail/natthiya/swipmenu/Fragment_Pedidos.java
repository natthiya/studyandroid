package com.nh31gmail.natthiya.swipmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Natth on 11/13/2016.
 */
public class Fragment_Pedidos extends Fragment {

    View rootView;
    int contador = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_pedidos, container, false);
        TextView texto = (TextView) rootView.findViewById(R.id.texto_pedidos);
        texto.setText("Incrementador de Pedidos" + "\n\n" + contador);
        contador++;

        return rootView;
    }
}