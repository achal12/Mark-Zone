package com.test.markzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacherlogin extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;

    public void reset() {
        // using this function to reset the string as empty
        ed1.setText("");
        ed2.setText("");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_teacherlogin);
        ed1=(EditText)findViewById(R.id.etteachername);
        ed2=(EditText)findViewById(R.id.etteacherpass);
        b1=(Button)findViewById(R.id.btnsignin);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("sahyadri") &&
                        ed2.getText().toString().equals("sahyadri")) {
                    Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Teacherlogin.this,TcHomeActivity.class);
                    startActivity(i);
                    reset();
                }else{
                    Toast.makeText(getApplicationContext(), "Signin failed",Toast.LENGTH_SHORT).show();
                }

            }

        });

    }


}