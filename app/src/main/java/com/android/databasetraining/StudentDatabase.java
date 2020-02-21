package com.android.databasetraining;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase extends SQLiteOpenHelper {
    String TABLE_NAME = "student";

    public StudentDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //اینجا جدول ایجاد می کنیم و کوئری مربوط به ایجاد جدول رو می نویسیم
        String CREATE_TABLEE_QUERY =  "CREATE TABLE " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "lastName TEXT" +
                ")";
            db.execSQL(CREATE_TABLEE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //اینجا یک دانش آموز به دیتابیس اضافه می کنیم
    public void insertStudent(String name, String lastName) {
        String INSERT_STUDENT_QUERY = "INSERT INTO " + TABLE_NAME + "(name,lastName) VALUES("
                + "'" + name + "'" + ","
                + "'" + lastName + "'"
                + ")";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(INSERT_STUDENT_QUERY);
        db.close();
    }
    //اسم کوچک همه دانش |آموزان رو نمایش می دهیم
    public List<String>  getAllStudentsName() {
        //یک لیست ساختم که برای اسمامی دانش آموزان
        final List<String> studentNames = new ArrayList<>();
        String GET_ALL_STUDENT_NAME = "SELECT name FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(GET_ALL_STUDENT_NAME, null);
        //بوسیله ایم حلقه دونه دونه اسامی رو به لیست اضافه می کنم
        while (c.moveToNext()) {
            studentNames.add(c.getString(0));
        }

        db.close();
        return studentNames;
    }
}
