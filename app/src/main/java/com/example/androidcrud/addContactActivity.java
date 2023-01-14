package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addContactActivity extends AppCompatActivity {
    EditText contactName, contactPhone;
    Button addNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        contactName = findViewById(R.id.contactNameAdd);
        contactPhone = findViewById(R.id.editTextPhone);

        addNew = findViewById(R.id.addContactSubmitBtn);
    }

    public void addNewContact(View view) {
        String name  = contactName.toString().trim();
        String number = contactPhone.toString().trim();

        if (name == null && number == null)
            Toast.makeText(this, "One or more fields are empty", Toast.LENGTH_SHORT).show();
        else
           Toast.makeText(this, "Contact Added!!", Toast.LENGTH_SHORT).show();
    }
}