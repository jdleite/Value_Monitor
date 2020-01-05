package br.com.value_monitor.model;

public class Values {
    private int id;
    private double value;
    private String day_month;
    private String dt_value;
    private String time_value;
    private int month_id;

    public Values(double value, String day_month, String time_value, String dt_value, int month_id) {
        this.value = value;
        this.day_month = day_month;
        this.time_value = time_value;
        this.dt_value = dt_value;
        this.month_id = month_id;
    }

    public Values() {
    }

    public String getDay_month() {
        return day_month;
    }

    public void setDay_month(String day_month) {
        this.day_month = day_month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDt_value() {
        return dt_value;
    }

    public void setDt_value(String dt_value) {
        this.dt_value = dt_value;
    }

    public String getTime_value() {
        return time_value;
    }

    public void setTime_value(String time_value) {
        this.time_value = time_value;
    }

    public int getMonth_id() {
        return month_id;
    }

    public void setMonth_id(int month_id) {
        this.month_id = month_id;
    }
}
