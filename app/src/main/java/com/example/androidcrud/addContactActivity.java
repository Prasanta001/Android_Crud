package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addContactActivity extends AppCompatActivity {
    private EditText contactName, contactPhone;
    Button addNew;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        contactName = findViewById(R.id.contactNameAdd);
        contactPhone = findViewById(R.id.editTextPhone);

        addNew = findViewById(R.id.addContactSubmitBtn);

        dbHandler = new DBHandler(addContactActivity.this);

        addNew.setOnClickListener(v -> {
            String conName = contactName.getText().toString();
            String conNumber = contactPhone.getText().toString().trim();

            if (conName.isEmpty() || conNumber.isEmpty()){
                Toast.makeText(this, "One or more empty fields", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                dbHandler.addNewContact(conName, conNumber);
                Toast.makeText(addContactActivity.this, "Contact added", Toast.LENGTH_SHORT).show();
            }
            contactName.setText("");
            contactPhone.setText("");
        });
    }
}