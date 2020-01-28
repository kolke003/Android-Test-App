package com.example.pendotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.*;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

//FEEL FREE TO CHANGE USER/ACCOUNT DATA HERE//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pendo.PendoInitParams pendoParams = new Pendo.PendoInitParams();
        pendoParams.setVisitorId("Test");
        pendoParams.setAccountId("Acme Inc");

//send Visitor Level Data
        Map<String, String> userData = new HashMap<>();
        userData.put("age", "27");
        userData.put("country", "USA");
        pendoParams.setUserData(userData);

//send Account Level Data
        Map<String, String> accountData = new HashMap<>();
        accountData.put("Tier", "1");
        accountData.put("Size", "Enterprise");
        pendoParams.setAccountData(accountData);

//!! WARNING!! - place API key below !!//
        Pendo.initSDK(
                this,
                "insert Pendo API Key here",
                pendoParams);   // call initSDK with initParams as a fourth parameter (this can be `null`).

        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
