package com.example.androidcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "contactsdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycontacts";

    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String PHONE_COL = "phone";


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COL + " TEXT," +
                PHONE_COL + " TEXT)";

        db.execSQL(query);

    }

    public void addNewContact(String contactName, String contactNumber){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_COL, contactName);
        contentValues.put(PHONE_COL, contactNumber);

        db.insert(TABLE_NAME, null, contentValues);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}