package com.esteban_alo.android_hello_world;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    private EditText txtUserName;

    private TextView lblName;

    private Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = findViewById(R.id.txt_name);

        lblName = findViewById(R.id.lbl_greet_user);

        Button btnGreet = findViewById(R.id.btn_greet);
        btnGreet.setOnClickListener(this);

        Button btnClearText = findViewById(R.id.btn_cancel);
        btnClearText.setOnClickListener(this);

        FloatingActionButton btnInformation = findViewById(R.id.btn_information);
        btnInformation.setOnClickListener(this);

        builder = new Builder(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_greet:
                String name = txtUserName.getText().toString();
                greetUser(name);
                break;
            case R.id.btn_cancel:
                clearGreet();
                break;
            case R.id.btn_information:
                appInformation();
                break;
            default:
                break;
        }
    }

    public void greetUser(String userName) {
            String greetText = getResources().getString(R.string.lbl_greet_user);
            lblName.setText(greetText + " " + userName);
            lblName.setVisibility(View.VISIBLE);
    }


    public void clearGreet() {
        txtUserName.setText("");
        lblName.setText("");

    }

    public void appInformation() {
        builder.setTitle("Hello World");
        builder.setMessage("Using native Android.\n" +
                "Esteban_Alo");
        builder.setPositiveButton("OK",null);
        builder.create();
        builder.show();
    }
}
