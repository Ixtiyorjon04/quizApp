package uz.gita.quizapptest.contraxts;

import uz.gita.quizapptest.models.TestData;

public interface TestScreenContract {  interface View {

    //init view
    int initViews();

    void loadQuestion(TestData testData);

    void clearCheck(int position);

    void result(int correctAnswersCount, int totalQuestionCount);

    void changeState(int currentQuestionIndex, int totalQuestionCount);

    void nextButtonState(boolean state);
}

    interface Repository {
        void initQuestions(int n);

        TestData getQuestion(int index);

        void shuffle();

        int totalCount();
    }


    interface Presenter {
        void selectedAnswer(int position);

        void nextQuestion();

    }
}
