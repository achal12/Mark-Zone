package com.test.markzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_homepage);
        Button btnteacher=(Button) findViewById(R.id.btnteacher);
        btnteacher.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Homepage.this, Teacherlogin.class);
                        startActivity(i);
                    }
                });

        Button btnstudent= (Button) findViewById(R.id.btnstudent);
        btnstudent.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Homepage.this, Studentlogin.class);
                        startActivity(i);
                    }
                });
    }
}