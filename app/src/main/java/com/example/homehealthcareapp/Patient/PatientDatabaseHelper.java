package com.example.homehealthcareapp.Patient;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PatientDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "patient.db";
    private static final int DATABASE_VERSION = 1;

    public PatientDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE patients ("
                + "patient_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "age INTEGER,"
                + "disease TEXT,"
                + "care_required TEXT,"
                + "medical_history TEXT,"
                + "reports BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS patients");
        onCreate(db);
    }
}
