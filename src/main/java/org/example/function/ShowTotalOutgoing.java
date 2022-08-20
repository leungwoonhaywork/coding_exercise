package org.example.function;

import org.example.category.CategoryDTO;
import org.example.category.CategoryOutgoing;

import java.util.ArrayList;
import java.util.List;

public class ShowTotalOutgoing extends ShowData{
    @Override
    public String getName() {
        return "total outgoing per category";
    }

    public String showResult(List<CategoryDTO> categoryDTO) {
        List<CategoryOutgoing> categories = addCategoryOutgoing2(categoryDTO);
        String result = "     Category    | Amount\n";
        for (int i = 0; i < categories.size(); i ++) {
            result += 1 + i + ". | " + categories.get(i).getCategory();
            for (int j = 0; j < 12 - categories.get(i).getCategory().length(); j ++) {
                result += " ";
            }
            result += "| " + categories.get(i).getAmount();
            result += "\n";
        }
        return result;
    }

    public List<CategoryOutgoing> addCategoryOutgoing(List<CategoryDTO> categoryDTO) {
        List<CategoryOutgoing> categories = new ArrayList<>();
        boolean categoryInList = false;
        categories.add(new CategoryOutgoing(categoryDTO.get(0).getCategory(), categoryDTO.get(0).getAmount()));
        for (int i = 1; i < categoryDTO.size(); i ++) {
            for (int j = 0; j < categories.size(); j ++) {
                if (categoryDTO.get(i).getCategory().equals(categories.get(j).getCategory())) {
                    categories.get(j).setAmount(categories.get(j).getAmount() + categoryDTO.get(i).getAmount());
                    categoryInList = true;
                }
            }
            if (categoryInList) {
                categoryInList = false;
            }
            else{
                categories.add(new CategoryOutgoing(categoryDTO.get(i).getCategory(), categoryDTO.get(i).getAmount()));
            }
        }
        return categories;
    }

    public List<CategoryOutgoing> addCategoryOutgoing2(List<CategoryDTO> categoryDTO) {
        List<CategoryOutgoing> categories = new ArrayList<>();
        for (int i = 0; i < categoryDTO.size(); i ++) {
            categories.add(new CategoryOutgoing(categoryDTO.get(i).getCategory(), categoryDTO.get(i).getAmount()));
        }
        for(int i = 1; i < categories.size(); i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (categories.get(i).getCategory().equals(categories.get(j).getCategory())) {
                    categories.get(j).setAmount(categories.get(j).getAmount() + categories.get(i).getAmount());
                    categories.remove(i);
                    i --;
                }
            }
        }
        return categories;
    }
}
