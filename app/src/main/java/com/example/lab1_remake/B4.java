package com.example.lab1_remake;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class B4 extends AppCompatActivity implements View.OnClickListener {
    private EditText editNhap;
    private Button btnLoad;
    private TextView tvResult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b4);
        editNhap = (EditText) findViewById(R.id.inB4);
        btnLoad = (Button) findViewById(R.id.btnLoadB4);
        tvResult = (TextView) findViewById(R.id.textResultB4);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLoadB4){
            AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, tvResult, editNhap);
            String sleepTime = editNhap.getText().toString();
            asyncTaskRunner.execute(sleepTime);
        }
    }
}