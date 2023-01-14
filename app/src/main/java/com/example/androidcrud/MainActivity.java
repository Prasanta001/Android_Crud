package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addContact, viewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addContact = findViewById(R.id.addContactBtn);
        viewContact = findViewById(R.id.viewContactBtn);
    }

    public void newContactIntent(View view) {
        Intent i = new Intent(MainActivity.this, addContactActivity.class);
        startActivity(i);
    }
}