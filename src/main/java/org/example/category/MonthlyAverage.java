package org.example.category;

public class MonthlyAverage {
    private String category;
    private float amount;
    private int count;
    private int year;
    private int month;

    public MonthlyAverage(String category, float amount, int count, int year, int month) {
        this.category = category;
        this.amount = amount;
        this.count = count;
        this.year = year;
        this.month = month;
    }

    public String getCategory() {
        return  category;
    }

    public float getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
