package com.tecc0.urlimagetogridview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.tecc0.urlimagetogridview.data.HomeGridAdapter;
import com.tecc0.urlimagetogridview.data.ItemData;
import com.tecc0.urlimagetogridview.JsonManager;
import com.tecc0.urlimagetogridview.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by makotonishimoto on 2015/10/11.
 */
public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_main2, null);

        //読み込むJsonファイルの指定
        InputStream inputStream = getResources().openRawResource(R.raw.windows);

        JsonManager jsonManager = new JsonManager(inputStream);
        ArrayList<ItemData> itemDataList = jsonManager.getItemDataList();

        GridView gridView = (GridView)v.findViewById(R.id.gridview2);
        ArrayAdapter<ItemData> adapter = new HomeGridAdapter(getContext(), R.layout.item, itemDataList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message = position + 1 + " is clicked";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
