package org.example.start;

import org.example.category.CategoryDTO;
import org.example.display.DisplayManager;
import org.example.function.ShowAllTransactions;
import org.example.function.ShowData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    static DisplayManager displayManager = new DisplayManager();
    static Scanner scanner = new Scanner(System.in);
    static String input;
    static int num;
    public static void start() {
        displayManager.displayChoices();
        boolean isValidNumber;
        boolean isValidRange;
        input = scanner.nextLine();
        isValidNumber = checkIsInteger(input);
        handleInvalidInt(isValidNumber);
        num = Integer.parseInt(input);
        isValidRange = checkIntegerInRange(num);
        handleInvalidRange(isValidRange);
        Factory factory = new Factory();
        ShowData showData = null;
        try {
            showData = factory.getChoice(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CategoryDTO> categories = addCategory();
        if (num == 1 || num == 3) {
            displayManager.printCategoryQuestion();
            String category = scanner.nextLine();
            displayManager.printResult(showData, categories, category);
        }
        else if (num == 4 || num == 5) {
            displayManager.printCategoryQuestion();
            String category = scanner.nextLine();
            displayManager.printYearQuestion();
            String year = scanner.nextLine();
            boolean isVaildYear = checkIsInteger(year);
            handleInvalidInt(isVaildYear);
            displayManager.printResult(showData, categories, category, Integer.parseInt(year));
        }
        else if (num == 2){
            displayManager.printResult(showData, categories);
        }
        System.out.println("Do you want to continue? (y/n)");
        String yn = scanner.nextLine();
        if (yn.equalsIgnoreCase("y")) {
            start();
        }
    }

    public static boolean checkIsInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e ) {
            return false;
        }
    }

    public static boolean checkIntegerInRange(int input) {
        if (input < 1 || input > 5)
            return false;
        else
            return true;
    }

    public static void handleInvalidInt(boolean b) {
        while (!b) {
            displayManager.displayHintInt();
            displayManager.displayChoices();
            input = scanner.nextLine();
            b = checkIsInteger(input);
        }
    }

    public static void handleInvalidRange(boolean b) {
        while (!b) {
            displayManager.displayHintRange();
            displayManager.displayChoices();
            input = scanner.nextLine();
            boolean isValidNumber = checkIsInteger(input);
            handleInvalidInt(isValidNumber);
            num = Integer.parseInt(input);
            b = checkIntegerInRange(num);
        }
    }

    public static LocalDate addDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static List<CategoryDTO> addCategory() {
        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(new CategoryDTO(addDate("30/09/2020"), "McMillan", "internet", 10, ""));
        categories.add(new CategoryDTO(addDate("01/10/2020"), "M&S", "card", 5.99f, "Groceries"));
        categories.add(new CategoryDTO(addDate("28/10/2020"), "PureGym", "direct debit", 40, "MyMonthlyDD"));
        categories.add(new CategoryDTO(addDate("28/10/2020"), "GYBG", "direct debit", 600, "MyMonthlyDD"));
        categories.add(new CategoryDTO(addDate("01/11/2020"), "Morrisons", "card", 10.4f, "Groceries"));
        return categories;
    }
}
