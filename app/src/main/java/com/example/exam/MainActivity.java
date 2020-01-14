package com.example.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button login_btn;
    ImageView img_app_info;
    EditText userName, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = findViewById(R.id.login);
        img_app_info = findViewById(R.id.img_app_info);
        userName = findViewById(R.id.name);
        passWord = findViewById(R.id.password);

        login_btn.setOnClickListener(this);
        img_app_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                //if(userName.getText().toString().equals("admin") && passWord.getText().toString().equals("1234")){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new listView()).addToBackStack(null).commit();
                //}
                break;

            case R.id.img_app_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new icon()).addToBackStack(null).commit();
                break;
        }
    }
}
