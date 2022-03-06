package edu.itson.posweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sales_details")
public class SaleDetail {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Float price;

    @Getter
    @Setter
    @Column(name = "amount", nullable = false)
    private Float amount;

    @Getter
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    public SaleDetail() {}

    public SaleDetail(Integer quantity, Float price, Float amount, Product product, Sale sale) {
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
        this.product = product;
        this.sale = sale;
    }
}
