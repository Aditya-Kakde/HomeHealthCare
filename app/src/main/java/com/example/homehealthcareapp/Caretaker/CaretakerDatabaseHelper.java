package com.example.homehealthcareapp.Caretaker;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CaretakerDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "caretaker.db";
    private static final int DATABASE_VERSION = 1;

    public CaretakerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE caretakers ("
                + "caretaker_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "specialization TEXT,"
                + "experience INTEGER,"
                + "reviews REAL,"
                + "patients_handled INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS caretakers");
        onCreate(db);
    }
}
