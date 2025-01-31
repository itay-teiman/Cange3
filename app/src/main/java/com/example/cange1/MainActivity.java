package com.example.cange1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    Button clear, send;
    EditText e1;
    RadioGroup r1, r2;
    String selcte1="";
    String selecte2=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        clear = (Button) findViewById(R.id.button2);
        send = (Button) findViewById(R.id.button3);
        e1 = (EditText) findViewById(R.id.editTextText);
        r1 = (RadioGroup) findViewById(R.id.radioGroup1);
        r2 = (RadioGroup) findViewById(R.id.radioGroup2);

        clear.setOnClickListener(this);
        send.setOnClickListener(this);

        r1.setOnCheckedChangeListener((group, checkedId) -> {
            // בדוק איזה כפתור רדיו נבחר לפי ה-ID שלו
            RadioButton selectedRadioButton = findViewById(checkedId);
            if (selectedRadioButton != null) {
                selcte1 = selectedRadioButton.getText().toString();
            }
        });
        r2.setOnCheckedChangeListener((group, checkedId) -> {
            // בדוק איזה כפתור רדיו נבחר לפי ה-ID שלו
            RadioButton selectedRadioButton = findViewById(checkedId);
            if (selectedRadioButton != null) {
                selecte2 = selectedRadioButton.getText().toString();
            }
        });
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        View v = this.getWindow().getDecorView();
        if (view == clear) {
            e1.setText(" ");
        }

        if (view == send) {


           // המרה משקל
            if(selcte1.equals("ILSS")&& selecte2.equals("ILS")){
                e1.setText("same coin");
            }
            if(selcte1.equals("ILSS")&& selecte2.equals("USD")){

                int value = Integer.parseInt(String.valueOf(e1.getText()))*4;
                e1.setText(String.valueOf(value));

            }
            if(selcte1.equals("ILSS")&& selecte2.equals("EUR")){

                int value = Integer.parseInt(String.valueOf(e1.getText()))*5;
                e1.setText(String.valueOf(value));
            }

            // המרה מדולר

            if(selcte1.equals("USD")&& selecte2.equals("ILS")){
                int value = Integer.parseInt(String.valueOf(e1.getText()))/4;
                e1.setText(String.valueOf(value));
            }
            if(selcte1.equals("USD")&& selecte2.equals("USD")){

                e1.setText("same coin");

            }
            if(selcte1.equals("USD")&& selecte2.equals("EUR")){

                int value = Integer.parseInt(String.valueOf(e1.getText()))/5;
                e1.setText(String.valueOf(value));
            }

            // המרה ביורו

            if(selcte1.equals("EUR")&& selecte2.equals("ILS")){
                int value = Integer.parseInt(String.valueOf(e1.getText()))/5;
                e1.setText(String.valueOf(value));
            }
            if(selcte1.equals("EUR")&& selecte2.equals("USD")){

                int value = Integer.parseInt(String.valueOf(e1.getText()))/4;
                e1.setText(String.valueOf(value));

            }
            if(selcte1.equals("EUR")&& selecte2.equals("EUR")){

              e1.setText("same coin");
            }

           ////





        }
    }
}