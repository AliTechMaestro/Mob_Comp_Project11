package com.example.knowledge_tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView ques,score,quesNo,time;
    private List<Questions> question;
    private RadioGroup radio_grp;
    private RadioButton rb1,rb2,rb3;
    private Button btnNext;
    int totalQues;
    int counter=0;
    int sc;
    public Questions currentQues;


    ColorStateList clr;
    boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        question=new ArrayList<>();
        ques=findViewById(R.id.Ques);
        score=findViewById(R.id.Marks);
        quesNo=findViewById(R.id.quesNum);


        radio_grp=findViewById(R.id.radioGrp);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);

        btnNext=findViewById(R.id.nextBtn);

        clr=rb1.getTextColors();

        addQues();

        totalQues=question.size();
        showNextQues();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer==false){
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()){
                        checkAnswer();

                    }
                    else{
                        Toast.makeText(MainActivity2.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    showNextQues();
                }
            }
        });
    }

    private void checkAnswer() {
        answer=true;
        RadioButton selected=findViewById(radio_grp.getCheckedRadioButtonId());
        int ansNum=radio_grp.indexOfChild(selected)+1;
        if(ansNum==currentQues.getCorrectAns()){
            sc++;
            score.setText("Score :"+sc);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch (currentQues.getCorrectAns()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }
        if(counter<totalQues){
            btnNext.setText("Next");
        }
        else{
            btnNext.setText("Finish");

        }

    }



    private void showNextQues() {
        radio_grp.clearCheck();

        rb1.setTextColor(clr);
        rb2.setTextColor(clr);
        rb3.setTextColor(clr);

        if(counter<totalQues){

            currentQues=question.get(counter);
            ques.setText(currentQues.getQues());
            rb1.setText(currentQues.getOp1());
            rb2.setText(currentQues.getOp2());
            rb3.setText(currentQues.getOp3());

            counter++;
            btnNext.setText("Submit");
            quesNo.setText("Questions:"+counter+"/"+totalQues);
            answer=false;
        }
        else{
            finish();
        }
    }

    public void addQues() {
        question.add(new Questions("بسم اللہ کے علاوہ قرآن مجید کی کتنی آیات ہیں؟","6236","6239","6666",1));
        question.add(new Questions("قرآن پاک میں کل کتنے سجدے ہیں؟","15","14","16",2));
        question.add(new Questions("کون سی سورت بسم اللہ سے شروع نہیں ہوتی؟","سورہ توبہ","سورہ اخلاص","سورہ یٰسین",1));
        question.add(new Questions("قرآن میں کل پارے کتنے ہیں؟","40","25","30",3));
        question.add(new Questions("قرآن مجید میں کتنی مکی سورتیں ہیں؟","86","89","88",1));

    }


}