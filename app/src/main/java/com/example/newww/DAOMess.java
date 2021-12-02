package com.example.newww;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOMess {

    private DatabaseReference databaseReference;
    public DAOMess(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(ChatMessage.class.getSimpleName());


    }
    public Task<Void> add(ChatMessage chatMessage){


        return   databaseReference.push().setValue(chatMessage);
    }

    public Query get(){
        return databaseReference.orderByKey();
    }






}
