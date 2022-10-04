package uz.gita.quizapptest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.gita.quizapptest.models.TestData;

public class Repository {


    private List<TestData> questions;

    private static Repository repository;

    private Repository() {

    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }

        return repository;
    }

    public void initQuestions(int n) {
        questions = new ArrayList<>();
        if (n == 1) {
            questions = new ArrayList<>();
            questions.add(new TestData("Тenglamani yeching .\nx +12 = 22", "20", "30", "10", "40", "10"));
            questions.add(new TestData("Amallarni bajaring .\n 2,7 + ( 3,2+2,8 ).", "8.7", " 8.8", " 9.1", " 7.4", "8.7"));
            questions.add(new TestData("Тenglamani yeching .\n  4x  =16", "2", "5", "3", "4", "4"));
            questions.add(new TestData("Algebraik ifodaning qiymatini toping.\na=2      v = 3   bo’lganda3a + 2 v– 7.", "6", "5", "8", "7", "5"));
            questions.add(new TestData("Тenglamani yeching.\n25x – 1 = 9", "0.4", "5", " 31", "33", " 0,7"));
            questions.add(new TestData("Birhadni darajaga ko’paytiring:\n 2x=6.", "2x", "3x", "4x", "5x", "3x"));
            questions.add(new TestData("Tenglamani  yeching .\n  8 x – 3 = 5 x + 12.", "5 ", "8", "4", "6", " 5 "));
            questions.add(new TestData("Tenglamani eching.– x – 1 = x;\n – x – 1 = x.", "x=2", "x= - 0,5", "x=0,5", "1", "x= - 0,5"));
            questions.add(new TestData("Tenglamani yeching.\na + 36 = 63.", "28", "25", "27", "29", "27"));
            questions.add(new TestData("Tenglamani yeching.\n (x - 5)(x + 4) + 0.", "3", " 9", "13", "5", "5"));
        }
        if (n == 2) {
            questions = new ArrayList<>();
            questions.add(new TestData("В каком причастии пишется буква Я?" , "Та..щий       ", "Кол..щий", "Гон..щийся  ", "Беле..щий ", "Кол..щий"));
            questions.add(new TestData(" Укажите слово (слова), с которыми НЕ пишется слитно:" , "(Не) распечатанное отцом письмо", "Еще (не) погасший костер", "Сочинение (не) написано", "На (не) просохшей дороге", "На (не) просохшей дороге"));
            questions.add(new TestData("В каком причастии пишется буква Е?", "Подстрел..нный охотником", "Засе..нное поле", "Развеш..нные картины", "Потер..нное время", "Подстрел..нный охотником"));
            questions.add(new TestData("В каком ряду в обоих причастиях на месте пропуска пишется буква Е?.", "Муч..мый, вообража..мый", "\tНезабыва..мый, невид..мый", "Преследу..мый, обрабатыва..мый", "Независ..мый, неисчерпа..мый", "Преследу..мый, обрабатыва..мый"));
            questions.add(new TestData("Сколько причастий употреблено в предложении?" + "\nНа берег был вытащен серый от старости, рассохшийся челн.", "2", "3", " 4", "6", " 2"));
            questions.add(new TestData("Найдите глагол::\n ", "молчать", " заход", " помощь", " молчание", " молчание "));
            questions.add(new TestData("Сколько причастий употреблено в предложении?\nГустые волосы прекрасного пепельного цвета расходились двумя тщательно." , "3 ", "5", "4", "2", " 2 "));
            questions.add(new TestData("В каком причастии верно обозначен ударный звук?", "начатА ", "взЯта", "прИбывший", " пОнявший", "начатА"));
            questions.add(new TestData("В каком словосочетании неверно выделено главное слово?", "тяжело дышащий.", "грохочущей повозкой", "рокочущая вдали ", "потерянный в лесу", "рокочущая вдали "));
            questions.add(new TestData("Какое утверждение является верным?", "Причастный оборот всегда выделяется запятыми.", "Действительные причастия обозначают признак", "От каждого глагола можно образовать все известные .", "Причастия не имеют краткой формы.", "Действительные причастия обозначают признак"));
        }
        if (n==3){
            questions.add(new TestData("Find the correct answer.\n“What is ______ name?” “My name’s Carlos.", "his", "her", "your", "my", "your"));
            questions.add(new TestData("Find the correct answer.\nI ______ student.", "is / an", " am / *", " am / the", " am / a", "am / a"));
            questions.add(new TestData("Find the correct answer.\nThis is my sister. ______ name is Laura", "His", "My", "Its", "Her", "Her"));
            questions.add(new TestData("Find the correct answer.\nI ______ 22 years old, but Andrew ______ 20.", "are / are", "are / am", "am / am", " am / is", " am / is"));
            questions.add(new TestData("Find the correct answer.\n ______ are you from? Japan.", "What", "Who", " Where", "When", " Where"));
            questions.add(new TestData("Find the correct answer.\nWe ______ students.", "are ", "am", "is", "are a", "are "));
            questions.add(new TestData("Find the correct answer.\nPierre is a French boy. ______ from ______ .", " He’s / France ", "His’s / French", "His / France", "He / France", " He’s / France "));
            questions.add(new TestData("Find the correct answer.\nShe ______ Italy.", "am from", "is from", "is at", "are from", "is from"));
            questions.add(new TestData("Find the correct answer.\nMy name is Lisa. ______ Lisa Peterson.", "I", "My am", "I is", "I am", "I am"));
            questions.add(new TestData("Find the correct answer.\nOxford is ______ English university.", "an", " the", "a", "* ", "an"));
        }
    }
    public void shuffle() {
        Collections.shuffle(questions);
    }

    public TestData getQuestion(int level) {
        return questions.get(level);
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}

