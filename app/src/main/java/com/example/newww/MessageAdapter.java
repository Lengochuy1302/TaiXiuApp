package com.example.newww;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<ChatMessage> list = new ArrayList<>();


    public MessageAdapter(Context ctx){

        this.context = ctx;

    }
    public void  setItem(ArrayList<ChatMessage> chatms){
        list.addAll(chatms);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message , parent ,false);
        return  new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageViewHolder ms = (MessageViewHolder) holder;
        ChatMessage chatms = list.get(position);
        ms.tvMessage.setText(chatms.getMessage_context());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

        public class MessageViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMessage;


        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tv_message);

        }
    }

}