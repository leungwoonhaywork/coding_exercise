package org.example.function;

import org.example.category.CategoryDTO;
import org.example.category.Spend;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class ShowLowestSpend extends ShowData{
    @Override
    public String getName(String category, int year) {
        return "highest spend in " +  category + " for " + year;
    }

    @Override
    public String showResult(List<CategoryDTO> categoryDTO, String category, int year) {
        List<Spend> categories = addSpend(filterData(categoryDTO, category, year));
        String result = "";
        if (categories.size() < 1) {
            result += "Record not found";
        }
        else {
            result = String.valueOf(findMin(categories));
        }
        return result;
    }

    public List<Spend> addSpend(List<CategoryDTO> categoryDTO) {
        List<Spend> categories = new ArrayList<>();
        for (int i = 0; i < categoryDTO.size(); i ++) {
            categories.add(new Spend(categoryDTO.get(i).getCategory(), categoryDTO.get(i).getAmount(), categoryDTO.get(i).getTransactionDate().getYear()));
        }
        return categories;
    }

    public List<CategoryDTO> filterData(List<CategoryDTO> categoryDTO, String category, int year) {
        for (int i = 0; i < categoryDTO.size(); i ++){
            if (!(categoryDTO.get(i).getCategory().equalsIgnoreCase(category) && categoryDTO.get(i).getTransactionDate().getYear() == year)) {
                categoryDTO.remove(i);
                i --;
            }
        }
        return categoryDTO;
    }

    public float findMin(List<Spend> category) {
        List<Spend> spendList = category;
        Spend max = spendList.stream().min(comparing(Spend::getAmount)).get();
        return max.getAmount();
    }
}
