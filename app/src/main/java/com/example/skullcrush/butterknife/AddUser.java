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

public class AddUser extends Fragment {

    private int i;
    private String name;
    private String email;
    private String a;

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.button5)
    Button button5;
    Unbinder unbinder;

    public AddUser() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
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

        i = Integer.parseInt(editText.getText().toString());
        name = editText2.getText().toString();
        email = editText3.getText().toString();

        User user = new User();

        user.setEmail(email);
        user.setId(i);
        user.setName(name);

        MainActivity.database.dao().addUser(user);


        Toast.makeText(getActivity(),"User added successfully",Toast.LENGTH_SHORT).show();

        editText.setText("");
        editText2.setText("");
        editText3.setText("");

    }
}
