package com.example.knowledge_tester;

public class Questions {
    private String ques,op1,op2,op3;
    private int correctAns;

    public Questions(String ques, String op1, String op2, String op3, int correctAns) {
        this.ques = ques;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.correctAns = correctAns;
    }

    public String getQues() {
        return ques;
    }
    public void setQues(String ques) {
        this.ques = ques;
    }
    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }
}
