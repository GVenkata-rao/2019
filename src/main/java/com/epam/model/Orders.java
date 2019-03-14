package com.epam.model;



import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    private double amount;

    private String userName;

    public Orders() {
        super();

    }

    public Integer getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getUserName() {
        return userName;
    }

    public Orders(double amount) {
        super();
        this.amount = amount;


    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}