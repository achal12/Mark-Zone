package com.test.markzone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tcupdatemarks extends AppCompatActivity {
    Button updatebtn;
    EditText edssc;
    EditText edcg;
    EditText edweb;
    EditText edoomd;
    EditText edelective;
    EditText edusername;
    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcupdatemarks);
        TextView textView=(TextView)findViewById(R.id.txtupd);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        edssc=findViewById(R.id.edssc);
        edcg=findViewById(R.id.edcg);
        edweb=findViewById(R.id.edweb);
        edoomd=findViewById(R.id.edoomd);
        edelective=findViewById(R.id.edelective);
        edusername=findViewById(R.id.edusername);
        updatebtn=findViewById(R.id.updatebtn);
        dbHandler = new DatabaseHandler(this, null, null, 2);

        updateData();
        reset();
    }


    public void updateData(){
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edusername.getText().toString().trim().length() == 0 || edssc.getText().toString().trim().length() == 0 || edcg.getText().toString().trim().length() == 0 || edweb.getText().toString().trim().length() == 0 || edoomd.getText().toString().trim().length() == 0 || edelective.getText().toString().trim().length() == 0) {
                    Toast.makeText(getBaseContext(), "Please enter all the details!", Toast.LENGTH_SHORT).show();
                    reset();
                } else {
                    boolean checkupdatedata = dbHandler.updateData(edusername.getText().toString(), edssc.getText().toString(), edcg.getText().toString(), edweb.getText().toString(), edoomd.getText().toString(), edelective.getText().toString());
                    if (checkupdatedata == true ) {
                        Toast.makeText(tcupdatemarks.this, "Record Updated Successfully", Toast.LENGTH_SHORT).show();
                        reset();
                    } else
                        Toast.makeText(tcupdatemarks.this, "No such records could be found", Toast.LENGTH_SHORT).show();
                    reset();
                }
            }
        });
    }


    public void reset(){
        edusername.setText("");
        edssc.setText("");
        edcg.setText("");
        edweb.setText("");
        edoomd.setText("");
        edelective.setText("");

    }
}