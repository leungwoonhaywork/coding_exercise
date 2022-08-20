package org.example.category;

public class Spend {
    private String category;
    private float amount;
    private int year;

    public Spend (String category, float amount, int year) {
        this.category = category;
        this.amount = amount;
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
