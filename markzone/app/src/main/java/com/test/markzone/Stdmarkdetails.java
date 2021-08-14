package com.test.markzone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Stdmarkdetails extends AppCompatActivity {
    TextView textView;
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_stdmarkdetails);
        TextView textView=(TextView)findViewById(R.id.txtsubject);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        dbHandler = new DatabaseHandler(this, null, null, 2);

        textView=(TextView) findViewById(R.id.textView42);
        String dbstring = dbHandler.databaseToString();
        textView.setText(dbstring);
    }
}