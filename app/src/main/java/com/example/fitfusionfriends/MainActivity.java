package com.example.fitfusionfriends;


import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.androidgamesdk.GameActivity;
import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.widget.ImageView;

public class MainActivity extends GameActivity {
    static {
        System.loadLibrary("fitfusionfriends");
    }
    private static final String PREF_KEY = "my_pref";
    private static final String FRIEND_KEY = "my_friend";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_NAME = "name";
    private static final String KEY_WEIGHTGOAL = "weightGoal";
    String name;
    float height, weight, weightGoal;

    EditText editName;
    EditText editWeight;
    EditText editHeight;
    EditText editWeightGoal;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);

        ImageView imageView = findViewById(R.id.gif_image);
        Glide.with(this)
                .load(R.drawable.bird_0)
                .into(imageView);

        // Get SharedPreferences instance
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);

        // Edit SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editWeightGoal = findViewById(R.id.editWeightGoal);
        editName = (EditText) findViewById(R.id.editName);
        editWeight = (EditText) findViewById(R.id.editWeight);
        editHeight = (EditText) findViewById(R.id.editHeight);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                height = Float.parseFloat(editHeight.getText().toString());
                weight = Float.parseFloat(editWeight.getText().toString());
                weightGoal = Float.parseFloat(editWeightGoal.getText().toString());

                editor.putFloat(KEY_HEIGHT, height);
                editor.putFloat(KEY_WEIGHT, weight);
                editor.putFloat(KEY_WEIGHTGOAL, weightGoal);
                editor.putString(KEY_NAME, name);

                // Commit or apply the changes
                editor.apply(); // Asynchronous

                Intent intent = new Intent(MainActivity.this, MainGameScreen.class);
                startActivity(intent);
            }

        });

    }

    public void createFriend(){
        SharedPreferences sharedPreferences = getSharedPreferences(FRIEND_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = sharedPreferences.getString(FRIEND_KEY, null);
        Friend friend = gson.fromJson(json, Friend.class);
        if(friend == null){
            friend = new Friend();
            json = gson.toJson(friend);
            editor.putString(FRIEND_KEY, json);
            editor.apply();
        }


    }

//    public float getHeight() {
//        return sharedPreferences.getInt(KEY_HEIGHT, 0); // 0 is default height if not found
//    }
//
//    public float getWeight() {
//        return sharedPreferences.getInt(KEY_WEIGHT, 0); // 0 is default weight if not found
//    }
//
//    public String getName() {
//        return sharedPreferences.getString(KEY_NAME, ""); // "" is default name if not found
//    }
//
//    public float getWeightGoal() {
//        return sharedPreferences.getInt(KEY_WEIGHTGOAL, 0); // 0 is default weight if not found
//    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            hideSystemUi();
        }
    }

    private void hideSystemUi() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }
}