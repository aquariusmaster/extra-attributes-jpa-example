package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;

    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="product_attributes", joinColumns=@JoinColumn(name="product_id"))
    private Map<String, String> attributes = new HashMap<>(); // maps from attribute name to value

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
