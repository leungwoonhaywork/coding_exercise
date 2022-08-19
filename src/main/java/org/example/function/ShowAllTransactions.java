package org.example.function;

import org.example.category.CategoryDTO;
import java.util.List;

public class ShowAllTransactions implements ShowData {

    @Override
    public String getName() {
        return "all transactions for a given category - latest first";
    }

    @Override
    public String showResult(List<CategoryDTO> categoryDTO) {
        List<CategoryDTO> latestFirst = sortData(categoryDTO);
        String result = "     Transaction Date | Vendor    | Type         | Amount | Category\n";
        for (int i = 0; i < categoryDTO.size(); i ++) {
            result += i + 1 + ". | " + categoryDTO.get(i).getTransactionDate() + "       | " + categoryDTO.get(i).getVendor();
            for (int j = 0; j < 9 - categoryDTO.get(i).getVendor().length(); j ++) {
                result += " ";
            }
            result += " | " + categoryDTO.get(i).getType();
            for (int j = 0; j < 12 - categoryDTO.get(i).getType().length(); j ++) {
                result += " ";
            }
            result += " | " + categoryDTO.get(i).getAmount();
            for (int j = 0; j < 6 - String.valueOf(categoryDTO.get(i).getAmount()).length(); j ++) {
                result += " ";
            }
            result += " | " + categoryDTO.get(i).getCategory() + "\n";
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

}
