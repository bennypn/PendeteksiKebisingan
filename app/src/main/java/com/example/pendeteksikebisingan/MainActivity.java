package com.example.pendeteksikebisingan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button bWarn,bHistory, blight;
    private ImageView bLamp;
    private TextView stats, dbVal, lamptxt;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef;
    int flag =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bWarn = findViewById(R.id.btnWarn);
        bHistory = findViewById(R.id.btnHistory);
        stats = findViewById(R.id.status_tv);
        dbVal = findViewById(R.id.db_text);

        myRef = database.getReference("db");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Float Val = snapshot.getValue(Float.class);
                dbVal.setText(Val.toString());
                if(Val >= 80){
                    stats.setText("Motor Berisik");
                } else {
                    stats.setText("AMAN");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        ToggleButton toggle = (ToggleButton) findViewById(R.id.btnLamp);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myRef = database.getReference("light");
                    // The toggle is enabled
                    myRef.setValue(1);
                } else {
                    // The toggle is disabled
                    myRef = database.getReference("light");
                    myRef.setValue(0);
                }
            }
        });



//        bWarn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myRef = database.getReference("muffler");
//                myRef.setValue(1);
//            }
//        });

    }
}