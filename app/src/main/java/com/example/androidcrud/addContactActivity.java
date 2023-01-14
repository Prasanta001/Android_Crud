package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addContactActivity extends AppCompatActivity {
    private EditText contactName, contactPhone;
    private Button addNew;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        contactName = findViewById(R.id.contactNameAdd);
        contactPhone = findViewById(R.id.editTextPhone);

        addNew = findViewById(R.id.addContactSubmitBtn);

        dbHandler = new DBHandler(addContactActivity.this);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String conName = contactName.getText().toString();
                String conNumber = String.valueOf(Integer.parseInt(contactPhone.getText().toString().trim()));

                if (conName == null && conNumber == null) {
                    Toast.makeText(addContactActivity.this, "Empty fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewContact(conName, conNumber);
                Toast.makeText(addContactActivity.this, "Contact added", Toast.LENGTH_SHORT).show();
                contactName.setText("");
                contactPhone.setText("");
            }
        });
    }
}