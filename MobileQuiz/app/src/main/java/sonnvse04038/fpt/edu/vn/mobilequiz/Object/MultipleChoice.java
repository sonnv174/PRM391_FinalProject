package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

import java.io.Serializable;

/**
 * Created by sonnv174 on 3/22/2017.
 */

public class MultipleChoice implements Serializable{

    private int mulID, tID, mulStatus;
    private String mulQuestion,mulRighAnswer, mulAnswer1, mulAnswer2, mulAnswer3, mulAnswer4;

    public MultipleChoice() {

    }

    public MultipleChoice(int mulID, int tID, String mulQuestion, int mulStatus, String mulRighAnswer, String mulAnswer1, String mulAnswer2, String mulAnswer3, String mulAnswer4) {
        this.mulID = mulID;
        this.tID = tID;
        this.mulQuestion = mulQuestion;
        this.mulStatus = mulStatus;
        this.mulRighAnswer = mulRighAnswer;
        this.mulAnswer1 = mulAnswer1;
        this.mulAnswer2 = mulAnswer2;
        this.mulAnswer3 = mulAnswer3;
        this.mulAnswer4 = mulAnswer4;
    }

    public MultipleChoice(int tID, String mulQuestion, int mulStatus, String mulRighAnswer, String mulAnswer1, String mulAnswer2, String mulAnswer3, String mulAnswer4) {
        this.tID = tID;
        this.mulQuestion = mulQuestion;
        this.mulStatus = mulStatus;
        this.mulRighAnswer = mulRighAnswer;
        this.mulAnswer1 = mulAnswer1;
        this.mulAnswer2 = mulAnswer2;
        this.mulAnswer3 = mulAnswer3;
        this.mulAnswer4 = mulAnswer4;
    }

    public int getMulID() {
        return mulID;
    }

    public void setMulID(int mulID) {
        this.mulID = mulID;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getMulQuestion() {
        return mulQuestion;
    }

    public void setMulQuestion(String mulQuestion) {
        this.mulQuestion = mulQuestion;
    }

    public int getMulStatus() {
        return mulStatus;
    }

    public void setMulStatus(int mulStatus) {
        this.mulStatus = mulStatus;
    }

    public String getMulRighAnswer() {
        return mulRighAnswer;
    }

    public void setMulRighAnswer(String mulRighAnswer) {
        this.mulRighAnswer = mulRighAnswer;
    }

    public String getMulAnswer1() {
        return mulAnswer1;
    }

    public void setMulAnswer1(String mulAnswer1) {
        this.mulAnswer1 = mulAnswer1;
    }

    public String getMulAnswer2() {
        return mulAnswer2;
    }

    public void setMulAnswer2(String mulAnswer2) {
        this.mulAnswer2 = mulAnswer2;
    }

    public String getMulAnswer3() {
        return mulAnswer3;
    }

    public void setMulAnswer3(String mulAnswer3) {
        this.mulAnswer3 = mulAnswer3;
    }

    public String getMulAnswer4() {
        return mulAnswer4;
    }

    public void setMulAnswer4(String mulAnswer4) {
        this.mulAnswer4 = mulAnswer4;
    }
}
