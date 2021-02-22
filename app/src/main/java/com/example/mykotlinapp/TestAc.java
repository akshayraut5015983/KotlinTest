package com.example.mykotlinapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TestAc extends AppCompatActivity {
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        EditText ad = findViewById(R.id.edOne);
        EditText edTh = findViewById(R.id.edth);
        EditText wsTwp = findViewById(R.id.edtwo);
        findViewById(R.id.btnSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(ad.getText().toString());
                user.setMob(edTh.getText().toString());
                user.setPass(wsTwp.getText().toString());
                adddTolist(user);
            }
        });
        findViewById(R.id.btnPrint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (User ss : dd) {
                    Log.e("TAG", "onClick: " + ss.getMob());
                }
                ListView listView = findViewById(R.id.list);

            }
        });
    }


    ArrayList<User> dd = new ArrayList<>();

    private void adddTolist(User toString) {

        dd.add(toString);

    }
}
