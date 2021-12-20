package com.example.newww;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class ThemeLogin extends AppCompatActivity {
    Button Callsignup;
    Button Callgo;
    Button forgotpassword;
    TextInputLayout username, password;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_login);

        //anh xa
        Callsignup = findViewById(R.id.signup);
        Callgo = findViewById(R.id.go);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgotpassword = findViewById(R.id.forgotpassword);
        progressDialog = new ProgressDialog(this);

        Callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThemeLogin.this, Signup.class);
                startActivity(i);

            }
        });


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Kiểm tra Email");
                onClickForgotPassword();


            }
        });


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            Intent go = new Intent(ThemeLogin.this, Dashboard.class);
            startActivity(go);
            finish();
        }


    }

    private void onClickForgotPassword() {


        View view = LayoutInflater.from(this).inflate(R.layout.diaglog_forgotpassword, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.create().show();

        final TextInputLayout forgotuser = view.findViewById(R.id.forgotuser);
        final Button btn_forgotpassword = view.findViewById(R.id.btn_forgotpassword);


        String val = forgotuser.getEditText().getText().toString();


        btn_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String emailAddress = forgotuser.getEditText().getText().toString().trim();
                String val = forgotuser.getEditText().getText().toString();



                if (val.isEmpty()) {
                    forgotuser.setError("Field cannot be empty");
                    return;
                }
                progressDialog.show();

                    auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();
                                    Toast.makeText(getApplication(), "Kiểm tra Email", Toast.LENGTH_SHORT).show();
                                    return;

                                }



                            }
                        });



            }










        });


    }
    private boolean validatePassword() {
        String val = password.getEditText().getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;

        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = username.getEditText().getText().toString();

        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;

        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    public void loginuser(View view) {
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser();
        }



    }


////Dang nhap voi cach Realtime database
//    private void isUser() {
//        final String userEnteredUsername = username.getEditText().getText().toString().trim();
//        final String userEnteredPassword = password.getEditText().getText().toString().trim();
//
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
//
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//
//                    username.setError(null);
//                    username.setErrorEnabled(false);
//
//                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
//
//                    if (passwordFromDB.equals(userEnteredPassword)) {
//                        username.setError(null);
//                        username.setErrorEnabled(false);
//                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("fullname").getValue(String.class);
//                        String usernamFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
//                        String phoneFromDB = dataSnapshot.child(userEnteredUsername).child("phone").getValue(String.class);
//                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
//
//                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
//
//                        intent.putExtra("fullname", nameFromDB);
//                        intent.putExtra("username", usernamFromDB);
//                        intent.putExtra("email", emailFromDB);
//                        intent.putExtra("phone", phoneFromDB);
//                        intent.putExtra("password", passwordFromDB);
//
//                        startActivity(intent);
//                    } else {
//
//                        password.setError("Wrong Password");
//                        password.requestFocus();
//                    }
//
//                } else {
//
//                    username.setError("No such User exist");
//                    username.requestFocus();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }


    //Dang nhap bang Authentication
    private void isUser() {
        String strEmail = username.getEditText().getText().toString();
        String strPass = password.getEditText().getText().toString();

        FirebaseAuth auth = FirebaseAuth.getInstance();
//        progressDialog.show();

        auth.signInWithEmailAndPassword(strEmail, strPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                       progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                            startActivity(intent);
                            finishAffinity();

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(ThemeLogin.this, "Mat Khau hoac email sai",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });




    }


}