package com.janardhan.code.rewardsprogram.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy="customer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CustomerTransaction> transactions;

    public Customer() {
        super();
    }
    public Customer(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CustomerTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<CustomerTransaction> transactions) {
        this.transactions = transactions;
    }

}
