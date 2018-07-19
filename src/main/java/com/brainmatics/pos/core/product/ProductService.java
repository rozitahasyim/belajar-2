package com.brainmatics.pos.core.product;

import com.brainmatics.pos.core.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepo repository;

    @Autowired
    public ProductService(ProductRepo repository) {
        this.repository = repository;
    }

    public String generateCode(){
        return "P" + (repository.getCount() + 1);
    }

}
