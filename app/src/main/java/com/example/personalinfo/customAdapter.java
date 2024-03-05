package com.example.personalinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends BaseAdapter {


    private String account_list[];
    private int account_icons[];
    Context context;

    public customAdapter(String[] account_list, int[] account_icons, Context context) {
        this.account_list = account_list;
        this.account_icons = account_icons;
        this.context = context;
    }


    @Override
    public int getCount() {
        return account_list.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_listview_acc, null);

        ImageView image = (ImageView) view.findViewById(R.id.icons_account);
        TextView text_flag = (TextView)view.findViewById(R.id.text_data);

        image.setImageResource(account_icons[position]);
        text_flag.setText(account_list[position]);

        return view;
    }
}
