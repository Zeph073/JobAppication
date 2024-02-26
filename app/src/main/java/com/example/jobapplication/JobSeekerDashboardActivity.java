package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class JobSeekerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_dashboard);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome😎😎"+" "+username, Toast.LENGTH_SHORT).show();


        CardView jsprofile = findViewById(R.id.cardJSProfile);
        jsprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JobSeekerDashboardActivity.this, JobSeekerProfileActivity.class));
            }
        });

        CardView jsjobs = findViewById(R.id.cardJSJobs);
        jsjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JobSeekerDashboardActivity.this, JobSeekerJobActivity.class));
            }
        });

        CardView jsnotifications = findViewById(R.id.cardJSNotifications);
        jsnotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JobSeekerDashboardActivity.this, JobSeekerNotificationsActivity.class));
            }
        });


    }
}