package com.example.loginapp;
import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText uname, pwd;
    Button loginBtn;
    private CheckBox c1,c2;
    private RadioButton r1,r2;
    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = (EditText)findViewById(R.id.txtName);
        pwd = (EditText)findViewById(R.id.txtPwd);
        loginBtn = (Button)findViewById(R.id.btnLogin);
        r1= findViewById(R.id.radioButton);
        r2= findViewById(R.id.radioButton2);
        c1= findViewById(R.id.checkBox);
        c2= findViewById(R.id.checkBox2);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(MainActivity.this,DetailsActivity.class);
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                boolean male = r1.isChecked();
                boolean female = r2.isChecked();
                boolean cricket = c1.isChecked();
                boolean hockey = c2.isChecked();
                if(username.equals("divam") && password.equals("djdjdjdj")){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.putBoolean("Male",male);
                    editor.putBoolean("female",female);
                    editor.putBoolean("cricket",cricket);
                    editor.putBoolean("hockey",hockey);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}