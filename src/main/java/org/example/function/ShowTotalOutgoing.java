package org.example.function;

import org.example.category.CategoryDTO;
import org.example.category.CategoryOutgoing;

import java.util.ArrayList;
import java.util.List;

public class ShowTotalOutgoing implements ShowData{
    @Override
    public String getName() {
        return "total outgoing per category";
    }

    @Override
    public String showResult(List<CategoryDTO> categoryDTO) {
        List<CategoryOutgoing> categories = addCategoryOutgoing(categoryDTO);
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
}
