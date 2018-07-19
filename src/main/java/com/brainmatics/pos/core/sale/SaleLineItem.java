package com.brainmatics.pos.core.sale;

import com.brainmatics.pos.core.product.Product;

import java.math.BigDecimal;

public class SaleLineItem {

    private int quantity;
    private BigDecimal unitprice;
    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        setUnitprice(product.getPrice());
    }

    public SaleLineItem(Product product, int quantity ) {
        setProduct(product);
        setQuantity(quantity);
    }

    public BigDecimal getSubTotal(){
        return unitprice.multiply(BigDecimal.valueOf(quantity));
    }


}
