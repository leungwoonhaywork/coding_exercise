package org.example.function;

import org.example.category.CategoryDTO;
import java.util.List;

public class ShowAllTransactions extends ShowData {

    @Override
    public String getName(String category) {
        return "all transactions for " + category;
    }
    @Override
    public String showResult(List<CategoryDTO> categoryDTO, String category) {
        List<CategoryDTO> latestFirst = sortData(filterData(categoryDTO, category));
        String result = "";
        if (latestFirst.size() < 1){
            result = "No record found";
        }
        else {
            result = "     Transaction Date | Vendor    | Type         | Amount | Category\n";
            for (int i = 0; i < latestFirst.size(); i ++) {
                result += i + 1 + ". | " + latestFirst.get(i).getTransactionDate() + "       | " + latestFirst.get(i).getVendor();
                for (int j = 0; j < 9 - latestFirst.get(i).getVendor().length(); j ++) {
                    result += " ";
                }
                result += " | " + latestFirst.get(i).getType();
                for (int j = 0; j < 12 - latestFirst.get(i).getType().length(); j ++) {
                    result += " ";
                }
                result += " | £" + latestFirst.get(i).getAmount();
                for (int j = 0; j < 6 - String.valueOf(latestFirst.get(i).getAmount()).length(); j ++) {
                    result += " ";
                }
                result += " | " + latestFirst.get(i).getCategory() + "\n";
            }
        }

        return result;
    }

    public List<CategoryDTO> sortData(List<CategoryDTO> categoryDTO) {
        int n = categoryDTO.size();
        CategoryDTO temp;
        for (int i = 0; i < categoryDTO.size(); i ++) {
            for (int j = 1; j < (n - i); j ++) {
                if (categoryDTO.get(j - 1).getTransactionDate().isBefore(categoryDTO.get(j).getTransactionDate())) {
                    temp = categoryDTO.get(j - 1);
                    categoryDTO.set(j - 1, categoryDTO.get(j));
                    categoryDTO.set(j, temp);
                }
            }
        }
        return categoryDTO;
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
