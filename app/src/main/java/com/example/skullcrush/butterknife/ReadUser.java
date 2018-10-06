package com.example.skullcrush.butterknife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ReadUser extends Fragment {


    @BindView(R.id.text)
    TextView text;
    Unbinder unbinder;


    private String info;
    public ReadUser() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        unbinder = ButterKnife.bind(this, view);

        List<User> users = MainActivity.database.dao().getUser();

        info = "";

        for(User user : users){
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info =  info+"id " + id + "name" +name+"Email"+email+"\n";
        }


        text.setText(info);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
