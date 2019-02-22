package com.example.android.facease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uttsikha on 1/22/2018.
 */

public class listview extends BaseAdapter {

    Context context;
    ArrayList<String> FDID;
    ArrayList<String> FDName;
    ArrayList<String> FDQTY;
    ArrayList<String> FDUnit ;
    ArrayList<String> Alt ;


    public listview(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> qty,
            ArrayList<String> unit,
            ArrayList<String> alt
    ) {

        this.context = context2;
        this.FDID = id;
        this.FDName = name;
        this.FDQTY = qty;
        this.FDUnit = unit ;
        this.Alt = alt ;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return FDID.size();
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

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listview, null);

            holder = new Holder();

            holder.textviewid = (TextView) child.findViewById(R.id.textID);
            holder.textviewname = (TextView) child.findViewById(R.id.textName);
            holder.textviewqty = (TextView) child.findViewById(R.id.textQty);
            holder.textviewunit = (TextView) child.findViewById(R.id.textUnit);
            holder.textviewalt = (TextView) child.findViewById(R.id.textAlt);

            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.textviewid.setText(FDID.get(position));
        holder.textviewname.setText(FDName.get(position));
        holder.textviewqty.setText(FDQTY.get(position));
        holder.textviewunit.setText(FDUnit.get(position));

        holder.textviewalt.setText(Alt.get(position));

        return child;
    }

    public class Holder {
        TextView textviewid;
        TextView textviewname;
        TextView textviewqty;
        TextView textviewunit;
        TextView textviewalt;
    }


}
