package com.example.jobapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobapplication.databinding.ActivityAvailableJobsBinding;
import com.example.jobapplication.models.JobDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AvailableJobsActivity extends AppCompatActivity {
    ActivityAvailableJobsBinding binding;
    RecyclerView recyclerView;
    ArrayList<JobModel> jobs;
    JobsAdapter.OnJobClicked onJobClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAvailableJobsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onJobClicked = new JobsAdapter.OnJobClicked() {
            @Override
            public void onJobClicked(int position) {
                startActivity(new Intent(AvailableJobsActivity.this, ApplyJobActivity.class)
                        .putExtra("jobTitle", jobs.get(position).getJobTitle())
                        .putExtra("companyName", jobs.get(position).getCompanyName())
                        .putExtra("location", jobs.get(position).getLocation()));
//                        .putExtra("date", jobs.get(position).getDate())
//                        .putExtra("salary", jobs.get(position).getSalary())
//                        .putExtra("selection", jobs.get(position).getSelectionProcess())
//                        .putExtra("eligibility", jobs.get(position).getEligibility())
//                        .putExtra("skills", jobs.get(position).getPreferedSkills())
//                        .putExtra("about", jobs.get(position).getAboutJob())
//                        .putExtra("field", jobs.get(position).getJobField())
//                        .putExtra("email", jobs.get(position).getEmail())
//                        .putExtra("website", jobs.get(position).getWebsite())
//                        .putExtra("phone", jobs.get(position).getPhoneNumber())
//                        .putExtra("profile", jobs.get(position).getCompanyProfile()));
            }
        };
        recyclerView = binding.jobsRecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        jobs = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Jobs");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                jobs.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String jobTitle = ds.child("jobTitle").getValue(String.class);
                    String companyName = ds.child("companyName").getValue(String.class);
                    String location = ds.child("location").getValue(String.class);
//                    String date = ds.child("lastDateOfApplication").getValue(String.class);
//                    String salary = ds.child("salary").getValue(String.class);
//                    String selection = ds.child("selectionProcess").getValue(String.class);
//                    String eligibility = ds.child("eligibility").getValue(String.class);
//                    String skills = ds.child("preferedSkills").getValue(String.class);
//                    String about = ds.child("aboutJob").getValue(String.class);
//                    String jobfield = ds.child("jobField").getValue(String.class);
//                    String companyprofile = ds.child("companyProfile").getValue(String.class);
//                    String website = ds.child("website").getValue(String.class);
//                    String email = ds.child("email").getValue(String.class);
//                    String phonenumber = ds.child("phoneNumber").getValue(String.class);

                    JobModel model = new JobModel(jobTitle, companyName, location);/*, date, salary, selection, eligibility, skills, about,
                            jobfield, companyprofile, website, email, phonenumber*/
                    jobs.add(model);
                    binding.jobsRecyclerView.setVisibility(View.VISIBLE);
                    binding.jobsProgress.setVisibility(View.GONE);
                }
                recyclerView.setAdapter(new JobsAdapter(jobs, AvailableJobsActivity.this, onJobClicked));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
