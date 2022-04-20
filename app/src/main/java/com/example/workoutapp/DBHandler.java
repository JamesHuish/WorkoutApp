package com.example.workoutapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper{
    private static final String DB_NAME = "workoutDB";

    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "tracker";

    private static final String WEEK_COL = "Week";

    // below variable is for our week number column.
    private static final String SQUAT_COL = "Squat";

    // below variable is for our course name column
    private static final String BENCH_COL = "Bench";

    // below variable id for our course duration column.
    private static final String DEADLIFT_COL = "Deadlift";

    // below variable for our course description column.
    private static final String DEADLIFT2COL = "Deadlift2";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + WEEK_COL + "INTEGER ,"
                + SQUAT_COL + " INTEGER,"
                + BENCH_COL + " INTEGER,"
                + DEADLIFT_COL + " INTEGER,"
                + DEADLIFT2COL + " INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    public void insertNewWeek(String value){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(WEEK_COL, value);
        values.put(SQUAT_COL, 140);
        values.put(BENCH_COL, 95);
        values.put(DEADLIFT_COL, 145);
        values.put(DEADLIFT2COL, 80);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void addValue(String value, String column, String row) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (column == "squat") {
            values.put(SQUAT_COL, value);
        } else if (column == "bench"){
            values.put(BENCH_COL, value);
        } else if (column == "deadlift") {
            values.put(DEADLIFT_COL, value);
        } else if (column == "deadlift2") {
            values.put(DEADLIFT2COL, value);
        } else {
            values.put(WEEK_COL, value);
        }

        db.update(TABLE_NAME, values, "_id = ?", new String[]{row});

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<weekModel> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<weekModel> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new weekModel(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
}
