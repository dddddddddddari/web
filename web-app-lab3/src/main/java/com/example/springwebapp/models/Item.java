package com.example.springwebapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Product product;
    private int count;

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }
}

