package com.example.androidcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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

    public ArrayList<ContactModal> readContact(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorContacts = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ContactModal> contactModalArrayList = new ArrayList<>();

        if (cursorContacts.moveToFirst()){
            do {
                contactModalArrayList.add(new ContactModal(cursorContacts.getString(1), cursorContacts.getString(2)));
            } while (cursorContacts.moveToNext());
        }
        cursorContacts.close();
        return contactModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
