package com.example.fitfusionfriends;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fitfusionfriends.databinding.ActivityMainGameScreenBinding;
import com.google.gson.Gson;

public class MainGameScreen extends AppCompatActivity {

    private ActivityMainGameScreenBinding binding;
    private int progressValue;
    private ImageView xpBarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainGameScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /* BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_game_screen);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController); */


        xpBarImageView = findViewById(R.id.xpBar);
        progressValue = 5;

        updateXpBarImage(xpBarImageView);
    }
    private int getFriendLevel(){
        SharedPreferences sharedPreferences = getSharedPreferences(FRIEND_KEY, MODE_PRIVATE);
        String json = sharedPreferences.getString(FRIEND_KEY, null);
        Gson gson = new Gson();
        Friend friend = gson.fromJson(json, Friend.class);
        if(friend == null)
            friend = new Friend();
        return friend.getFriendLevel();
    }

    private void updateXpBarImage(ImageView imageView)
    {
        int drawableResourceId;
        if (progressValue == 1)
        {
            drawableResourceId = R.drawable.row_1_column_1;
        }
        else if (progressValue == 2)
        {
            drawableResourceId = R.drawable.row_2_column_1;
        }
        else if (progressValue == 3)
        {
            drawableResourceId = R.drawable.row_3_column_1;
        }
        else if (progressValue == 4)
        {
            drawableResourceId = R.drawable.row_4_column_1;
        }
        else if (progressValue == 5)
        {
            drawableResourceId = R.drawable.row_5_column_1;
        }
        else if (progressValue == 6)
        {
            drawableResourceId = R.drawable.row_6_column_1;
        }
        else if (progressValue == 7)
        {
            drawableResourceId = R.drawable.row_7_column_1;
        }
        else if (progressValue == 8)
        {
            drawableResourceId = R.drawable.row_8_column_1;
        }
        else if (progressValue == 9)
        {
            drawableResourceId = R.drawable.row_9_column_1;
        }
        else if (progressValue == 10)
        {
            drawableResourceId = R.drawable.row_10_column_1;
        }
        else
        {
            drawableResourceId = R.drawable.row_11_column_1;
        }

        xpBarImageView.setImageResource(drawableResourceId);
    }
}