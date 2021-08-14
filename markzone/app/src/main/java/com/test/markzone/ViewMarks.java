package com.test.markzone;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMarks extends Activity {
    TextView textView;
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);
        TextView textView=(TextView)findViewById(R.id.txtsubject);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        dbHandler = new DatabaseHandler(this, null, null, 2);

        textView=(TextView) findViewById(R.id.textView42);
        String dbstring = dbHandler.databaseToString();
        textView.setText(dbstring);
    }
}