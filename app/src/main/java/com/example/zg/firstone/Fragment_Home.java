package com.example.zg.firstone;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Fragment_Home extends Fragment {
    List<Global_Friend> friendList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView balance = (TextView)getActivity().findViewById(R.id.balance);
        balance.setText("$"+Global_User.getInstance().getBalance());

        ArrayList<CharSequence> list = getActivity().getIntent().getCharSequenceArrayListExtra("friendsList");
        ImageView userImage = (ImageView)getActivity().findViewById(R.id.user);
        userImage.setBackgroundResource(Global_Friend.friendImageList.get(Global_User.getInstance().getName()));

        initFriendList(list);
        FriendListAdapter adapter = new FriendListAdapter(getActivity(),
                R.layout.home_friend_item, friendList);
        ListView listView = (ListView) getActivity().findViewById(R.id.home_friend_list);
        listView.setAdapter(adapter);
    }

    public void initFriendList(ArrayList<CharSequence> list){
        friendList.clear();
        for(CharSequence seq : list){
            String name = seq.toString();
            Log.d("friend","name is "+name);
            int imageID = Global_Friend.friendImageList.get(name);
            friendList.add(new Global_Friend(name, imageID));
        }
    }

    public static Fragment_Home newInstance(String param) {
        Fragment_Home fragment = new Fragment_Home();
        Bundle args = new Bundle();
        args.putString("ARGS", param);
        fragment.setArguments(args);
        return fragment;
    }
}

class FriendListAdapter extends ArrayAdapter<Global_Friend> {
    private int resourceId;
    public FriendListAdapter(Context context, int textViewResourceId,
                             List<Global_Friend> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Global_Friend friend = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView friend_image = (ImageView) view.findViewById(R.id.friend_image);
        TextView friend_name = (TextView) view.findViewById(R.id.friend_name);
        Button button = (Button)view.findViewById(R.id.friend_chat_button);
        friend_image.setImageResource(friend.getImageID());
        friend_image.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
        friend_name.setText(friend.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), friend.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
