package com.example.springwebapp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders", schema = "coffeshop")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "sum")
    private int sum;

    @ManyToMany(mappedBy = "orders")
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

}
