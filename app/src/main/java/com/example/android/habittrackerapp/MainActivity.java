package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import data.HabitContract;
import data.HabitDbHelper;
import data.HabitContract.HabitEntry;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
        readData();
    }

    //returns number of rows in database
    private int readData() {
        //instantiate SQLiteOpenHelper
        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform SQL query
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_TIME,
                HabitEntry.COLUMN_HABIT_DATE,
                HabitEntry.COLUMN_HABIT_NAME
        };

        //Create cursor object
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
        try {
            //find all columns
            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int dateColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DATE);
            int timeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TIME);

            while (cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentDate = cursor.getString(dateColumnIndex);
                int currentTime = cursor.getInt(timeColumnIndex);

                //send all to display (no UI required in project
                return cursor.getCount();
            }
        } finally {
            // Close the cursor
            cursor.close();
        }
        return 0;
    }
    private void insertHabit(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //get values (inserted dummy data for now, but would hook this up to TextEdit fields in the app
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Worked out");
        values.put(HabitEntry.COLUMN_HABIT_DATE, "October 29, 2016");
        values.put(HabitEntry.COLUMN_HABIT_TIME, 30);

        //insert a new entry with the data above
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
        Log.v("Insert Habit", "New row ID: " + newRowId);
    }
}
