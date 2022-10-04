package uz.gita.quizapptest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.ArrayList;
import java.util.List;

import uz.gita.quizapptest.contraxts.TestScreenContract;
import uz.gita.quizapptest.contraxts.impl.Presenterlmpl;
import uz.gita.quizapptest.contraxts.impl.Repositorylmpl;
import uz.gita.quizapptest.models.TestData;
public class MainActivity extends AppCompatActivity implements  TestScreenContract.View{
    private Button btnNext;
    private TextView textQuestion;
    private TextView textTestState;
    private List<MaterialRadioButton> radioButtons;
    TestScreenContract.Presenter presenter;
    ImageView exit;
    private int n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle= getIntent().getExtras();
         n= bundle.getInt("subject");

            setContentView(R.layout.activity_main);
        ImageView chiqish=findViewById(R.id.chqish);
        chiqish.setOnClickListener(v->finish());

        exit=findViewById(R.id.chqish);

        presenter = new Presenterlmpl(this, new Repositorylmpl());

    }

    @Override
    public int initViews() {
        radioButtons = new ArrayList<>();
        radioButtons.add(findViewById(R.id.radioA));
        radioButtons.add(findViewById(R.id.radioB));
        radioButtons.add(findViewById(R.id.radioC));
        radioButtons.add(findViewById(R.id.radioD));
        btnNext = findViewById(R.id.btnNext);
        btnNext.setEnabled(false);
        btnNext.setOnClickListener(v -> presenter.nextQuestion());
        textQuestion = findViewById(R.id.textQuestion);
        textTestState = findViewById(R.id.textState);
        initCheckersListener();
        return n;
    }

    @Override
    public void loadQuestion(TestData testData) {
        textQuestion.setText(testData.getQuestion());
        radioButtons.get(0).setText(testData.getVariantA());
        radioButtons.get(1).setText(testData.getVariantB());
        radioButtons.get(2).setText(testData.getVariantC());
        radioButtons.get(3).setText(testData.getVariantD());
    }


    @Override
    public void clearCheck(int position) {
        Log.d("TTT", "Position " + position);
        radioButtons.get(position).setChecked(false);
    }

    @Override
    public void result(int correctAnswersCount, int totalQuestionCount) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.cup)

                .setTitle("Result")
                .setMessage(correctAnswersCount + " / " + totalQuestionCount)

                .setNegativeButton("Finish", (d, i) -> finish())
                .show();
    }

    @Override
    public void changeState(int currentQuestionIndex, int totalQuestionCount) {
        textTestState.setText(currentQuestionIndex + " / " + totalQuestionCount);
    }

    @Override
    public void nextButtonState(boolean state) {
        btnNext.setEnabled(state);
    }


    //
    private void initCheckersListener() {
        for (int i = 0; i < radioButtons.size(); i++) {
            MaterialRadioButton radioButton = radioButtons.get(i);
            radioButton.setTag(i);
            radioButton.setOnClickListener(v -> presenter.selectedAnswer((Integer) v.getTag()));
        }
    }



}