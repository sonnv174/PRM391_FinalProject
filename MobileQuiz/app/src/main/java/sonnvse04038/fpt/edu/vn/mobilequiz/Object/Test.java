package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

/**
 * Created by sonnv174 on 3/23/2017.
 */

public class Test {
    private int tID;
    private String tName, info;
    private int time, tStatus;

    public Test() {
    }

    public Test(int tID, String tName, String info, int time, int tStatus) {
        this.tID = tID;
        this.tName = tName;
        this.info = info;
        this.time = time;
        this.tStatus = tStatus;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int gettStatus() {
        return tStatus;
    }

    public void settStatus(int tStatus) {
        this.tStatus = tStatus;
    }
}
