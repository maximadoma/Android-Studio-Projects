package com.example.personalinfo;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ExploreFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_explore, container, false);

        //button view
        Button viewMore = (Button) view.findViewById(R.id.view_more_btn);


        //card view
        CardView showCard1 = (CardView) view.findViewById(R.id.classic_catfood);
        CardView showCard2 = (CardView) view.findViewById(R.id.friskies_catfood);
        CardView showCard3 = (CardView) view.findViewById(R.id.applaws_catfood);
        CardView showCard4 = (CardView) view.findViewById(R.id.purina_catfood);

        CardView cat_food = (CardView) view.findViewById(R.id.catfood_card);
        CardView pet_care = (CardView) view.findViewById(R.id.pet_care_card);
        CardView accessory = (CardView) view.findViewById(R.id.accessory_card);
        CardView cat_shampoo = (CardView) view.findViewById(R.id.cat_shampoo_card);
        CardView cat_toys = (CardView) view.findViewById(R.id.cat_toys_card);

        //View More
        viewMore.setOnClickListener(this);

        //Card Intent
        showCard1.setOnClickListener(this);
        showCard2.setOnClickListener(this);
        showCard3.setOnClickListener(this);
        showCard4.setOnClickListener(this);

        //Toasts
        cat_food.setOnClickListener(this);
        pet_care.setOnClickListener(this);
        accessory.setOnClickListener(this);
        cat_shampoo.setOnClickListener(this);
        cat_toys.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {

        //go the the next activity
        if (v.getId() == R.id.view_more_btn) {
            Intent intent = new Intent(getActivity(), view_more.class);
            startActivity(intent);
        }

        //show the cards
        else if (v.getId() == R.id.classic_catfood) {
            Intent intent = new Intent(getActivity(), show_card1.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.friskies_catfood) {
            Intent intent = new Intent(getActivity(), show_card2.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.applaws_catfood) {
            Intent intent = new Intent(getActivity(), show_card3.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.purina_catfood) {
            Intent intent = new Intent(getActivity(), show_card4.class);
            startActivity(intent);
        }

        //show the toast
        else if (v.getId() == R.id.catfood_card) {
            Toast.makeText(getActivity(), "You pressed Cat Food!" , Toast.LENGTH_SHORT ).show();
        }

        else if (v.getId() == R.id.pet_care_card) {
            Toast.makeText(getActivity(), "You pressed Pet Care!" , Toast.LENGTH_SHORT ).show();
        }
        else if (v.getId() == R.id.accessory_card) {
            Toast.makeText(getActivity(), "You pressed Accessories!" , Toast.LENGTH_SHORT ).show();
        }

        else if (v.getId() == R.id.cat_shampoo_card) {
            Toast.makeText(getActivity(), "You pressed Cat Shampoo!" , Toast.LENGTH_SHORT ).show();
        }

        else if (v.getId() == R.id.cat_toys_card) {
            Toast.makeText(getActivity(), "You pressed Cat Toys!" , Toast.LENGTH_SHORT ).show();
        }

    }
}

