package com.example.admin.split;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        //String output = "";
        String in = "Nam | Kha";
        String [] a = in.split("\\|");
        Toast.makeText(getApplicationContext(),a[0],Toast.LENGTH_LONG).show();
        tv1.setText(a[0]);
        tv2.setText(a[1]);
    }
}
