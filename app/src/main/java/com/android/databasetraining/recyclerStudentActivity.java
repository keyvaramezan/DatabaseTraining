package com.android.databasetraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class recyclerStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_student_activity);
        RecyclerView recycler = findViewById(R.id.recyclerStudentShow);
        StudentDatabase db = new StudentDatabase(recyclerStudentActivity.this, "student", null,1);
        //یک لیستی ساختم و اسامی که از دیتابیس استخراج شده رو در اون قرار میدم
        List<String> sList = db.getAllStudentsName();
        // در اینجا اون لیست رو می دم به آداپترم تا بذارتش تو ریسایکلر
        StudentAdapter adapter = new StudentAdapter(sList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(recyclerStudentActivity.this, RecyclerView.VERTICAL, false));

    }
}
