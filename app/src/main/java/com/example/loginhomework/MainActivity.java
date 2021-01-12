package com.example.loginhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    boolean flag = true;
    String TAG = "DEBUG";
    EditText login;
    EditText password;
    HashMap<String, String> hashMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "On1");
        hashMap.put("admin", "12345678");
        // correct login / password, will start second activity on button click
    }
    public void enter(View view){
        flag = true;
        Log.d(TAG, "On2");
        login = findViewById(R.id.Login);
        password = findViewById(R.id.Password);
        for (HashMap.Entry<String, String> entry : hashMap.entrySet()
             ) {
            Log.d(TAG, "On2.5");
            if (entry.getKey().equals(login.getText().toString()) && entry.getValue().equals(password.getText().toString())) {
                Log.d(TAG, "On3");
                Intent intent = new Intent(getApplicationContext(), MainDisplay.class);
                startActivity(intent);
                flag = false;
            }
            if(flag){
                Toast.makeText(this, "Вы ввели неправильно данные, повторите попытку", Toast.LENGTH_SHORT).show();
            }
        }
    }
}