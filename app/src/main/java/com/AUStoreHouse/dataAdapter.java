package com.AUStoreHouse;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class dataAdapter extends ArrayAdapter<data> {

    public dataAdapter(Activity context, ArrayList<data> data) {

        super(context, 0, data);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.datalist, parent, false);
        }
        data curperson = getItem(position);

        TextView fileName = listItemView.findViewById(R.id.data);
        fileName.setText(curperson.getFileName());

        return listItemView;


    }
}
