package com.AbhiKandS.ecommerce.service;

import com.AbhiKandS.ecommerce.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    String pushBackCategories(List<Category> newCategories);
    String pushBackCategory(String newCategoryName);
    String deleteCategory(long categoryID);
    String updateCategory(long categoryID, String newCategoryName);
}
