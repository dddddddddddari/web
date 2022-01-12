package com.example.springwebapp.services;

import com.example.springwebapp.models.Category;
import com.example.springwebapp.models.Product;
import com.example.springwebapp.repo.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public List<Product> getBySortLowToHigh() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }
    public List<Product> getBySortHighToLow() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    public Product find(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public List<Product> getByCategory(Set<Category> categories) {
        return productRepository.findByCategoriesIn(categories);

    }

}
