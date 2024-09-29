package com.AbhiKandS.ecommerce.service;

import com.AbhiKandS.ecommerce.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final List<Category> categories = new ArrayList<>();
    private long IdNumber = 0;


    @Override
    public String pushBackCategories(List<Category> newCategories) {
        StringBuilder result = new StringBuilder("Added \n");
        for (Category newCategory : newCategories) {
            newCategory.setCategoryID(++IdNumber);
            categories.add(newCategory);
            result.append(newCategory.getCategoryName()).append("\n");
        }

        return result.toString();
    }

    @Override
    public String pushBackCategory(String newCategoryName) {
        Category newCategory = new Category(++IdNumber, newCategoryName);
        categories.add(newCategory);
        return "Added " + newCategory.getCategoryName();
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String deleteCategory(long categoryID) {
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getCategoryID() == categoryID) {
                iterator.remove();
                return "Successfully removed " + categoryID;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category ID not found");
    }

    @Override
    public String updateCategory (long categoryID, String newCategoryName) {
        for (Category currentCategoryID : categories) {
            if (currentCategoryID.getCategoryID() == categoryID) {
                currentCategoryID.setCategoryName(newCategoryName);
                return "Successfully changed category";
            }
        }
    }
}
