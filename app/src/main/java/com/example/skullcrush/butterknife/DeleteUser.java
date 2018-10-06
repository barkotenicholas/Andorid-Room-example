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


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUser extends Fragment {


    @BindView(R.id.editText4)
    EditText editText4;
    @BindView(R.id.button6)
    Button button6;
    Unbinder unbinder;

    public String id;

    public DeleteUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);




        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.button6)
    public void onViewClicked() {
        id = editText4.getText().toString();
        int a = Integer.parseInt(id);
        User user = new User();
        user.setId(a);
        MainActivity.database.dao().deleteUser(user);

        Toast.makeText(getActivity(),"User successfully deleted",Toast.LENGTH_SHORT).show();
        editText4.setText("");
    }
}
