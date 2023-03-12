package com.example.btap_b7_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_setting;

    LinearLayout view;
    TextView txt_noidung;
    String noidung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String color = preferences.getString(getString(R.string.key_color),"#FFFFFFFF");
        noidung = preferences.getString("textnumber", "0");

        view = findViewById(R.id.view_anh);
        txt_noidung = findViewById(R.id.txt_noidung);
        btn_setting = findViewById(R.id.btn_setting);
        view.setBackgroundColor(Color.parseColor(color));
        txt_noidung.setText(noidung);

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

}