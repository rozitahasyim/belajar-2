package com.brainmatics.pos;

import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.sale.SaleLineItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SaleLineItemTest {
    @Test
    public void dsjsf(){
        Product p1 = new Product();
        p1.setPrice(BigDecimal.valueOf(500));

        SaleLineItem sli =  new SaleLineItem(p1,2);
        BigDecimal subTotal = sli.getSubTotal();

        assertEquals(BigDecimal.valueOf(1000),subTotal);
    }
}
