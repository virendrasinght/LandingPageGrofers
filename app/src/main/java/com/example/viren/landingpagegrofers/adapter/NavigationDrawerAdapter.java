package com.example.viren.landingpagegrofers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.viren.landingpagegrofers.R;

import java.util.ArrayList;

/**
 * Created by Viren on 8/26/2016.
 */
public class NavigationDrawerAdapter extends BaseAdapter {
    Context mcontext;
    ArrayList<String> names;
    LayoutInflater inflater;
    public NavigationDrawerAdapter(Context context, ArrayList<String> productname){
        mcontext=context;
        names=productname;
        inflater = (LayoutInflater) mcontext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.size();
    }

    @Override
    public long getItemId(int position) {
        return names.size();
    }
    public class Holder {
        TextView txtCrewName;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView=inflater.inflate(R.layout.item_list,null);
        holder.txtCrewName=(TextView) rowView.findViewById(R.id.text_list);
        holder.txtCrewName.setText(names.get(position));
        return rowView;
    }
}
