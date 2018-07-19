package com.brainmatics.pos.core.sale;

import com.brainmatics.pos.core.employee.Employee;
import com.brainmatics.pos.core.product.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sale {
    private int id;
    private LocalDateTime time;
    private Employee cashier;
    private ArrayList<SaleLineItem> lineItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public ArrayList<SaleLineItem> getlineItems() {
        return lineItems;
    }

    public Sale() {
        time = LocalDateTime.now();
        lineItems = new ArrayList<>();
    }
    public void addlineItems(Product product, int quantity){
        SaleLineItem sli = new SaleLineItem(product,quantity );
        lineItems.add(sli);
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(SaleLineItem sli:lineItems){
            total = total.add(sli.getSubTotal());
        }
        return total;
    }
}
