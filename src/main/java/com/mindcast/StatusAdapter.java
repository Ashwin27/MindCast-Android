package com.mindcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StatusAdapter extends ArrayAdapter<Status> {
    private Context context;

    public StatusAdapter(Context context, int textViewResourceId, ArrayList<Status> items) {
        super(context, textViewResourceId, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_main, (RelativeLayout)((MainActivity)context).findViewById(R.id.statusList));
        }

        Status item = getItem(position);
        if (item!= null) {
            // My layout has only one TextView
            TextView itemView = (TextView) view.findViewById(R.id.statusMessage);
            if (itemView != null) {
                // do whatever you want with your string and long
                itemView.setText(item.getStatus());
            }
        }

        return view;
    }
}
