package ExaME_Package;

import java.util.ArrayList;


/*
Klasa reprexentująca pojedyncze pytanie



UPDATES

15.05.2019 - Kotecki - otworzenie klasy



LIST OF THING TO IMPROVE/ADD

* Uzupełnić ciała metod

 */






public class Question {

    public Integer questionNumber;

    public String questionContent;
    public ArrayList<String> answers;

    public Integer correctAnswer;

    public Integer pointsForCorrectAnswer;
    public Integer pointsForWrongAnswer;


    public Question()
    {
        answers = new ArrayList<>();
    };
    //  CONSTRUCTOR

    public Question(Integer questionNumber, String questionContent, ArrayList<String> answers, Integer correctAnswer, Integer pointsForCorrectAnswer, Integer pointsForWrongAnswer) {
        this.questionNumber = questionNumber;
        this.questionContent = questionContent;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
        this.pointsForWrongAnswer = pointsForWrongAnswer;
    }


    //  GETTERS AND SETTERS





    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getPointsForCorrectAnswer() {
        return pointsForCorrectAnswer;
    }

    public void setPointsForCorrectAnswer(Integer pointsForCorrectAnswer) {
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
    }

    public Integer getPointsForWrongAnswer() {
        return pointsForWrongAnswer;
    }

    public void setPointsForWrongAnswer(Integer pointsForWrongAnswer) {
        this.pointsForWrongAnswer = pointsForWrongAnswer;
    }

    @Override
    public String toString() {
        System.out.println();
        return "\n\tQuestion{" +
                "questionNumber=" + questionNumber +
                ", questionContent='" + questionContent + '\'' +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                ", pointsForCorrectAnswer=" + pointsForCorrectAnswer +
                ", pointsForWrongAnswer=" + pointsForWrongAnswer +
                '}';
    }
}