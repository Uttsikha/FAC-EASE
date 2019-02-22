package com.example.android.facease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uttsikha on 1/23/2018.
 */

public class listview22 extends BaseAdapter

    {

        Context context;
        ArrayList<String> FDName;
        ArrayList<String> FDQTY;
        ArrayList<String> FDUnit ;


    public listview22(
            Context context2,
            ArrayList<String> name,
            ArrayList<String> qty,
            ArrayList<String> unit
    ) {

        this.context = context2;
        this.FDName = name;
        this.FDQTY = qty;
        this.FDUnit = unit ;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return FDName.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        listview22.Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listview22, null);

            holder = new Holder();

            holder.textviewname = (TextView) child.findViewById(R.id.textView2);
            holder.textviewqty = (TextView) child.findViewById(R.id.textView3);
            holder.textviewunit = (TextView) child.findViewById(R.id.textView4);

            child.setTag(holder);

        } else {

            holder = (listview22.Holder) child.getTag();
        }
        holder.textviewname.setText(FDName.get(position));
        holder.textviewqty.setText(FDQTY.get(position));
        holder.textviewunit.setText(FDUnit.get(position));

        return child;
    }

    public class Holder {
        TextView textviewname;
        TextView textviewqty;
        TextView textviewunit;
    }


}
