package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class viewContactsActivity extends AppCompatActivity {
    private ArrayList<ContactModal> contactModalArrayList;
    private DBHandler dbHandler;
    private ContactRVAdapter contactRVAdapter;
    private RecyclerView contactsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);

        contactModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(viewContactsActivity.this);

        contactModalArrayList = dbHandler.readContact();

        contactRVAdapter = new ContactRVAdapter(contactModalArrayList, viewContactsActivity.this);
        contactsRV = findViewById(R.id.idRVContacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewContactsActivity.this, RecyclerView.VERTICAL, false);
        contactsRV.setLayoutManager(linearLayoutManager);

        contactsRV.setAdapter(contactRVAdapter);
    }
}