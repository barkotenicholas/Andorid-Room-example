package com.example.skullcrush.butterknife;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class Update extends Fragment {


    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.button5)
    Button button5;
    Unbinder unbinder;

    public Update() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.button5)
    public void onViewClicked() {

        String id = editText.getText().toString();
        String name = editText2.getText().toString();
        String email = editText.getText().toString();

        int a  = Integer.parseInt(id);

        User user = new User();
        user.setId(a);
        user.setName(name);
        user.setEmail(email);


        MainActivity.database.dao().updateuser(user);

        Toast.makeText(getActivity(),"User updated",Toast.LENGTH_SHORT).show();



    }
}
