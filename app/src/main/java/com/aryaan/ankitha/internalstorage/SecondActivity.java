package com.aryaan.ankitha.internalstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    TextView userNameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        userNameText = (TextView)findViewById(R.id.textView3);
        passwordText = (TextView)findViewById(R.id.textView5);
    }

    public void load(View view){

        /*what you see when you open the file ?
        anki 123
        what is actually contained in the file?
        97 110 107 105 32 49 50 51
                */
        try {
            FileInputStream fileInputStream = openFileInput("data.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read = fileInputStream.read()) != -1){
                buffer.append((char)read);
            }

            Log.d("ANKI",buffer.toString());
            //anki 123

            String text1 = buffer.substring(0,buffer.indexOf(" "));
            String text2 = buffer.substring(buffer.indexOf(" ")+1);

            userNameText.setText(text1);
            passwordText.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(SecondActivity.this, "Data loaded successfully", Toast.LENGTH_SHORT).show();
    }

    public void previous(View view){
        Toast.makeText(SecondActivity.this, "Previous", Toast.LENGTH_SHORT).show();
        Intent intent =  new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
