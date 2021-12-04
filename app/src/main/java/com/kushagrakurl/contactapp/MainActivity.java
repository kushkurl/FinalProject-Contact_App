package com.kushagrakurl.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText name,pswrd,email;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editText);
        pswrd=(EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.editText3);

        save=(Button)findViewById(R.id.button);

        sharedpreferences = getSharedPreferences("players", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm  = name.getText().toString();
                String psd  = pswrd.getText().toString();
                String mail  = email.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("keyName", nm);
                editor.putString("keyPswrd", psd);
                editor.putString("keyEmail", mail);
                editor.commit();
                Toast.makeText(MainActivity.this,"Data has been saved!",Toast.LENGTH_LONG).show();

            }
        });

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.search_item:
                Toast.makeText(this, "Search" +item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Save_item:
                saveDate();
                return true;
            case R.id.View_item: {
                SharedPreferences preferences = getSharedPreferences("players", 0);
                String Name = preferences.getString("keyName","NA");
                String Password = preferences.getString("keyPswrd","NA");
                String E_mail = preferences.getString("keyEmail","NA");
                Toast.makeText(this, "Name:" +Name+" Password:"+Password+" Email:"+E_mail, Toast.LENGTH_SHORT).show();

                return true;
            }
            case R.id.Delete_item: {
                SharedPreferences preferences = getSharedPreferences("players", 0);
                preferences.edit().remove("keyName").remove("keyPswrd").remove("keyEmail").commit();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveDate() {
        String nm  = name.getText().toString();
        String psd  = pswrd.getText().toString();
        String mail  = email.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("keyName", nm);
        editor.putString("keyPswrd", psd);
        editor.putString("keyEmail", mail);
        editor.commit();
        Toast.makeText(MainActivity.this,"Data has been saved!",Toast.LENGTH_LONG).show();
    }
}