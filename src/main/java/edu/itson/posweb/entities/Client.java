package edu.itson.posweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

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
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Sale> sales;

    public Client() {
    }

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Client(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
