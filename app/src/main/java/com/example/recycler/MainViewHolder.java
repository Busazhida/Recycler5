package com.example.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView nameTV;
    TextView surnameTV;
    TextView groupTV;
    TextView yearTV;

    public IStudentListener listener;

    Student student;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.tv_vh_name);
        surnameTV = itemView.findViewById(R.id.tv_vh_surname);
        groupTV = itemView.findViewById(R.id.tv_vh_group);
        yearTV = itemView.findViewById(R.id.tv_vh_year);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onStudentClick(student);

            }
        });
    }
    public void onBind(Student student) {
        this.student = student;
        nameTV.setText(student.name);
        surnameTV.setText(student.surname);
        groupTV.setText(student.group);


        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        yearTV.setText(format.format(student.year));

    }
}
