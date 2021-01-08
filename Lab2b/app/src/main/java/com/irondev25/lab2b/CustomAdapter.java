package com.irondev25.lab2b;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;



public class CustomAdapter  extends BaseAdapter {
    Context context;
    ArrayList<Item> feedList;

    public CustomAdapter(Context context, ArrayList<Item> data){
        this.context=context;
        this.feedList = data;
    }

    @Override
    public int getCount() {
        return feedList.size();
    }

    @Override
    public Object getItem(int position) {
        return feedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final Holder holder;
        Item data = MainActivity.items.get(position);

        if(view == null){
            holder = new Holder();
//            LayoutInflater inflater =
//                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//            view = inflater.inflate(R.layout.listview_item,null);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item,parent,false);
            view.setTag(holder);
            holder.item = view.findViewById(R.id.item);
            holder.price = view.findViewById(R.id.price);
            holder.qty = view.findViewById(R.id.qty);

        }
        else{
            holder = (Holder)view.getTag();
        }

        holder.item.setText(data.getName());
        holder.price.setText(Integer.toString(data.getPrice()));
        holder.qty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int qt = Integer.parseInt(holder.qty.getText().toString());
                MainActivity.items.get(position).setQuantity(qt);
            }
        });
        return  view;
    }

    private class Holder {
        TextView item;
        TextView price;
        EditText qty;
    }
}
