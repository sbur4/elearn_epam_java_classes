package com.epam.task_9.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    private Long id;
    private String name;
    private Long upcCode;
    private String madeIn;
    private Double price;
    private LocalDateTime expirationDate;
    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String name, Long upcCode, String madeIn, Double price, LocalDateTime expirationDate,
                   Integer quantity) {
        this.id = id;
        this.name = name;
        this.upcCode = upcCode;
        this.madeIn = madeIn;
        this.price = price;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

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

    public Long getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(Long upcCode) {
        this.upcCode = upcCode;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name)
                && Objects.equals(upcCode, product.upcCode) && Objects.equals(madeIn, product.madeIn)
                && Objects.equals(price, product.price) && Objects.equals(expirationDate, product.expirationDate)
                && Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, upcCode, madeIn, price, expirationDate, quantity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("upcCode=" + upcCode)
                .add("madeIn='" + madeIn + "'")
                .add("price=" + price)
                .add("expirationDate=" + expirationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")))
                .add("quantity=" + quantity)
                .toString();
    }
}