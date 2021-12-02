package com.example.newww;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView mnavigationView;
    ImageView img_avatar,imgoanhtuxi,imgtaixiu,imgxs,logo_xocdia;
    TextView tv_name,tv_email;
    DrawerLayout drawerLayout;
    Toolbar toolbar ;




    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }

        //anh xa
            drawerLayout = findViewById(R.id.draw_layout);
            mnavigationView = findViewById(R.id.nav_view);
            toolbar = findViewById(R.id.toolbar);
            imgxs = findViewById(R.id.imgxs);
            imgoanhtuxi = findViewById(R.id.imgoanhtuxi);
            imgtaixiu = findViewById(R.id.imgtaixiu);
            logo_xocdia =findViewById(R.id.logo_xocdia);

            imgxs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent xoso = new Intent(getApplication(),XoSo.class);
                    startActivity(xoso);
                }
            });

            imgoanhtuxi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent oantuxi = new Intent(getApplication(),OanTuXi.class);
                    startActivity(oantuxi);
                }
            });

            imgtaixiu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent xs = new Intent(getApplication(),BigAndSmall.class);
                    startActivity(xs);
                }
            });

        logo_xocdia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xocdia = new Intent(getApplication(),Xocdia.class);
                startActivity(xocdia);
            }
        });



            //tool bar
            setSupportActionBar(toolbar);

                    //Hide or show items
    //        Menu menu = navigationView.getMenu();
    //        menu.findItem(R.id.nav_login).setVisible(false);
    //        menu.findItem(R.id.nav_logout).setVisible(false);




            ///navigation drawer menu//
            mnavigationView.bringToFront();
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            mnavigationView.setNavigationItemSelectedListener(this);
            mnavigationView.setCheckedItem(R.id.nav_home);
            //ket noi voi mnavgationView ben class Header
            img_avatar = mnavigationView.getHeaderView(0).findViewById(R.id.img_avatar);
            tv_name = mnavigationView.getHeaderView(0).findViewById(R.id.tv_name);
            tv_email = mnavigationView.getHeaderView(0).findViewById(R.id.tv_email);


            showInformation();






        }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent chat = new Intent(this,home_chatbox.class);
                startActivity(chat);
                break;
            case R.id.nav_bus:
                Intent intent = new Intent(this,UserProfile.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Tks Coding With Tea", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_rate:
                Toast.makeText(this, "Tks Bạn đã chia sẽ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent1 = new Intent(this,ThemeLogin.class);
                startActivity(intent1);
                finish();

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
    private void showInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user ==null){
            return;
        }

        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        if(name == null){
            tv_name.setVisibility(View.GONE);
        }else{
            tv_name.setVisibility(View.VISIBLE);
            tv_name.setText(name);
        }

        tv_name.setText(name);
        tv_email.setText(email);
        Glide.with(this).load(photoUrl).error(R.drawable.iconman).into(img_avatar);
    }



}