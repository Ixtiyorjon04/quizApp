package uz.gita.quizapptest.contraxts.impl;

import android.util.Log;

import uz.gita.quizapptest.contraxts.TestScreenContract;
import uz.gita.quizapptest.models.TestData;

public class Presenterlmpl implements TestScreenContract.Presenter {
    private TestScreenContract.View view;
    private TestScreenContract.Repository repository;
    private int index;
    private int totalCount;
    private int selectedAnswer = -1;
    private int correctAnswers;

    public Presenterlmpl(TestScreenContract.View view, TestScreenContract.Repository repository) {
        this.view = view;
        this.repository = repository;
        init();
    }

    private void init() {
       int n= view.initViews();
        repository.initQuestions(n);
        repository.shuffle();
        view.nextButtonState(false);
        totalCount = repository.totalCount();
        view.loadQuestion(repository.getQuestion(index));
        view.changeState(index + 1, totalCount);
    }

    @Override
    public void selectedAnswer(int position) {
        Log.d("TTT", "presenter selectedAnswer " + position + " " + selectedAnswer);
        view.nextButtonState(true);
        if (selectedAnswer > -1 && selectedAnswer != position) {
            view.clearCheck(selectedAnswer);
        }
        selectedAnswer = position;
    }

    @Override
    public void nextQuestion() {
        boolean isCompleted = isTestCompleted();

        if (isCompleted) {
            view.result(correctAnswers, totalCount);
            return;
        }

        index++;
        view.clearCheck(selectedAnswer);
        selectedAnswer = -1;
        view.nextButtonState(false);
        TestData question = repository.getQuestion(index);
        view.loadQuestion(question);
        view.changeState(index + 1, totalCount);

    }

    private boolean isTestCompleted() {
        TestData testData = repository.getQuestion(index);
        String userAnswer;
        switch (selectedAnswer) {
            case 0:
                userAnswer = testData.getVariantA();
                break;
            case 1:
                userAnswer = testData.getVariantB();
                break;
            case 2:
                userAnswer = testData.getVariantC();
                break;
            default:
                userAnswer = testData.getVariantD();
        }

        if (testData.getAnswer().equals(userAnswer))
            correctAnswers++;

        return totalCount - 1 == index;
    }
}



