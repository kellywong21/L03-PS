package sg.edu.rp.c346.problemstatement;

import java.io.Serializable;

public class DailyCA implements Serializable {
 private String dgGrade;
 private Integer week;

    public DailyCA(String dgGrade, Integer week) {
        this.dgGrade = dgGrade;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public void setDgGrade(String dgGrade) {
        this.dgGrade = dgGrade;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}
