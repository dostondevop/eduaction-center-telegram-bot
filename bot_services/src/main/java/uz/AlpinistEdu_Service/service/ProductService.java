package uz.AlpinistEdu_Service.service;

import uz.AlpinistEdu_Service.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService implements BaseService<Product> {

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        return products;
    }

    @Override
    public Product add(Product product) {
        return null;
    }

    @Override
    public Product get(UUID id) {
        return null;
    }

    @Override
    public boolean has(Product product, List<Product> list) {
        return false;
    }

    @Override
    public Product getById(UUID id) {
        return null;
    }

    @Override
    public List<Product> getList() {
        return List.of();
    }

    @Override
    public List<Product> read() {
        return List.of();
    }

    @Override
    public void write(List<Product> products) {

    }
}