package com.geektech.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editText = findViewById(R.id.editText);
        editDesc = findViewById(R.id.edit_desk);
    }

    public void onClick(View view) {
        String textTitle = editText.getText().toString().trim();
        String textDesc = editDesc.getText().toString().trim();
        if (editText.getText().toString().equals("") && editDesc.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Вы не ввели данные!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            Task task = new Task(textTitle, textDesc);
            intent.putExtra("task", task);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
