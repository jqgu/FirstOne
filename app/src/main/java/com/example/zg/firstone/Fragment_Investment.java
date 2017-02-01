package com.example.zg.firstone;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Investment extends Fragment {
    private List<Global_Company> company_list = new ArrayList<Global_Company>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_investment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initCompany();
        CompanyAdapter adapter = new CompanyAdapter(getActivity(),
                R.layout.investment_company_item, company_list);
        ListView listView = (ListView) getActivity().findViewById(R.id.invesment_list_view);
        listView.setAdapter(adapter);
    }

    private void initCompany() {
        Global_Company apple = new Global_Company("Apple", R.drawable.comp_apple);
        company_list.add(apple);
        Global_Company banana = new Global_Company("Banana", R.drawable.comp_banana);
        company_list.add(banana);
        Global_Company orange = new Global_Company("Orange", R.drawable.comp_orange);
        company_list.add(orange);
        Global_Company watermelon = new Global_Company("Watermelon", R.drawable.comp_waterme);
        company_list.add(watermelon);
        Global_Company pear = new Global_Company("Pear", R.drawable.comp_pear);
        company_list.add(pear);
        Global_Company grape = new Global_Company("Grape", R.drawable.comp_grape);
        company_list.add(grape);
        Global_Company pineapple = new Global_Company("Pineapple", R.drawable.comp_pineapple);
        company_list.add(pineapple);
        Global_Company strawberry = new Global_Company("Strawberry", R.drawable.comp_strawberry);
        company_list.add(strawberry);
        Global_Company cherry = new Global_Company("Cherry", R.drawable.comp_cheery);
        company_list.add(cherry);
        Global_Company mango = new Global_Company("Mango", R.drawable.comp_mango);
        company_list.add(mango);
    }

    public static Fragment_Investment newInstance(String param) {
        Fragment_Investment fragment = new Fragment_Investment();
        Bundle args = new Bundle();
        args.putString("ARGS", param);
        fragment.setArguments(args);
        return fragment;
    }
}

class CompanyAdapter extends ArrayAdapter<Global_Company> {
    private int resourceId;

    public CompanyAdapter(Context context, int textViewResourceId,
                          List<Global_Company> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Global_Company comp = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView company_image = (ImageView) view.findViewById(R.id.company_image);
        TextView company_name = (TextView) view.findViewById(R.id.company_name);
        Button button = (Button)view.findViewById(R.id.invest_button);
        company_image.setImageResource(comp.getImageId());
        company_image.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
        company_name.setText(comp.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), comp.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}