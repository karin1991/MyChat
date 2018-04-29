package com.example.asus1.mychat;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ChatRow> chatList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatAdapter mAdapter;
    private Button senderButton;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new ChatAdapter(chatList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        senderButton = findViewById(R.id.sendButton);
        input = findViewById(R.id.editText);







        senderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MessageFragment messageFragment = new MessageFragment();
                ChatRow msg = new ChatRow(input.getText().toString(), "Karin" , System.currentTimeMillis());
                mAdapter.addMessage(msg);
                input.setText("");

            }
        });


    }

    public void msgClick(View view)
    {

        MessageFragment messageFragment = new MessageFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_frame, messageFragment)
                .commit();

    }


}
