package com.test.markzone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterMmarks extends Activity {
    EditText enterName;
    EditText SSC;
    EditText CG;
    EditText WEB;
    EditText OOMD;
    EditText ELECTIVE;
    EditText deleteName;
    DatabaseHandler dbHandler;
    Button addEntry;
    Button deleteEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_mmarks);
        enterName =  findViewById(R.id.edusername);
        SSC = findViewById(R.id.edssc);
        CG =  findViewById(R.id.edcg);
        WEB =  findViewById(R.id.edweb);
        OOMD =  findViewById(R.id.edoomd);
        ELECTIVE =  findViewById(R.id.edelective);
        deleteName =  findViewById(R.id.deleteName);
        addEntry=findViewById(R.id.updatebtn);
        deleteEntry=findViewById(R.id.deleteEntryButton);
        dbHandler = new DatabaseHandler(this, null, null, 2);

        addData();
        deleteData();
    }

    public void reset() {
        // using this function to reset the string as empty
        enterName.setText("");
        SSC.setText("");
        CG.setText("");
        WEB.setText("");
        OOMD.setText("");
        ELECTIVE.setText("");
        deleteName.setText("");
    }


    public void addData(){
        addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterName.getText().toString().trim().length()==0 || SSC.getText().toString().trim().length()==0 || CG.getText().toString().trim().length()==0 || WEB.getText().toString().trim().length()==0 || OOMD.getText().toString().trim().length()==0 || ELECTIVE.getText().toString().trim().length()==0) {
                    Toast.makeText(getBaseContext(), "Please enter all details!", Toast.LENGTH_SHORT).show();
                    reset();
                }
                else {
                    String name = enterName.getText().toString();
                    String ssc = SSC.getText().toString();
                    String cg = CG.getText().toString();
                    String web = WEB.getText().toString();
                    String oomd = OOMD.getText().toString();
                    String elective = ELECTIVE.getText().toString();

                    Boolean checkinsertdata = dbHandler.insertuserdata(name, ssc, cg, web, oomd, elective);
                    if (checkinsertdata == true) {
                        Toast.makeText(EnterMmarks.this, "Record Inserted Successfully", Toast.LENGTH_SHORT).show();
                        reset();
                    } else {
                        Toast.makeText(EnterMmarks.this, "Record couldn't be Inserted", Toast.LENGTH_SHORT).show();
                        reset();
                    }
                }
            }
        });
    }



    public void deleteData(){
        deleteEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteName.getText().toString().trim().length() == 0) {
                    Toast.makeText(getBaseContext(), "Please enter the name of the Student", Toast.LENGTH_SHORT).show();
                    reset();
                } else {
                    String nameTXT = deleteName.getText().toString();
                    Boolean checkdeletedata = dbHandler.deletedata(nameTXT);
                    if (checkdeletedata == true){
                        Toast.makeText(EnterMmarks.this, "Record Deleted Successfully ", Toast.LENGTH_SHORT).show();
                        reset();
                    } else{
                        Toast.makeText(EnterMmarks.this, "No Record found", Toast.LENGTH_SHORT).show();
                        reset();
                    }
                }
            }
        });
    }


}