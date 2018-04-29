package com.example.asus1.mychat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        View layout = view.findViewById(R.id.fragment_message_layout);
        TextView text = view.findViewById(R.id.fragment_message_text);
//        text.setText("hi");

        return view;

    }

}
