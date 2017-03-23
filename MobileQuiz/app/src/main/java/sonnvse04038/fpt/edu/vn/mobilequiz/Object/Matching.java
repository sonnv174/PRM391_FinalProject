package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

/**
 * Created by sonnv174 on 3/22/2017.
 */

public class Matching {
    String rAnswer, mAnswer1,mAnswer2,mAnswer3,mAnswer4;
    int mId,tID,status;

    public Matching() {
    }


    public Matching(int mId,int tID,int status,String rAnswer,String mAnswer1, String mAnswer2, String mAnswer3,String mAnswer4)
    {

    }


    public Matching(int tID,int status,String rAnswer,String mAnswer1, String mAnswer2, String mAnswer3,String mAnswer4)
    {

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmAnswer3() {
        return mAnswer3;

    }

    public void setmAnswer3(String mAnswer3) {
        this.mAnswer3 = mAnswer3;
    }

    public String getmAnswer2() {

        return mAnswer2;
    }

    public void setmAnswer2(String mAnswer2) {
        this.mAnswer2 = mAnswer2;
    }

    public String getrAnswer() {

        return rAnswer;
    }

    public String getmAnswer1() {
        return mAnswer1;
    }

    public void setmAnswer1(String mAnswer1) {
        this.mAnswer1 = mAnswer1;
    }

    public void setrAnswer(String rAnswer) {
        this.rAnswer = rAnswer;
    }

    public String getmAnswer4() {
        return mAnswer4;

    }

    public void setmAnswer4(String mAnswer4) {
        this.mAnswer4 = mAnswer4;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }
}
