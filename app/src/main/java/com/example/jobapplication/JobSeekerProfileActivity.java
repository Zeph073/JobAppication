package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class JobSeekerProfileActivity extends AppCompatActivity {

    public EditText etFullnames, etEmail, etMobileNo,etCity, etCourseName, etSchoolName,etCompletionYear,
    etAward, etCompany, etYearsworked;
    public Button btn;
    public LinearLayout llUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_profile);

        etFullnames = findViewById(R.id.ET_Fullnames);
        etEmail = findViewById(R.id.ET_Fullnames);
        etMobileNo = findViewById(R.id.ET_Fullnames);
        etCity = findViewById(R.id.ET_Fullnames);
        etCourseName = findViewById(R.id.ET_Fullnames);
        etSchoolName = findViewById(R.id.ET_Fullnames);
        etCompletionYear = findViewById(R.id.ET_Fullnames);
        etAward = findViewById(R.id.ET_Fullnames);
        etCompany = findViewById(R.id.ET_Fullnames);
        etYearsworked = findViewById(R.id.ET_Fullnames);
        btn = findViewById(R.id.buttonDatePicker);
        llUpdate = findViewById(R.id.LL_update);

        llUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Fullnames = etFullnames.getText().toString();
                String Email = etEmail.getText().toString();
                String MobileNo = etMobileNo.getText().toString();
                String City = etCity.getText().toString();
                String CourseName = etCourseName.toString();
                String SchoolName = etSchoolName.getText().toString();
                String CompletionYear = etCompletionYear.toString();
                String Award = etAward.getText().toString();
                String Company = etCompany.getText().toString();
                String YearsWorked = etYearsworked.getText().toString();

                if (TextUtils.isEmpty(Fullnames)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Full names", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(MobileNo)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(City)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter City", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(CourseName)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Course Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(SchoolName)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter School Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(CompletionYear)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Completion Year", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Award)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Award", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Company)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Company Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(YearsWorked)) {
                    Toast.makeText(JobSeekerProfileActivity.this, "Enter Year Worked", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

        });

    }
}