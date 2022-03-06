package edu.itson.posweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Float price;

    @Getter
    @Setter
    @Column(name = "stock", nullable = false)
    private Integer stock;

    public Product() {
    }

    public Product(String name, Float price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(Long id, String name, Float price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
