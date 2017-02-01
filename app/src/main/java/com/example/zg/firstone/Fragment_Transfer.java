package com.example.zg.firstone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_Transfer extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transfer, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static Fragment_Transfer newInstance(String param) {
        Fragment_Transfer fragment = new Fragment_Transfer();
        Bundle args = new Bundle();
        args.putString("ARGS", param);
        fragment.setArguments(args);
        return fragment;
    }


}
