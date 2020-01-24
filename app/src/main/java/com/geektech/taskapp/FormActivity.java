package com.geektech.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editDesk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editText = findViewById(R.id.editText);
        editDesk = findViewById(R.id.edit_desk);

    }

    public void onClick(View view) {
        String textName = editText.getText().toString().trim();
        String textSurname = editDesk.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("textName", textName);
        intent.putExtra("textSurname", textSurname);
        setResult(RESULT_OK, intent);
        finish();
    }
}
