package uz.gita.quizapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TestlarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlar);
        TextView ozbek = findViewById(R.id.ozbek);
        TextView rus = findViewById(R.id.rus);
        TextView english = findViewById(R.id.english);
        ImageView chiqish=findViewById(R.id.chqish);
        chiqish.setOnClickListener(v->finish());
        english.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("subject",3);
            startActivity(intent);
        });
        ozbek.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("subject",1);
            startActivity(intent);
        });
        rus.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("subject",2);
            startActivity(intent);
        });
    }
}