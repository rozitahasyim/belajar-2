package com.brainmatics.pos.infra.data.mongodb;

import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.product.ProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class ProductMongoRepo implements ProductRepo {
    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount(){
        System.out.println("From MongoDB");
        return 1;
    }

    public Product getById(int id){
        for(Product p: data){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getAll(){
        return data;
    }

    public void insert(Product product) {
        data.add(product);
    }

    @Override
    public void update(Product entity) {

    }

    public void remove(int id){

    }
}
