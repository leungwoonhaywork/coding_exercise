package org.example.category;

import java.time.LocalDate;

public class CategoryDTO {
    private LocalDate transactionDate;
    private String vendor;
    private String type;
    private float amount;
    private String category;

    public CategoryDTO(LocalDate transactionDate, String vendor, String type, float amount, String category) {
        this.transactionDate = transactionDate;
        this.vendor = vendor;
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String getVendor() {
        return vendor;
    }

    public String getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}
