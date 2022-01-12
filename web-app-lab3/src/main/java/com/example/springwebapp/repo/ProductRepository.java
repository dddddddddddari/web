package com.example.springwebapp.repo;

import com.example.springwebapp.models.Category;
import com.example.springwebapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoriesIn(Set<Category> categories);

}
