package com.test.markzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TcHomeActivity extends AppCompatActivity {
    Button updateMarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tc_home);
        TextView textView=(TextView)findViewById(R.id.txtdetails);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Button enterMarksButton = (Button) findViewById(R.id.enterMarksButton);
        updateMarks=findViewById(R.id.updateMarksButton);
        enterMarksButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(TcHomeActivity.this, EnterMmarks.class);
                        startActivity(i);
                    }
                }
        );
        Button viewMarksButton = (Button) findViewById(R.id.viewAllMarksButton);
        viewMarksButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        Intent i = new Intent(TcHomeActivity.this, ViewMarks.class);
                        startActivity(i);
                    }
                }
        );

        updateMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TcHomeActivity.this, tcupdatemarks.class);
                startActivity(i);
            }
        });
    }
}