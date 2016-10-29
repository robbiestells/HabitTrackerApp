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
    }

    private void displayDatabaseInfo() {

        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_TIME,
                HabitEntry.COLUMN_HABIT_DATE,
                HabitEntry.COLUMN_HABIT_NAME
        };


        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            displayView.setText("Number of rows in pets database table: " + cursor.getCount());

            int idColumnIndex = cursor.getColumnIndex(PetEntry.I_D);
            int nameColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME);
            int breedColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED);
            int weightColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_WEIGHT);
            int genderColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_GENDER);

            while (cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentBreed = cursor.getString(breedColumnIndex);
                int currentGender = cursor.getInt(genderColumnIndex);
                int currentWeight = cursor.getInt(weightColumnIndex);
                displayView.append("\n" + currentID + "-" + currentName + "-" + currentBreed + "-" + currentGender + "-" + currentWeight);
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
    private void insertHabit(){
//        SQLiteDatabase db = mDBHelper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(PetEntry.COLUMN_PET_NAME, "Toto");
//        values.put(PetEntry.COLUMN_PET_BREED, "Terrier");
//        values.put(PetEntry.COLUMN_PET_GENDER, PetEntry.GENDER_MALE);
//        values.put(PetEntry.COLUMN_PET_WEIGHT, 7);
//
//        long newRowId = db.insert(PetEntry.TABLE_NAME, null, values);
//        Log.v("CatalogActivity", "New row ID" + newRowId);
    }
}
