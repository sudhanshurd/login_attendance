package com.example.login_page;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etusername,etassword;
    Button btsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusername = findViewById(R.id.et_username);
        etassword = findViewById(R.id.et_password);
        btsubmit  = findViewById(R.id.bt_submit);


        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etusername.getText().toString().equals("admin")&&etassword.getText().toString().equals("admin")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successful");
                    builder.setMessage("Welcome to WCE Student App");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }else {
                    Toast.makeText(getApplicationContext(),"INVALID USERNAME AND PASSWORD",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void welcome(View view)
    {
        EditText editText = findViewById(R.id.et_username);
        String msg = editText.getText().toString();
        Intent intent = new Intent(this,message_activity.class);
        intent.putExtra("EXTRA_MESSAGE",msg);
        startActivity(intent);
    }
}
