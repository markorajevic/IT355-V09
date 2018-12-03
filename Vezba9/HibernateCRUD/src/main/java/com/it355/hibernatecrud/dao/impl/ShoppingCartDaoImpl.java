package com.it355.hibernatecrud.dao.impl;

import com.it355.hibernatecrud.dao.ShoppingCartDao;
import com.it355.hibernatecrud.entity.Category;
import com.it355.hibernatecrud.entity.Product;
import com.it355.hibernatecrud.entity.ShoppingCart;
import com.it355.hibernatecrud.entity.ShoppingCartItem;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository("shoppingCartDao")
@Service
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    // instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    // kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    // potrebno je da sve metode koje pozivaju sesiju i rade nešto nad bazom imaju anotaciju @Transactional
    // to hibernate-u stavlja do znanja da treba da 'gleda' te metode i da one kreiraju transakciju neke vrste
    @Transactional
    public List<Product> getProducts() {
        List<Product> results = (List<Product>) getSession().createCriteria(Product.class).list();
        return results;
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        /*getSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult() je metoda koju omogucava Hibernate
            Ovo je vrsta SQL querry-ja pri cemu je tabela iz koje citamo podatke definisana kao atribut metode createCriteria, 
            dok su parametri po kojima pretrazujemo atributi metode Restrictions.eq(naziv parametra u bazi, 
            naziv parametra u entitetu). Za svaki parametar dodaje se posebna restrikcija.
            Ovaj kod bi mogao da se prevede u sql kao: SELECT * FROM PRODUCT WHERE ID=?
         */
        Product product = (Product) getSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult();
        return product;

    }

    @Override
    @Transactional
    public List<Category> getCategories() {
        List<Category> results = (List<Category>) getSession().createCriteria(Category.class).list();
        return results;
    }

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        Category category = (Category) getSession().createCriteria(Category.class).add(Restrictions.eq("id", id)).uniqueResult();
        return category;
    }

    @Override
    @Transactional
    public List<Product> getProductsByCategory(Category category) {
        return (List<Product>) getSession().createCriteria(Product.class).add(Restrictions.eq("category", category)).list();
    }

    @Override
    @Transactional
    public void saveCart(ShoppingCart cart) {
        cart.setShoppingDate(new java.util.Date());
        //getSession().saveOrUpdate(cart) kreira novi cart u tabeli SHOPPING_CART ili ako vec postoji unosi izmene poredjenjem
        getSession().saveOrUpdate(cart);
    }

    @Override
    @Transactional
    public List<ShoppingCart> getAllCarts() {
        List<ShoppingCart> carts = (List<ShoppingCart>) getSession().createCriteria(ShoppingCart.class).list();
        return carts;
    }

    @Transactional
    public List<ShoppingCartItem> getItemsByCart(ShoppingCart cart) {
        return (List<ShoppingCartItem>) getSession().createCriteria(ShoppingCartItem.class).add(Restrictions.eq("shoppingCart", cart)).list();
    }

    @Override
    @Transactional
    public void editCategory(Category category) {
        getSession().saveOrUpdate(category);

    }

    @Override
    @Transactional
    public void editProduct(Product product) {
        getSession().saveOrUpdate(product);

    }

    @Override
    @Transactional
    public Category addCategory(Category category) {
        return (Category) getSession().merge(category);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return (Product) getSession().merge(product);
    }

    @Override
    @Transactional
    public int getCountProducts() {
        Number result = (Number) getSession().createSQLQuery("select count(*) from products").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    @Transactional
    public int getCountProductsInCategory(int categoryId) {
        String hql = "select count(*) from products where category_id = :id";
        Number result = (Number) getSession().createSQLQuery(hql).setInteger("id", categoryId).uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Transactional
    @Override
    public ShoppingCart getCartById(Integer id) {
        ShoppingCart cart = (ShoppingCart) getSession().createCriteria(ShoppingCart.class).add(Restrictions.eq("id", id)).uniqueResult();
        return cart;
    }

    @Transactional
    @Override
    public void editCart(ShoppingCart cart) {
        getSession().saveOrUpdate(cart);
    }

    @Transactional
    @Override
    public void deleteProduct(Product product) {
        getSession().delete(product);
    }

    @Transactional
    @Override
    public void deleteCategory(Category category) {
        getSession().delete(category);
    }

    @Override
    public void deleteShoppingCart(ShoppingCart cart) {
        getSession().delete(cart);
    }

    @Override
    public void deleteItem(ShoppingCartItem item) {
        getSession().delete(item);
    }
}