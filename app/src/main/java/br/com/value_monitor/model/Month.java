package br.com.value_monitor.model;


public class Month {
    private int id;
    private int month_id;
    private String month_name;
    private Double totValue;

    public Month(int month_id, String month_name, Double totValue) {
        this.month_id = month_id;
        this.month_name = month_name;
        this.totValue = totValue;
    }

    public Month() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth_name() {
        return month_name;
    }

    public void setMonth_name(String month_name) {
        this.month_name = month_name;
    }

    public Double getTotValue() {
        return totValue;
    }

    public void setTotValue(Double totValue) {
        this.totValue = totValue;
    }

    public int getMonth_id() {
        return month_id;
    }

    public void setMonth_id(int month_id) {
        this.month_id = month_id;
    }
}
