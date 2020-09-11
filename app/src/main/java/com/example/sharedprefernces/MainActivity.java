package com.example.sharedprefernces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText email;
    EditText password;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txtview1);
        preferences=getSharedPreferences("govardhan",MODE_PRIVATE);
        email=findViewById(R.id.edit1);
        password=findViewById(R.id.edit2);

        findViewById(R.id. button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=email.getText().toString();
                String p=password.getText().toString();
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("email",e);
                editor.putString("pass",p);
                editor.apply();
                Toast.makeText(MainActivity.this,"datasaved",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username= preferences.getString("email",null);
               String pass= preferences.getString("pass",null);
               textView.setText(""+username+"\n"+pass);

            }
        });

    }
}