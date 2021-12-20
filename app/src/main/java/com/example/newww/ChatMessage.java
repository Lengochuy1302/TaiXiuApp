package com.example.newww;

import android.text.format.DateFormat;

import com.facebook.appevents.internal.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ChatMessage {


    public String getMessage_context() {

        return message_context;
    }

    public void setMessage_context(String message_context) {
        this.message_context = message_context;
    }

    public ChatMessage() {
    }

    public ChatMessage(String message_context) {

        this.message_context = message_context;
    }

    private String message_context;


}
