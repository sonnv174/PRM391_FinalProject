package sonnvse04038.fpt.edu.vn.mobilequiz.Object;

/**
 * Created by sonnv174 on 3/23/2017.
 */

public class History {
    String userName, testName, timeStart, timeComplete;
    int duration;
    double mark;

    public History() {
    }

    public History(String userName, String testName, String timeStart, int duration, String timeComplete, double mark) {
        this.userName = userName;
        this.testName = testName;
        this.timeStart = timeStart;
        this.duration = duration;
        this.timeComplete = timeComplete;
        this.mark = mark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTimeComplete() {
        return timeComplete;
    }

    public void setTimeComplete(String timeComplete) {
        this.timeComplete = timeComplete;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
