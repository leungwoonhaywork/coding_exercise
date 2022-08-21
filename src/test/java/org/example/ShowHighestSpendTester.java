package org.example;

import org.example.category.CategoryDTO;
import org.example.category.Spend;
import org.example.function.ShowHighestSpend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShowHighestSpendTester {
    public static ShowHighestSpend showHighestSpend;
    private List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

    private List<Spend> result = new ArrayList<Spend>();

    private float maxResult = 0;

    @BeforeAll
    public static void setClass() throws Exception {
        showHighestSpend = new ShowHighestSpend();
    }

    @BeforeEach
    public void setup() {
        categories.add(new CategoryDTO(addDate("30/09/2020"), "McMillan", "internet", 10, ""));
        categories.add(new CategoryDTO(addDate("01/10/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("01/12/2020"), "M&S", "card", 1.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("01/09/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("01/10/2020"), "M&S", "card", 999.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("28/10/2020"), "PureGym", "direct debit", 40, "MyMonthlyDD"));
        categories.add(new CategoryDTO(addDate("01/01/2021"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("28/10/2020"), "GYBG", "direct debit", 600, "MyMonthlyDD"));
        categories.add(new CategoryDTO(addDate("01/11/2020"), "Morrisons", "card", 10.4f, "Groceries"));
        result = showHighestSpend.addSpend(showHighestSpend.filterData(categories, "Groceries", 2020));
        maxResult = showHighestSpend.findMax(result);
    }

    public static LocalDate addDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(date, formatter);
    }

    @Test
    public void testResult() {
        Assertions.assertEquals(999.99f, maxResult);
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(5, result.size());
    }

    @Test
    public void testCategory() {
        for (int i = 0; i < result.size(); i ++) {
            Assertions.assertEquals("Groceries", result.get(i).getCategory());
        }
    }

    @Test
    public void testYear() {
        for (int i = 0; i < result.size(); i ++) {
            Assertions.assertEquals(2020, result.get(i).getYear());
        }
    }
}
