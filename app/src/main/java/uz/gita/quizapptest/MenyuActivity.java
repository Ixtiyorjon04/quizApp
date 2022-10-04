package uz.gita.quizapptest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MenyuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menyu);
        TextView tests=findViewById(R.id.tests);
        TextView about=findViewById(R.id.Abouit);
        TextView quit=findViewById(R.id.qoit);

        tests.setOnClickListener(v -> {
            Intent intent = new Intent(this, TestlarActivity.class);
            startActivity(intent);
        });
        about.setOnClickListener(v -> {
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        });

        quit.setOnClickListener(v -> {
            AlertDialog dialog1 = new AlertDialog.Builder(MenyuActivity.this)
                    .setIcon(R.drawable.quiz)
                    .setTitle("Quit")
                    .setMessage("Do you want to log out?")
                    .setPositiveButton("Yes", (d, i) -> finish())
                    .setNegativeButton("No", (d, i) -> {
                    }).create();
            dialog1.show();
        });

    }
}