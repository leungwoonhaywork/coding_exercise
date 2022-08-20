package org.example.function;

import org.example.category.CategoryDTO;
import org.example.category.CategoryOutgoing;
import org.example.category.MonthlyAverage;

import java.util.ArrayList;
import java.util.List;

public class ShowMonthlyAverage extends ShowData{
    @Override
    public String getName() {
        return "monthly average spend in a given category";
    }

    public String showResult(List<CategoryDTO> categoryDTO) {
        List<CategoryOutgoing> categories;
        return null;
    }

    public List<MonthlyAverage> addMonthlyAverage(List<CategoryDTO> categoryDTO) {
        List<MonthlyAverage> categories = new ArrayList<>();
        for (int i = 0; i < categoryDTO.size(); i ++) {
            categories.add(new MonthlyAverage(categoryDTO.get(i).getCategory(), categoryDTO.get(i).getAmount(), 1, categoryDTO.get(i).getTransactionDate().getYear(), categoryDTO.get(i).getTransactionDate().getMonthValue()));
        }
        for(int i = 1; i < categories.size(); i ++) {
            for (int j = i - 1; j > 0; j --) {
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
}
