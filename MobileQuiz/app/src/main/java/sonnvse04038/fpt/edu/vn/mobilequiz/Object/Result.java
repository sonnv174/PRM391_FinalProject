package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

/**
 * Created by admin on 3/23/2017.
 */

public class Result {
    int rID,uID,tID,time,duration;
    Double mark;

    public Result() {
    }

    public Result(int rID,int uID,int tID,int time,int duration,Double mark)
    {

    }
    public Result(int uID,int tID,int time,int duration,Double mark)
    {

    }
    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }
}
