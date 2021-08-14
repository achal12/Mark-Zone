package com.test.markzone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Stdmarkresult extends AppCompatActivity {
    DatabaseHandler dbHandler;
    EditText etname;
    TextView tvmark1;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_stdmarkresult);
        TextView textView = (TextView) findViewById(R.id.tvInternal);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        etname = findViewById(R.id.Stdname);
        dbHandler = new DatabaseHandler(this, null, null, 2);
        btnsubmit = findViewById(R.id.btnsubmit);
        result();
        reset();
    }

    public void result(){
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stdname=etname.getText().toString();
                if(stdname.equals(String.valueOf(""))){
                    etname.setError("Please Enter Your Name");
                    return;
                }
                Cursor cursor = dbHandler.getData(stdname);
                String data = null;
                if (cursor.moveToNext()) {
                    data =  "NAME                      :\t\t " + cursor.getString(0) + "\n\n" +
                            "SSC marks             :\t\t "  + cursor.getString(1) + "\n\n" +
                            "CG marks               :\t\t "  + cursor.getString(2) + "\n\n" +
                            "WEB marks            :\t\t "  + cursor.getString(3) + "\n\n" +
                            "OOMD marks         :\t\t "  + cursor.getString(4) + "\n\n" +
                            "ELECTIVE marks   :\t\t "  + cursor.getString(5) + "\n\n" ;
                    showMessage("YOUR RESULT : \n\n" , data);
                    reset();
                }else{
                    showMessage("RESULT" , "No Records found");
                    reset();
                }
            }
        });
    }


    public void reset(){
        etname.setText("");
    }
    public void showMessage(String title , String msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();

    }
}