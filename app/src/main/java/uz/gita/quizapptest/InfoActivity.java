package uz.gita.quizapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ImageView chiqish=findViewById(R.id.chqish);
        chiqish.setOnClickListener(v->finish());
        loadViews();

    }private void loadViews() {
        findViewById(R.id.chqish).setOnClickListener(v -> finish());}
}