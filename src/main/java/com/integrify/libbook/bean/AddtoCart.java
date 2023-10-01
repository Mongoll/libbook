package com.integrify.libbook.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "add_to_cart")
public class AddtoCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book; // Establish a Many-to-One relationship with Book

    @Column(nullable = false)
    private int qty;

/*    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;*/

    @Column(name = "added_date", nullable = false, updatable = false)
    private LocalDateTime addedDate; // Use LocalDateTime for date/time

    @Column(name = "user_id", nullable = false)
    private Long userId;


    // Constructors, getters, setters, and other methods go here...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    /*public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }*/

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
