package com.example.personalinfo;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyAccountFragment extends Fragment {


    private ListView acc_listview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String account_list[] = {
                "Account Settings",
                "Messages",
                "My Orders",
                "My Coupons",
                "Online Payments",
                "Change Location"
        };

        int account_icons[] = {
                R.drawable.account_settings,
                R.drawable.messages,
                R.drawable.my_orders,
                R.drawable.my_coupon,
                R.drawable.online_payment,
                R.drawable.location_pin_svgrepo_com

        };


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);

        ListView accList = (ListView) view.findViewById(R.id.account_list);
        customAdapter base = new customAdapter(account_list, account_icons, getActivity());
        accList.setAdapter(base);


        return view;


    }
}