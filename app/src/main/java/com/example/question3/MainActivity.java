package com.example.question3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText r=(EditText) findViewById(R.id.mail);
    EditText subject=(EditText) findViewById(R.id.sub);
    EditText body=(EditText) findViewById(R.id.mesg);
    Button button = (Button) findViewById(R.id.button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            sendmail();
            }
        });
    }
    private void sendmail()
    {
        if(!r.getText().toString().isEmpty() && !subject.getText().toString().isEmpty()
                && !body.getText().toString().isEmpty()){

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{r.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,body.getText().toString());
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"Choose an email client"));


        }
        else{
            Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_LONG).show();
        }
    }
}