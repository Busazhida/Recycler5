package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    String name;
    String surname;
    String group;
    Date year;

    TextView dateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dateTV = findViewById(R.id.tv_add_year);
        EditText nameET = (findViewById(R.id.et_add_name));
        EditText surnameET = (findViewById(R.id.et_add_surname));
        EditText groupET = (findViewById(R.id.et_add_group));

        nameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name = s.toString();
            }
        });

        surnameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                surname = s.toString();
            }
        });
        groupET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                group = s.toString();
            }
        });

        Button chooseDate = findViewById(R.id.btn_add_year);
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.d("ololo", "year: " + year + "month" + (month + 1) + "day" + dayOfMonth);
                        dateTV.setText(dayOfMonth + "." + (month+1) + "." + year);
                        AddActivity.this.year = new Date(year, month, dayOfMonth);
                    }
                }, year, month, day);
                dialog.show();
            }
        });
        Button save = findViewById(R.id.btn_add_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.surname = surname;
                student.name = name;
                student.group = group;
                student.year = year;

                Intent intent = new Intent();
                intent.putExtra("student", student);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null){
            Student student = (Student) intent.getSerializableExtra("student");
            if (student!=null){
                nameET.setText(student.group);
                surnameET.setText(student.name);
                groupET.setText(student.surname);
                DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
                chooseDate.setText(format.format(student.year));
            }

        }

    }
}