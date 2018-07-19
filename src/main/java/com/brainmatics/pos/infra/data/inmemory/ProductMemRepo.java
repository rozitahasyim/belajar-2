package com.brainmatics.pos.infra.data.inmemory;

import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.product.ProductRepo;

import java.util.ArrayList;

public class ProductMemRepo implements ProductRepo {
    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount(){
        return data.size();
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
        for (Product p:data){
            if (p.getId() == id){
                data.remove(p);
            }
        }
    }

}
