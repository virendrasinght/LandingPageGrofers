package com.example.viren.landingpagegrofers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.viren.landingpagegrofers.R;

/**
 * Created by Viren on 8/26/2016.
 */
public class ExpandableGvAdapter extends BaseAdapter {
    String[] result;
    Context mcontext;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public ExpandableGvAdapter(Context context, int[] productImg) {
        mcontext = context;
        imageId = productImg;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
rowView=inflater.inflate(R.layout.item_gridview,null);
        holder.img=(ImageView) rowView.findViewById(R.id.expgvimg);
        holder.img.setImageResource(imageId[position]);
    return rowView;
    }
}
