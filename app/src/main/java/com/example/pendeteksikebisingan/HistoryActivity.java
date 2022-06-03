package com.example.pendeteksikebisingan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HistoryActivity extends AppCompatActivity {

    private ImageButton bHome;
    private ImageView bView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        bHome = findViewById(R.id.btnHome);
        bView = findViewById(R.id.btnView);

        bHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(HistoryActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        bView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(HistoryActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });
    }
}