package com.example.payback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class list_adaptor extends ArrayAdapter<Listvalues> {
    private LayoutInflater layoutInflater;
    private ArrayList<Listvalues> arrayList;



    public list_adaptor(@NonNull Context context, int resource, ArrayList<Listvalues> arrayList) {
        super(context, resource, arrayList);
        this.arrayList=arrayList;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public Listvalues getItem(int Position) {
        return arrayList.get(Position);
    }

    public View getView(int position, View convertview, ViewGroup parents){
        convertview =LayoutInflater.from(getContext()).inflate(R.layout.listdesign,parents,false);
        Listvalues values =arrayList.get(position);
        if (values!=null){
            TextView date=(TextView) convertview.findViewById(R.id.dateinlist);
            TextView forr=(TextView)convertview.findViewById(R.id.forinlist);
            TextView amount=(TextView)convertview.findViewById(R.id.amountinlist);

            if (date !=null){
                date.setText(values.getDate());
            }
            if (forr !=null){
                forr.setText(values.getForr());
            }
            if (amount !=null){
                amount.setText(values.getAmount());
            }
        }
        return convertview;
    }
}
