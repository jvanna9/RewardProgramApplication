package com.janardhan.code.rewardsprogram.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerTransaction {
    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn //foreign key to customer
    private Customer customer;
    private Double total;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date saveDate;


    public CustomerTransaction() {
        super();
    }
    public CustomerTransaction(Long id, Customer customer, Double total, String description, Date date) {
        super();
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.description = description;
        this.saveDate = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }
}
