package org.example.function;

import org.example.category.CategoryDTO;

import java.util.List;

public abstract class ShowData {
    public String getName() {
        return null;
    };

    public String getName(String category) {
        return null;
    }

    public String getName(String category, int year) {
        return null;
    }

    public String showResult(List<CategoryDTO> categoryDTO) {
        return null;
    };

    public String showResult(List<CategoryDTO> categoryDTO, String category) {
        return null;
    };

    public String showResult(List<CategoryDTO> categoryDTO, String category, int year) {
        return null;
    };
}
