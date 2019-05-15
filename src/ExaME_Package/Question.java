package ExaME_Package;

import java.util.ArrayList;

public class Question {
    @Override
    public String toString() {
        return "Question{" +
                "questionNumber=" + questionNumber +
                ", questionContent='" + questionContent + '\'' +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                ", pointsForCorrectAnswer=" + pointsForCorrectAnswer +
                ", pointsForWrongAnswer=" + pointsForWrongAnswer +
                '}';
    }

    public Integer questionNumber;

    public String questionContent;
    public ArrayList<String> answers;

    public Integer correctAnswer;

    public Integer pointsForCorrectAnswer;
    public Integer pointsForWrongAnswer;



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
}