package com.example.skullcrush.butterknife;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class Home extends Fragment {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    Unbinder unbinder;

    public Home() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.button)
    public void onButtonClicked() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment,new AddUser()).addToBackStack(null).commit();
    }

    @OnClick(R.id.button2)
    public void onButton2Clicked() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment,new ReadUser()).addToBackStack(null).commit();
    }

    @OnClick(R.id.button3)
    public void onButton3Clicked() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment,new DeleteUser()).addToBackStack(null).commit();
    }

    @OnClick(R.id.button4)
    public void onButton4Clicked() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment,new Update()).addToBackStack(null).commit();
    }
}
