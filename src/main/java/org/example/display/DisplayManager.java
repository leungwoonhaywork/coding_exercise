package org.example.display;

import org.example.category.CategoryDTO;
import org.example.function.ShowData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayManager {
    public static ArrayList<String> getMenuItems() {
        return new ArrayList<>(Arrays.asList("All transactions for a given category - latest first", "Total outgoing per category", "Monthly average spend in a given category", "Highest spend in a given category, for a given year", "Lowest spend in a given category, for a given year"));
    }

    public static void displayChoices() {
        System.out.println("Enter the number of the data you wish to check:");
        for (int i = 0; i < getMenuItems().size(); i ++) {
            System.out.println(i + 1 + ". " + getMenuItems().get(i));
        }
    }

    public static void displayHintInt() {
        System.out.println("Input must be an Integer!");
    }

    public static void displayHintRange() {
        System.out.println("Input must between 1 and 5!");
    }

    public static void printResult(ShowData showData, List<CategoryDTO> categoryDTO) {
        System.out.println("Showing the result of " + showData.getName());
        System.out.println(showData.showResult(categoryDTO));
    }

    public static void printResult(ShowData showData, List<CategoryDTO> categoryDTO, String category) {
        System.out.println("Showing the result of " + showData.getName(category));
        System.out.println(showData.showResult(categoryDTO, category));
    }

    public static void printResult(ShowData showData, List<CategoryDTO> categoryDTO, int year) {
        System.out.println("Showing the result of " + showData.getName());
        System.out.println(showData.showResult(categoryDTO));
    }


    public static void printCategoryQuestion() {
        System.out.println("Which category do you want to search for?");
    }
}
