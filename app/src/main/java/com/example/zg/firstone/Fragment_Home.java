package com.example.zg.firstone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView balance = (TextView)getActivity().findViewById(R.id.balance);
        balance.setText("$"+Global_User.getInstance().getBalance());
    }

    public static Fragment_Home newInstance(String param) {
        Fragment_Home fragment = new Fragment_Home();
        Bundle args = new Bundle();
        args.putString("ARGS", param);
        fragment.setArguments(args);
        return fragment;
    }

}
