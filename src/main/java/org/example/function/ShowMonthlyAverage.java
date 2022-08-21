package org.example.function;

import org.example.category.CategoryDTO;
import org.example.category.CategoryOutgoing;
import org.example.category.MonthlyAverage;

import java.util.ArrayList;
import java.util.List;

public class ShowMonthlyAverage extends ShowData{
    @Override
    public String getName(String category) {
        return "monthly average spend in " + category;
    }

    public String showResult(List<CategoryDTO> categoryDTO, String category) {
        List<MonthlyAverage> categories = addMonthlyAverage(filterData(categoryDTO, category));
        String result;
        if (categories.size() < 1) {
            result = "No record found";
        }
        else {
            result = "     Transaction Date | Average Spend\n";
            for (int i = 0; i < categories.size(); i ++) {
                result += 1 + i + ". | " + categories.get(i).getMonth() + "/"  + categories.get(i).getYear();
                for (int j = 0; j < 2 - String.valueOf(categories.get(i).getMonth()).length(); j ++) {
                    result += " ";
                }
                result += "          | £" + categories.get(i).getAmount() /  categories.get(i).getCount() + "\n";
            }
        }
        return result;
    }

    public List<MonthlyAverage> addMonthlyAverage(List<CategoryDTO> categoryDTO) {
        List<MonthlyAverage> categories = new ArrayList<>();
        for (int i = 0; i < categoryDTO.size(); i ++) {
            categories.add(new MonthlyAverage(categoryDTO.get(i).getCategory(), categoryDTO.get(i).getAmount(), 1, categoryDTO.get(i).getTransactionDate().getYear(), categoryDTO.get(i).getTransactionDate().getMonthValue()));
        }
        for(int i = 1; i < categories.size(); i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (categories.get(i).getCategory().equals(categories.get(j).getCategory()) && categories.get(i).getYear() == categories.get(j).getYear() && categories.get(i).getMonth() == categories.get(j).getMonth()) {
                    categories.get(j).setAmount(categories.get(j).getAmount() + categories.get(i).getAmount());
                    categories.get(j).setCount(categories.get(j).getCount() + 1);
                    categories.remove(i);
                    i --;
                }
            }
        }
        return categories;
    }

    public List<CategoryDTO> filterData(List<CategoryDTO> categoryDTO, String category) {
        for (int i = 0; i < categoryDTO.size(); i ++){
            if (!categoryDTO.get(i).getCategory().equalsIgnoreCase(category)) {
                categoryDTO.remove(i);
                i --;
            }
        }
        return categoryDTO;
    }
}
