package com.example.lewin.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up Fragment manager and fragment transaction
        FragmentManager frag_manager = getSupportFragmentManager();
        FragmentTransaction frag_transaction = frag_manager.beginTransaction();

        // Put the third fragment to the screen
        frag_transaction.replace(R.id.frame, new FragmentOne());
        frag_transaction.commit();
    }
}
