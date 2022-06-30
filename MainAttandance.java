package com.example.wjconstraction;

public class MainAttandance {
    private String markworkerid;
    private String markmonth;
    private String markworkdays;
    private String markabsentdays;

    public MainAttandance(String markworkerid, String markmonth, String markworkdays, String markabsentdays) {
        this.markworkerid = markworkerid;
        this.markmonth = markmonth;
        this.markworkdays = markworkdays;
        this.markabsentdays = markabsentdays;
    }

    public MainAttandance() {
        this.markworkerid = "";
        this.markmonth = "";
        this.markworkdays = "";
        this.markabsentdays ="";
    }

    public String getMarkworkerid() {
        return markworkerid;
    }

    public void setMarkworkerid(String markworkerid) {
        this.markworkerid = markworkerid;
    }

    public String getMarkmonth() {
        return markmonth;
    }

    public void setMarkmonth(String markmonth) {
        this.markmonth = markmonth;
    }

    public String getMarkworkdays() {
        return markworkdays;
    }

    public void setMarkworkdays(String markworkdays) {
        this.markworkdays = markworkdays;
    }

    public String getMarkabsentdays() {
        return markabsentdays;
    }

    public void setMarkabsentdays(String markabsentdays) {
        this.markabsentdays = markabsentdays;
    }
}
