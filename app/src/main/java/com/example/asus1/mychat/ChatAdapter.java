package com.example.asus1.mychat;


import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.sql.Time;
import java.util.Calendar;
import java.util.List;





public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {


    private List<ChatRow> chatList;

    public void addMessage(ChatRow msg) {
        chatList.add(msg);
        notifyItemInserted(chatList.size() - 1);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView content;
        TextView name;
        TextView time;

        public MyViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.content);
            name = view.findViewById(R.id.name);
            time = view.findViewById(R.id.time);

        }
    }


    public ChatAdapter(List<ChatRow> chatList) {
        this.chatList = chatList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChatRow row = chatList.get(position);
        holder.content.setText(row.getContent());
        holder.time.setText((DateUtils.getRelativeTimeSpanString(holder.itemView.getContext(), row.getTime()).toString()));

        holder.name.setText(row.getSenderName());

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}
