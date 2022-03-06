package edu.itson.posweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @Getter
    @Setter
    @Column(name = "total", nullable = false)
    private Float total;

    @Getter
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
    private List<SaleDetail> details;

    public Sale() {}

    public Sale(Calendar date, Float total, Client client, List<SaleDetail> details) {
        this.date = date;
        this.total = total;
        this.client = client;
        this.details = details;
    }
}
