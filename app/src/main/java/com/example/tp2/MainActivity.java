package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.type.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
Button btn1;
Button btn2;
EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Button = (Button) findViewById(R.id.button6);
        Button button3 = (Button) findViewById(R.id.button7);
        Button button4 = (Button) findViewById(R.id.button8);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick(view);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick2(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick3(view);
            }
        });

    }
    public void onButtonClick(View view) {

        // get the text to pass
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        String textToPass = editText.getText().toString();

        // start the SecondActivity
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(Intent.EXTRA_TEXT, textToPass);
        startActivity(intent);
    }
    public void onButtonClick2(View view) {

        // get the text to pass
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void onButtonClick3(View view) {
        Date myDate;
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
        try {
            myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-10-03");
        } catch (ParseException e) {
            myDate = new Date();
        }
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, myDate.getTime());
        intent.putExtra(CalendarContract.Events.ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
        startActivity(Intent.createChooser(intent, "Add to calendar"));
    }

}

    

