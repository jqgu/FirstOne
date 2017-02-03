package com.example.zg.firstone;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by LG on 2017/1/31.
 */
public class Layout_KeyBoard extends LinearLayout{
    ArrayList<Integer> buttonList;
    TextView pay_amount;

    public Layout_KeyBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_keyboard, this);
        buttonList = getButtonList();
        pay_amount = (TextView) findViewById(R.id.pay_amount);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.pay_1: {
                        pay_amount.setText(pay_amount.getText() + "1");
                        break;
                    }
                    case R.id.pay_2: {
                        pay_amount.setText(pay_amount.getText() + "2");
                        break;
                    }
                    case R.id.pay_3: {
                        pay_amount.setText(pay_amount.getText() + "3");
                        break;
                    }
                    case R.id.pay_4: {
                        pay_amount.setText(pay_amount.getText() + "4");
                        break;
                    }
                    case R.id.pay_5: {
                        pay_amount.setText(pay_amount.getText() + "5");
                        break;
                    }
                    case R.id.pay_6: {
                        pay_amount.setText(pay_amount.getText() + "6");
                        break;
                    }
                    case R.id.pay_7: {
                        pay_amount.setText(pay_amount.getText() + "7");
                        break;
                    }
                    case R.id.pay_8: {
                        pay_amount.setText(pay_amount.getText() + "8");
                        break;
                    }
                    case R.id.pay_9: {
                        pay_amount.setText(pay_amount.getText() + "9");
                        break;
                    }
                    case R.id.pay_0: {
                        pay_amount.setText(pay_amount.getText() + "0");
                        break;
                    }
                    case R.id.pay_dot: {
                        if (pay_amount.getText().toString().indexOf('.') == -1) {
                            if(pay_amount.getText().length() == 1){
                                pay_amount.setText(pay_amount.getText() + "0.");
                            }
                            else{
                                pay_amount.setText(pay_amount.getText() + ".");
                            }

                        }
                        break;
                    }
                    case R.id.pay_back: {
                        if (pay_amount.getText().length() != 1) {
                            pay_amount.setText(pay_amount.getText().subSequence(0, pay_amount.getText().length() - 1));
                        }
                        break;
                    }
                }
                int index = pay_amount.getText().toString().indexOf('.');
                if(index != -1){
                    if(pay_amount.getText().toString().substring(index + 1).length() >= 2){
                        pay_amount.setText(pay_amount.getText().subSequence(0, index + 3));
                    }
                }
            }
        };
        for(int id : buttonList){
            findViewById(id).setOnClickListener(clickListener);
        }
    }

    private ArrayList<Integer> getButtonList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.id.pay_0);
        list.add(R.id.pay_1);
        list.add(R.id.pay_2);
        list.add(R.id.pay_3);
        list.add(R.id.pay_4);
        list.add(R.id.pay_5);
        list.add(R.id.pay_6);
        list.add(R.id.pay_7);
        list.add(R.id.pay_8);
        list.add(R.id.pay_9);
        list.add(R.id.pay_dot);
        list.add(R.id.pay_back);
        return list;
    }
}
