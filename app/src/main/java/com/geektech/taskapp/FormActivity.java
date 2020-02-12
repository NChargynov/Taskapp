package com.geektech.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editDesc;
    private Task task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editText = findViewById(R.id.editText);
        editDesc = findViewById(R.id.edit_desk);
        secondIntent();

//        Intent intent = getIntent();
//        intent.getSerializableExtra("task");
//        title = intent.getStringExtra("title");
//        desc = intent.getStringExtra("desc");
//        editText.setText(title);
//        editDesc.setText(desc);
    }

    private void secondIntent() {
        task = (Task) getIntent().getSerializableExtra("task");
        if (task != null) {
            editText.setText(task.getTitle());
            editDesc.setText(task.getDesc());
        }
    }


    public void onClick(View view) {
        String textTitle = editText.getText().toString().trim();
        String textDesc = editDesc.getText().toString().trim();
        if (textTitle.isEmpty() || textDesc.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Вы не ввели данные!", Toast.LENGTH_SHORT).show();
        } else {
            if (task != null) {
                task.setTitle(textTitle);
                task.setDesc(textDesc);
                App.getDataBase().taskDao().update(task);
            } else {
                task = new Task(textTitle, textDesc);
                App.getDataBase().taskDao().insert(task);
            }
            finish();
        }
    }
}