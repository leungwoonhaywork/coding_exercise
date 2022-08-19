package org.example.function;

import org.example.category.CategoryDTO;

import java.util.List;

public interface ShowData {
    abstract String getName();

    public abstract String showResult(List<CategoryDTO> categoryDTO);
}
