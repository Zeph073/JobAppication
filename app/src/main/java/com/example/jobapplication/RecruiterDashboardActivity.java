package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RecruiterDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_dashboard);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome"+" "+username, Toast.LENGTH_SHORT).show();


        CardView job = findViewById(R.id.cardJobs);
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecruiterDashboardActivity.this, JobActivity.class));
            }
        });

        CardView candidates = findViewById(R.id.cardCandidates);
        candidates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecruiterDashboardActivity.this, CandidatesActivity.class));
            }
        });

        CardView recprofile = findViewById(R.id.cardRecruiterProfile);
        recprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecruiterDashboardActivity.this, RecruiterProfileActivity.class));
            }
        });

        CardView exit = findViewById(R.id.cardRecLogout);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecruiterDashboardActivity.this, LoginActivity.class));
            }
        });

    }
}