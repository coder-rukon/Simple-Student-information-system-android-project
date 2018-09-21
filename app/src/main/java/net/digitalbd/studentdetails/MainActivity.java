package net.digitalbd.studentdetails;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnAllStd,btnSaveStd;
    Context context;
    EditText viewName,viewId,viewContact,vDetails;
    Db db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        db = new Db(context);
        btnAllStd = (Button) findViewById(R.id.btnAllStd);
        btnSaveStd = findViewById(R.id.btnSaveStd);

        viewName = findViewById(R.id.name);
        viewId = findViewById(R.id.id);
        viewContact = findViewById(R.id.contact);
        vDetails = findViewById(R.id.details);

        btnSaveStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,id,details,contact;
                name = viewName.getText().toString();
                id= viewId.getText().toString();
                details = vDetails.getText().toString();
                contact = viewContact.getText().toString();
                if(name.isEmpty() || id.isEmpty() || contact.isEmpty()){
                    Toast.makeText(context,"Name, Id and Contact Field are Required.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Student student = new Student(name,id,details,"",contact);
                db.addStudent(student);
                Toast.makeText(context,"Student Save Successfully",Toast.LENGTH_SHORT).show();
                clearInputBox();
            }
        });

        btnAllStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AllStudents.class);
                startActivity(intent);
            }
        });


    }
    public void clearInputBox()
    {
        viewName.setText("");
        viewId.setText("");
        viewContact.setText("");
        vDetails.setText("");
    }
}
