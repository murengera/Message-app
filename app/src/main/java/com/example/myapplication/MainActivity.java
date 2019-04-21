package com.example.myapplication;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


MyDB myDB;

Button log,regiseter;
EditText password;
AutoCompleteTextView usernames;
String[]users={"dalton,admin,claude,hope "};




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB=new MyDB(this);
        usernames=(AutoCompleteTextView)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        log=(Button)findViewById(R.id.login);
        regiseter=(Button)findViewById(R.id.regist);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.select_dialog_item,users);
        usernames.setThreshold(1);
        usernames.setAdapter(adapter);
        login();
        returnonregister();





            }

            public void returnonregister()
            {
                regiseter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,registeractivity.class);
                        startActivity(intent);
                    }
                });

            }






            public  void login()
            {
                log.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String firstname=usernames.getText().toString().trim();
                        String secret=password.getText().toString().trim();
                        Cursor cursor=myDB.getdata();


                         if (firstname.equals("") & secret.equals(""))
                         {
                             Toast.makeText(MainActivity.this, " empty field", Toast.LENGTH_LONG).show();
                         }


                         else if(firstname.equals("admin")& secret.equals("1234")){

                             Toast.makeText(MainActivity.this, "username and password is correct", Toast.LENGTH_LONG).show();
                             Intent intent=new Intent(MainActivity.this,navigation.class);
                             startActivity(intent);

                         }
                         else
                         {

                             Toast.makeText(MainActivity.this, "invalid username and password", Toast.LENGTH_SHORT).show();
                             Intent intent=new Intent(MainActivity.this,registeractivity.class);
                             startActivity(intent);
                         }




                    }
                }
                );

            }



        /*    public void showmessage(String message)
            {

                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage(message);
                builder.show();
            }*/


    }






