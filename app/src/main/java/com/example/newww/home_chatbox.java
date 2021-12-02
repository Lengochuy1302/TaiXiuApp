package com.example.newww;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class home_chatbox extends AppCompatActivity {

    TextView tv_message;
    RecyclerView rcv_message;
    MessageAdapter adapter;

    EditText input;
    FloatingActionButton fab;
    DAOMess dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chatbox);
        rcv_message = findViewById(R.id.rcv_message);
         input = findViewById(R.id.input);
        fab = findViewById(R.id.fab);
        tv_message = findViewById(R.id.tv_message);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_message.setLayoutManager(manager);
        rcv_message.setHasFixedSize(true);
        adapter = new MessageAdapter(this);

        rcv_message.setAdapter(adapter);




        dao = new DAOMess();
        loadData();


        rcv_message.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

              LinearLayoutManager linearLayoutManager =(LinearLayoutManager)  rcv_message.getLayoutManager();
//              int totalItem = linearLayoutManager.getItemCount();
//              int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
//              if(totalItem<lastVisible){
//                  if(!isLoading){
//                      isLoading = true;
//                      loadData();
//                  }
//              }

            }
        });


        fab.setOnClickListener(v->{
            ChatMessage chatMessage = new ChatMessage(input.getText().toString());
            dao.add(chatMessage).addOnSuccessListener(suc->{
               Toast.makeText(this,"Succect",Toast.LENGTH_SHORT).show();


            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
            input.setText("");




        });
    }

    private void loadData() {
        ArrayList<ChatMessage> mlistMess = new ArrayList<>();
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()){
                    ChatMessage chatMessage = data.getValue(ChatMessage.class);
                    mlistMess.add(chatMessage);

                }
                adapter.setItem(mlistMess);
                rcv_message.scrollToPosition(mlistMess.size()-1);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}