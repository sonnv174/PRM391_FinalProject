package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

/**
 * Created by admin on 3/23/2017.
 */

public class Result {
    int rID,uID,tID;
    Double mark;
    String timeStart,duration;

    public Result() {
    }

    public Result(int rID, int uID, int tID, Double mark, String timeStart, String duration) {
        this.rID = rID;
        this.uID = uID;
        this.tID = tID;
        this.mark = mark;
        this.timeStart = timeStart;
        this.duration = duration;
    }

    public Result(int uID, int tID, Double mark, String timeStart, String duration) {
        this.uID = uID;
        this.tID = tID;
        this.mark = mark;
        this.timeStart = timeStart;
        this.duration = duration;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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