package org.example;

import org.example.category.CategoryDTO;
import org.example.category.MonthlyAverage;
import org.example.function.ShowMonthlyAverage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShowMonthlyAverageTester {
    public static ShowMonthlyAverage showMonthlyAverage;
    private List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

    private List<MonthlyAverage> result = new ArrayList<MonthlyAverage>();

    @BeforeAll
    public static void setClass() throws Exception {
        showMonthlyAverage = new ShowMonthlyAverage();
    }

    @BeforeEach
    public void setup() {
        categories.add(new CategoryDTO(addDate("30/09/2020"), "McMillan", "internet", 10, ""));
        categories.add(new CategoryDTO(addDate("01/10/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("01/12/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("01/09/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("01/10/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("28/10/2020"), "PureGym", "direct debit", 40, "MyMonthlyDD"));
        categories.add(new CategoryDTO(addDate("01/01/2021"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("28/10/2020"), "GYBG", "direct debit", 600, "MyMonthlyDD"));
        categories.add(new CategoryDTO(addDate("01/11/2020"), "Morrisons", "card", 10.4f, "Groceries"));
        result = showMonthlyAverage.addMonthlyAverage(showMonthlyAverage.filterData(categories, "Groceries"));
    }

    public static LocalDate addDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(date, formatter);
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
    public void testDate() {
        for (int i = 0; i < result.size() - 1; i ++) {
            for (int j = i + 1; j < result.size(); j ++) {
                Assertions.assertTrue(!(result.get(i).getYear() == result.get(j).getYear() && result.get(i).getMonth() == result.get(j).getMonth()));
            }
        }
    }
}
