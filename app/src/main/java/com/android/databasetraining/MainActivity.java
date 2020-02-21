package com.android.databasetraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtStudentName = findViewById(R.id.edtStudentName);
        final EditText edtStudentLastName = findViewById(R.id.edtStudentLastName);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnShow = findViewById(R.id.btnShow);
        final StudentDatabase db = new StudentDatabase(MainActivity.this, "student", null,1);
            //برای ذخیره داده ها در دیتابیس
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = edtStudentName.getText().toString();
                    String lastName = edtStudentLastName.getText().toString();
                    db.insertStudent(name, lastName);
                    edtStudentName.setText("");
                    edtStudentLastName.setText("");
                }
            });
        // برای نمایش اسامی دانش آموزان در دیتابیس در یک اکتیویتی دیگر
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, recyclerStudentActivity.class);
                startActivity(intent);
            }
        });

    }
}
