package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

/**
 * Created by sonnv174 on 3/22/2017.
 */

public class MultipleChoice {
    private String question, answer1, answer2, answer3, answer4, righAnswer;
    private int tID;

    public MultipleChoice() {

    }

    public MultipleChoice(String question, String answer1, String answer2, String answer3, String answer4, String righAnswer, int tID) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.righAnswer = righAnswer;
        this.tID = tID;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getRighAnswer() {
        return righAnswer;
    }

    public void setRighAnswer(String righAnswer) {
        this.righAnswer = righAnswer;
    }
}
