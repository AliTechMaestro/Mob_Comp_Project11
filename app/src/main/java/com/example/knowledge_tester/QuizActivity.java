package com.example.knowledge_tester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Questions> questionsList;

    TextView questionNum, score, timer,Question;
    RadioButton rb_1,rb_2,rb_3;
    Button btnNext;

    Questions currentQues;

    int totalQues;
    int quesCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionsList = new ArrayList<>();
        questionNum = findViewById(R.id.quesNum);
        score = findViewById(R.id.Marks);
        timer = findViewById(R.id.timer);
        Question = findViewById(R.id.Ques);

        rb_1 = findViewById(R.id.rb1);
        rb_2 = findViewById(R.id.rb2);
        rb_3 = findViewById(R.id.rb3);

        btnNext = findViewById(R.id.nextBtn);

        addQuestions();

        totalQues = questionsList.size();

        showNextQuestion();

    }

    private void showNextQuestion() {
        if(quesCounter<totalQues){
            currentQues = questionsList.get(quesCounter);
            Question.setText(currentQues.getQues());
            rb_1.setText(currentQues.getOp1());
            rb_2.setText(currentQues.getOp2());
            rb_3.setText(currentQues.getOp3());

            quesCounter++;
        }
        else{
            finish();
        }
    }

    private void addQuestions() {
        questionsList.add(new Questions("بسم اللہ کے علاوہ قرآن مجید کی کتنی آیات ہیں؟","6236","6239","6666",1));
        questionsList.add(new Questions("قرآن پاک میں کل کتنے سجدے ہیں؟","15","14","16",2));
        questionsList.add(new Questions("کون سی سورت بسم اللہ سے شروع نہیں ہوتی؟","سورہ توبہ","سورہ اخلاص","سورہ یٰسین",1));
        questionsList.add(new Questions("قرآن میں کل پارے کتنے ہیں؟","40","25","30",3));
        questionsList.add(new Questions("قرآن مجید میں کتنی مکی سورتیں ہیں؟","86","89","88",1));

    }
}