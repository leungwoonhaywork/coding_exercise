package org.example.category;

public class CategoryOutgoing {
    private String category;

    private float amount;

    public CategoryOutgoing(String category, float amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
