package com.brainmatics.pos;

import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.sale.Sale;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SaleTest {
    @Test
    public void new_sale_should_be_totaled_zero(){
        Sale sale = new Sale();
        BigDecimal total = sale.getTotal();
        assertEquals(total, BigDecimal.ZERO);
    }

    @Test
    public void sale_2_momogi_and_1_pepsi_should_6000(){
        Product p1 = new Product();
        p1.setPrice(BigDecimal.valueOf(500));
        Product p2 = new Product();
        p2.setPrice(BigDecimal.valueOf(5000));

        Sale sale = new Sale();
       // sale.addProducts(p1);
       // sale.addProducts(p1);
       // sale.addProducts(p2);
        sale.addlineItems(p1,2);
        sale.addlineItems(p2,1);
        assertEquals(BigDecimal.valueOf(6000), sale.getTotal());
    }

    @Test
    public void total_cannot_be_chenged(){
        Product p1 = new Product();
        p1.setPrice(BigDecimal.valueOf(500));
        Sale sale = new Sale();
        //sale.addProducts(p1);
        sale.addlineItems(p1,2);


        assertEquals(BigDecimal.valueOf(500), sale.getTotal());
        p1.setPrice(600);
        assertEquals(BigDecimal.valueOf(500), sale.getTotal());
    }

    @Test
    public void gettotal_salelineitem(){
        Product p1 = new Product();
        p1.setPrice(BigDecimal.valueOf(500));
        Product p2 = new Product();
        p2.setPrice(BigDecimal.valueOf(6000));
        Sale sale = new Sale();
        sale.addlineItems(p1,2);
        sale.addlineItems(p2,1);

        assertEquals(BigDecimal.valueOf(7000), sale.getTotal());
    }

}
