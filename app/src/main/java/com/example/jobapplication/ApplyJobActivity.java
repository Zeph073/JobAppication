package com.example.jobapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobapplication.databinding.ActivityApplyJobBinding;
import com.example.jobapplication.databinding.ActivityAvailableJobsBinding;
import com.example.jobapplication.models.JobDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ApplyJobActivity extends AppCompatActivity {

    ActivityApplyJobBinding binding;
    TextView tvAbout, tvJobTitle, tvDate, tvCompanyName, tvLocation, tvJobField, tvSalary, tvSelection, tvEligible, tvSkills,
            tvCompanyProfile, tvWebsite, tvCompanyEmail, tvPhone;

    TextView textview;
    LinearLayout llApply, llSave;

    ArrayList<JobDetails> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);

        DatabaseReference ref=FirebaseDatabase.getInstance().getReference();

        arrayList = new ArrayList<JobDetails>();
        llApply = findViewById(R.id.LL_apply);
        llSave = findViewById(R.id.LL_save);

        llApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ApplyJobActivity.this, ApplyActivity.class));
            }
        });
        llSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ApplyJobActivity.this, "You have successfully saved the Job, proceed to Apply", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ApplyJobActivity.this, JobSeekerSavedJobsActivity.class));
            }
        });



        textview = findViewById(R.id.textviewHeader);
        tvJobTitle = findViewById(R.id.TV_jobtitle);
        tvCompanyName = findViewById(R.id.TV_companyname);
        tvDate = findViewById(R.id.TV_date);
        tvLocation = findViewById(R.id.TV_location);
        tvSalary = findViewById(R.id.TV_salary);
        tvSelection = findViewById(R.id.TV_selection);
        tvEligible = findViewById(R.id.TV_eligible);
        tvSkills = findViewById(R.id.TV_skill);
        tvAbout = findViewById(R.id.TV_about);
        tvJobField = findViewById(R.id.TV_industrydescription);
        tvCompanyProfile = findViewById(R.id.TV_cprofile);
        tvWebsite = findViewById(R.id.TV_url);
        tvCompanyEmail = findViewById(R.id.TV_email);
        tvPhone = findViewById(R.id.TV_phone);

        String jobTitle = getIntent().getStringExtra("jobTitle");
        String companyName = getIntent().getStringExtra("companyName");
        String location = getIntent().getStringExtra("location");
//        String date = getIntent().getStringExtra("date");
//        String salary = getIntent().getStringExtra("salary");
//        String selection = getIntent().getStringExtra("selection");
//        String eligibility = getIntent().getStringExtra("eligibility");
//        String skills = getIntent().getStringExtra("skills");
//        String about = getIntent().getStringExtra("about");
//        String field = getIntent().getStringExtra("field");
//        String profile = getIntent().getStringExtra("profile");
//        String website = getIntent().getStringExtra("website");
//        String email = getIntent().getStringExtra("email");
//        String phone = getIntent().getStringExtra("phone");

        tvJobTitle.setText(jobTitle);
        tvCompanyName.setText(companyName);
        tvLocation.setText(location);
//        tvDate.setText(date);
//        tvSalary.setText(salary);
//        tvSelection.setText(selection);
//        tvEligible.setText(eligibility);
//        tvSkills.setText(skills);
//        tvAbout.setText(about);
//        tvJobField.setText(field);
//        tvCompanyProfile.setText(profile);
//        tvWebsite.setText(website);
//        tvCompanyEmail.setText(email);
//        tvPhone.setText(phone);


//        ref.child("Jobs").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot snap: snapshot.getChildren()){
//
//                    textview.setText(snap.child("jobTitle").getValue().toString());
//                    tvJobTitle.setText(snap.child("jobTitle").getValue().toString());
//                    tvCompanyName.setText(snap.child("companyName").getValue().toString());
//                    tvLocation.setText(snap.child("location").getValue().toString());
//                    tvSalary.setText(snap.child("salary").getValue().toString());
//                    tvSelection.setText(snap.child("selectionProcess").getValue().toString());
//                    tvEligible.setText(snap.child("eligibility").getValue().toString());
//                    tvSkills.setText(snap.child("preferedSkills").getValue().toString());
//                    tvAbout.setText(snap.child("aboutJob").getValue().toString());
//                    tvJobField.setText(snap.child("jobField").getValue().toString());
//                    tvCompanyProfile.setText(snap.child("companyProfile").getValue().toString());
//                    tvWebsite.setText(snap.child("website").getValue().toString());
//                    tvCompanyEmail.setText(snap.child("email").getValue().toString());
//                    tvPhone.setText(snap.child("phoneNumber").getValue().toString());
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        /*
   String about, title,  date, companyname, location, jobfield, salary, selection, eligible, skills,
        companyprofile, website, email, phone;

        title = getIntent().getStringExtra("jobTitle");
        companyname = getIntent().getStringExtra("companyName");
        date = getIntent().getStringExtra("lastDateOfApplication");
        location = getIntent().getStringExtra("location");
        salary = getIntent().getStringExtra("salary");
        selection = getIntent().getStringExtra("selectionProcess");
        eligible = getIntent().getStringExtra("eligibility");
        skills = getIntent().getStringExtra("preferedSkills");
        about = getIntent().getStringExtra("aboutJob");
        jobfield = getIntent().getStringExtra("jobField");
        companyprofile = getIntent().getStringExtra("companyProfile");
        website = getIntent().getStringExtra("website");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phoneNumber");

        binding.TVJobtitle.setText(title);
        binding.TVCompanyname.setText(companyname);
        binding.TVDate.setText(date);
        binding.TVLocation.setText(location);
        binding.TVSalary.setText(salary);
        binding.TVSelection.setText(selection);
        binding.TVEligible.setText(eligible);
        binding.TVSkill.setText(skills);
        binding.TVAbout.setText(about);
        binding.TVIndustrydescription.setText(jobfield);
        binding.TVCprofile.setText(companyprofile);
        binding.TVUrl.setText(website);
        binding.TVEmail.setText(email);
        binding.TVPhone.setText(phone);*/

    }
}

/*public class JobDetails extends AppCompatActivity {
    ActivityJobDetailsBinding binding;

    String title,company,location,description,qualification;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityJobDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linearLayout = findViewById(R.id.applyJob);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JobDetails.this,ApplicationWebsite.class));
            }
        });

        title=getIntent().getStringExtra("title");
        location=getIntent().getStringExtra("location");
        company=getIntent().getStringExtra("company");
        description=getIntent().getStringExtra("description");
        qualification=getIntent().getStringExtra("qualifications");

        binding.jobTitle.setText(title);
        binding.jobDescription.setText(description);
        binding.companyLocation.setText(location);
        binding.companyName.setText(company);
        binding.qualification.setText(qualification);
    }
}
        /*
        public class ApplyJobActivity extends AppCompatActivity {
public TextView tvAbout, tvJobTitle, tvDate, tvCompanyName, tvLocation, tvJobField, tvSalary, tvSelection, tvEligible, tvSkills,
        tvCompanyProfile, tvWebsite, tvCompanyEmail, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);


    }
}

        DatabaseReference ref=FirebaseDatabase.getInstance().getReference();

        tvJobTitle = findViewById(R.id.TV_jobtitle);
        tvCompanyName = findViewById(R.id.TV_companyname);
        tvDate = findViewById(R.id.TV_date);
        tvLocation = findViewById(R.id.TV_location);
        tvSalary = findViewById(R.id.TV_salary);
        tvSelection = findViewById(R.id.TV_selection);
        tvEligible = findViewById(R.id.TV_eligible);
        tvSkills = findViewById(R.id.TV_skill);
        tvAbout = findViewById(R.id.TV_about);
        tvJobField = findViewById(R.id.TV_industrydescription);
        tvCompanyProfile = findViewById(R.id.TV_cprofile);
        tvWebsite = findViewById(R.id.TV_url);
        tvCompanyEmail = findViewById(R.id.TV_email);
        tvPhone = findViewById(R.id.TV_phone);

        ref.child("Jobs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for (DataSnapshot snap: snapshot.getChildren()){

                   tvJobTitle.setText(snap.child("jobTitle").getValue().toString());
                   tvCompanyName.setText(snap.child("companyName").getValue().toString());
                   tvLocation.setText(snap.child("location").getValue().toString());
                   tvSalary.setText(snap.child("salary").getValue().toString());
                   tvSelection.setText(snap.child("selectionProcess").getValue().toString());
                   tvEligible.setText(snap.child("eligibility").getValue().toString());
                   tvSkills.setText(snap.child("preferedSkills").getValue().toString());
                   tvAbout.setText(snap.child("aboutJob").getValue().toString());
                   tvJobField.setText(snap.child("jobField").getValue().toString());
                   tvCompanyProfile.setText(snap.child("companyProfile").getValue().toString());
                   tvWebsite.setText(snap.child("website").getValue().toString());
                   tvCompanyEmail.setText(snap.child("email").getValue().toString());
                   tvPhone.setText(snap.child("phoneNumber").getValue().toString());

               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/