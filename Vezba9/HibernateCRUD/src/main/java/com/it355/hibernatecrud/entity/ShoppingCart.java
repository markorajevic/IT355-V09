package com.it355.hibernatecrud.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "shoppingcarts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "shoppingDate")
    @Temporal(TemporalType.DATE)
    private Date shoppingDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.totalCost = 0.0;
        this.items = new ArrayList<ShoppingCartItem>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(Date shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public ShoppingCartItem findItemByProductId(int productId) {
        for (ShoppingCartItem shoppingCartItem : this.items) {
            if (shoppingCartItem.getProduct().getId() == productId) {
                return shoppingCartItem;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", totalCost=" + totalCost + ", shoppingDate=" + shoppingDate + ", enabled=" + enabled + ", paymentMethod=" + paymentMethod + ", items=" + items + '}';
    }
}