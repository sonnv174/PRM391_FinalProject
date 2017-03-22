package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

import java.io.Serializable;

/**
 * Created by sonnv174 on 3/22/2017.
 */

public class FillBlank implements Serializable{

    private int tID, fID, fStatus;
    private String fQuestion, fAnswer1, fAnswer2, fAnswer3, fAnswer4, fAnswer5;

    public FillBlank(int tID, int fID, int fStatus, String fQuestion, String fAnswer1, String fAnswer2, String fAnswer3, String fAnswer4, String fAnswer5) {
        this.tID = tID;
        this.fID = fID;
        this.fStatus = fStatus;
        this.fQuestion = fQuestion;
        this.fAnswer1 = fAnswer1;
        this.fAnswer2 = fAnswer2;
        this.fAnswer3 = fAnswer3;
        this.fAnswer4 = fAnswer4;
        this.fAnswer5 = fAnswer5;
    }

    public FillBlank() {
    }

    public int getfStatus() {
        return fStatus;
    }

    public void setfStatus(int fStatus) {
        this.fStatus = fStatus;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public String getfQuestion() {
        return fQuestion;
    }

    public void setfQuestion(String fQuestion) {
        this.fQuestion = fQuestion;
    }

    public String getfAnswer1() {
        return fAnswer1;
    }

    public void setfAnswer1(String fAnswer1) {
        this.fAnswer1 = fAnswer1;
    }

    public String getfAnswer2() {
        return fAnswer2;
    }

    public void setfAnswer2(String fAnswer2) {
        this.fAnswer2 = fAnswer2;
    }

    public String getfAnswer3() {
        return fAnswer3;
    }

    public void setfAnswer3(String fAnswer3) {
        this.fAnswer3 = fAnswer3;
    }

    public String getfAnswer4() {
        return fAnswer4;
    }

    public void setfAnswer4(String fAnswer4) {
        this.fAnswer4 = fAnswer4;
    }

    public String getfAnswer5() {
        return fAnswer5;
    }

    public void setfAnswer5(String fAnswer5) {
        this.fAnswer5 = fAnswer5;
    }


}
