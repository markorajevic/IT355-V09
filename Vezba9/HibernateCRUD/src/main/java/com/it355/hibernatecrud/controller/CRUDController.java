package com.it355.hibernatecrud.controller;

import com.it355.hibernatecrud.dao.ShoppingCartDao;
import com.it355.hibernatecrud.entity.Category;
import com.it355.hibernatecrud.entity.Product;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", shoppingCartDao.getCategories());
        return "addProduct";
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public String addProduct(@PathVariable("id") int id, Model model) {
        Product product = shoppingCartDao.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", shoppingCartDao.getCategories());
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product") Product p, ModelAndView model) {
        p.setEnabled(Boolean.TRUE);
        p = shoppingCartDao.addProduct(p);
        model.addObject("categories", shoppingCartDao.getCategories());
        model.addObject("successMsg", "Product successfully added");
        model.addObject("product", p);
        return model;
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView addCategory(@ModelAttribute("category") Category p, ModelAndView model) {
        p.setEnabled(Boolean.TRUE);
        shoppingCartDao.addCategory(p);
        model.addObject("successMsg", "caetgory successfully added");
        return model;
    }

    @RequestMapping(value = "/seeProducts", method = RequestMethod.GET)
    public ModelAndView getProducts(ModelAndView model) {
        model.addObject("products", shoppingCartDao.getProducts());
        model.addObject("product", new Product());
        return model;
    }

    @RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("Fetching & Deleting product with id " + id);
        Product product = shoppingCartDao.getProductById(id);
        if (product == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        shoppingCartDao.deleteProduct(product);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
