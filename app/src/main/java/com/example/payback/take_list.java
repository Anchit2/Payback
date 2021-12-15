package com.example.payback;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class take_list extends AppCompatActivity {
    DatabaseHelperToTake mydb;
    ArrayList<Listvalues> arrayListtake;
    ListView listViewtake;
    Listvalues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_list);

        mydb= new DatabaseHelperToTake(this);

        arrayListtake= new ArrayList<>();
//        TextView textView=findViewById(R.id.amountinlist);
//        TextView textView2=findViewById(R.id.forinlist);
//        TextView textView3=findViewById(R.id.dateinlist);

        Cursor data =mydb.getalldata();
        int noofitem =data.getCount();
        if (noofitem==0){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }else{
            int i=0;
            while (data.moveToNext()){
                values= new Listvalues(data.getString(0),data.getString(1),data.getString(2));
                arrayListtake.add(i,values);
                i++;
            }

            list_adaptor adaptor = new list_adaptor(this, R.layout.listdesign,arrayListtake);
            listViewtake=findViewById(R.id.listviewtake);
            listViewtake.setAdapter(adaptor);
        }
    }
}