package com.it355.hibernatecrud.converter;

import com.it355.hibernatecrud.dao.ShoppingCartDao;
import com.it355.hibernatecrud.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
final class IntegerToCategory implements Converter<String, Category> {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Override
    public Category convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        System.out.println("Konvertujem u kategoriju");
        Category cat = shoppingCartDao.getCategoryById(valeu);
        return cat;
    }
}