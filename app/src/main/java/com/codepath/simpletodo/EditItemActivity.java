package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    Button saveButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent intent = getIntent();
        String content = intent.getStringExtra("Content");
        editText = (EditText)findViewById(R.id.editText);
        editText.setText(content);
        editText.setSelection(editText.getText().length());
        saveButton = (Button)findViewById(R.id.btnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("Content", editText.getText().toString());
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
