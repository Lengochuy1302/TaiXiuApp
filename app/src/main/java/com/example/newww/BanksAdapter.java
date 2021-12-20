package com.example.newww;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BanksAdapter extends BaseAdapter {
   private Context context;
   int myLayout;
   private List<Nganhang> banksList;

    public BanksAdapter(Context context, int myLayout, List<Nganhang> banksList) {
        this.context = context;
        this.myLayout = myLayout;
        this.banksList = banksList;
    }

    @Override
    public int getCount() {
        return banksList.size();

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);

//        View rootView  = LayoutInflater.from(context).inflate(R.layout.support_simple_spinner_dropdown_item,convertView,false);

        TextView txt_matk = (TextView) convertView.findViewById(R.id.txt_matk);



        txt_matk.setText(banksList.get(position).getSotaikhoan());




        return convertView;
    }
}
