package com.aryaan.ankitha.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText1);
    }

    public void save(View view){
        String text1 = userName.getText().toString();//ankitha
        String text2 = password.getText().toString();//12345

        //File file = null;
        text1 = text1+" ";
        FileOutputStream fileOutputStream = null;
        try {
            //file.getPath();
            fileOutputStream = openFileOutput("data.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

    }

    public void next(View view){
        Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
