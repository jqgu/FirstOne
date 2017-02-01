package com.example.zg.firstone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Pay extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public static Fragment_Pay newInstance(String param) {
        Fragment_Pay fragment = new Fragment_Pay();
        Bundle args = new Bundle();
        args.putString("ARGS", param);
        fragment.setArguments(args);
        return fragment;
    }

}
