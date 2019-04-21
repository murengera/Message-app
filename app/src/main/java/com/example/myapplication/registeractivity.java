package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registeractivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    MyDB myDB;


    EditText editfirstname,editlastname,editusername,editpassword;
    Button register, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        myDB=new MyDB(this);

        editfirstname=(EditText)findViewById(R.id.firstname);
        editlastname=(EditText)findViewById(R.id.lastname);
        editusername=(EditText)findViewById(R.id.username);
        editpassword=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.savedata);
        addData();
        goback();


    }

    public  void goback()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registeractivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }




 public  void addData()
 {

     register.setOnClickListener(new View.OnClickListener() {



         String fname=editfirstname.getText().toString().trim();
         String lname=editlastname.getText().toString().trim();
         String  user=editusername.getText().toString().trim();
         String pas=editpassword.getText().toString().trim();
         public void onClick(View v) {
             boolean isnserted = myDB.insert(fname, lname, user, pas);
             if (isnserted )
             {

                 Toast.makeText(registeractivity.this, "data is inserted", Toast.LENGTH_SHORT).show();
             }
             else
             {


                 Toast.makeText(registeractivity.this, "error occur", Toast.LENGTH_SHORT).show();
             }
         }
     });
 }





}
