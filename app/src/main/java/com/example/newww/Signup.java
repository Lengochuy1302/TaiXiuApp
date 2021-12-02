package com.example.newww;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    //khaibao
    TextInputLayout reg_name,reg_username,reg_email,reg_phone,reg_password;
    Button reg_btn;

//    FirebaseDatabase rootNode;
//    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Anhxa
        reg_name = findViewById(R.id.name);
        reg_username = findViewById(R.id.username);
        reg_email = findViewById(R.id.email);
        reg_password = findViewById(R.id.password);
        reg_btn = findViewById(R.id.reg_btn);
//        reg_btn.setOnClickListener(new View.OnClickListener() {
//
//
//
//            private Boolean validateFullname() {
//                String val = reg_name.getEditText().getText().toString();
//
//                if (val.isEmpty()) {
//                    reg_name.setError("Field cannot be empty");
//                    return false;
//                } else {
//                    reg_name.setError(null);
//                    reg_name.setErrorEnabled(false);
//                    return true;
//                }
//
//            }
//
//            private Boolean validateUsername() {
//                String val = reg_username.getEditText().getText().toString();
//                String noWhiteSpace = "\\A\\w{4,20}\\z";
//
//                if (val.isEmpty()) {
//                    reg_username.setError("Field cannot be empty");
//                    return false;
//                } else if (val.length() >= 15) {
//                    reg_username.setError("Username too long");
//                    return false;
//                } else if (!val.matches(noWhiteSpace)) {
//                    reg_username.setError("White Spaces are not allowed");
//                    return false;
//                } else {
//                    reg_username.setError(null);
//                    reg_username.setErrorEnabled(false);
//                    return true;
//                }
//            }
//
//            private Boolean validateEmail() {
//                String val = reg_email.getEditText().getText().toString();
//                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//
//                if (val.isEmpty()) {
//                    reg_email.setError("Field cannot be empty");
//                    return false;
//                } else if (!val.matches(emailPattern)) {
//                    reg_email.setError("Invalid email address");
//                    return false;
//                } else {
//                    reg_email.setError(null);
//                    reg_email.setErrorEnabled(false);
//                    return true;
//                }
//            }
//
//            private Boolean validatePhoneNo() {
//                String val = reg_phone.getEditText().getText().toString();
//
//                if (val.isEmpty()) {
//                    reg_phone.setError("Field cannot be empty");
//                    return false;
//                } else {
//                    reg_phone.setError(null);
//                    reg_phone.setErrorEnabled(false);
//                    return true;
//                }
//            }
//
//            private Boolean validatePassword() {
//                String val = reg_password.getEditText().getText().toString();
//                String passwordVal = "^" +
//                        //"(?=.*[0-9])" +         //at least 1 digit
//                        //"(?=.*[a-z])" +         //at least 1 lower case letter
//                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                        "(?=.*[a-zA-Z])" +      //any letter
//                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                        "(?=\\S+$)" +           //no white spaces
//                        ".{4,}" +               //at least 4 characters
//                        "$";
//
//                if (val.isEmpty()) {
//                    reg_password.setError("Field cannot be empty");
//                    return false;
//
//                } else {
//                    reg_password.setError(null);
//                    reg_password.setErrorEnabled(false);
//                    return true;
//                }
//            }
//
//
////            //Nut xac nhan tao
////            @Override
////            public void onClick(View view) {
////                rootNode = FirebaseDatabase.getInstance();
////                reference = rootNode.getReference("users");
////
////                if(!validateFullname() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()){
////                    return;
////                }
////
////
////                //lay gia tri value
////                String fullname = reg_name.getEditText().getText().toString();
////                String username = reg_username.getEditText().getText().toString();
////                String email = reg_email.getEditText().getText().toString();
////                String phone = reg_phone.getEditText(). getText().toString();
////                String password = reg_password.getEditText().getText().toString();
////
////                UserClass userClass = new UserClass(fullname,username,email,phone,password);
////
////                //lay username lam lop cha
////                reference.child(username).setValue(userClass);
////            }
////        });
//
//
//
////            @Override
////            public void onClick(View v) {
////                String stremail = reg_email.getEditText().getText().toString();
////                String strpassword = reg_password.getEditText().getText().toString();
////                FirebaseAuth auth = FirebaseAuth.getInstance();
////
////                auth.createUserWithEmailAndPassword(stremail, strpassword)
////                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
////                            @Override
////                            public void onComplete(@NonNull Task<AuthResult> task) {
////                                if (task.isSuccessful()) {
////                                    // Sign in success, update UI with the signed-in user's information
////                                    Intent intent = new Intent(Signup.this , Dashboard.class);
////                                    startActivity(intent);
////
////                                } else {
////                                    // If sign in fails, display a message to the user.
////
////                                    Toast.makeText(Signup.this, "Mat khau hoac Email sai",
////                                            Toast.LENGTH_SHORT).show();
////
////                                }
////                            }
////                        });
////            }
////
////
//        });
        initListener();





    }

    private void initListener() {
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickxacnhandangky();
            }
        });



    }

    private void onClickxacnhandangky() {
        String stremail = reg_email.getEditText().getText().toString();
        String strpassword = reg_password.getEditText().getText().toString();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(stremail, strpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(Signup.this , Dashboard.class);
                                 startActivity(intent);
                            finishAffinity();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


}

