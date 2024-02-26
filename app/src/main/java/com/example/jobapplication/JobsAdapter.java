package com.example.jobapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobapplication.models.JobDetails;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {

    private final ArrayList<JobModel> jobs;
    Context context;
    static OnJobClicked onJobClicked;


    public JobsAdapter(ArrayList<JobModel> jobs, Context context, OnJobClicked onMessageClicked) {
        this.jobs = jobs;
        this.context = context;
        JobsAdapter.onJobClicked = onMessageClicked;
    }

    public interface OnJobClicked {
        void onJobClicked(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.job_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobModel model = jobs.get(position);
        holder.textView1.setText(model.getJobTitle());
        holder.textView2.setText(model.getCompanyName());
        holder.textView3.setText(model.getLocation());
//        holder.textView4.setText(model.getDate());
//        holder.textView5.setText(model.getSalary());
//        holder.textView6.setText(model.getSelectionProcess());
//        holder.textView7.setText(model.getEligibility());
//        holder.textView8.setText(model.getPreferedSkills());
//        holder.textView9.setText(model.getAboutJob());
//        holder.textView10.setText(model.getJobField());
//        holder.textView11.setText(model.getCompanyProfile());
//        holder.textView12.setText(model.getWebsite());
//        holder.textView13.setText(model.getEmail());
//        holder.textView14.setText(model.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {    TextView textView1, textView2, textView3;
//        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9,
//                textView10, textView11, textView12, textView13, textView14;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ApplyJobActivity.class);
                    intent.putExtra("jobTitle", textView1.getText().toString());
                    intent.putExtra("companyName", textView2.getText().toString());
                    intent.putExtra("location", textView3.getText().toString());
//                    intent.putExtra("date", textView4.getText().toString());
//                    intent.putExtra("salary", textView5.getText().toString());
//                    intent.putExtra("selection", textView6.getText().toString());
//                    intent.putExtra("eligibility", textView7.getText().toString());
//                    intent.putExtra("skills", textView8.getText().toString());
//                    intent.putExtra("about", textView9.getText().toString());
//                    intent.putExtra("field", textView10.getText().toString());
//                    intent.putExtra("profile", textView11.getText().toString());
//                    intent.putExtra("website", textView12.getText().toString());
//                    intent.putExtra("email", textView13.getText().toString());
//                    intent.putExtra("phone", textView14.getText().toString());
                    context.startActivity(intent);


                }
            });
            textView1 = itemView.findViewById(R.id.TV_jobtitle);
            textView2 = itemView.findViewById(R.id.TV_companyname);
            textView3 = itemView.findViewById(R.id.TV_location);
//            textView4 = itemView.findViewById(R.id.TV_date);
//            textView5 = itemView.findViewById(R.id.TV_salary);
//            textView6 = itemView.findViewById(R.id.TV_selection);
//            textView7 = itemView.findViewById(R.id.TV_eligible);
//            textView8 = itemView.findViewById(R.id.TV_skill);
//            textView9 = itemView.findViewById(R.id.TV_about);
//            textView10 = itemView.findViewById(R.id.TV_industrydescription);
//            textView11 = itemView.findViewById(R.id.TV_cprofile);
//            textView12 = itemView.findViewById(R.id.TV_url);
//            textView13 = itemView.findViewById(R.id.TV_email);
//            textView14 = itemView.findViewById(R.id.TV_phone);


        }
    }

}