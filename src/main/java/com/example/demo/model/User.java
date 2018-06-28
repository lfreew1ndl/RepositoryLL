package com.example.demo.model;


import com.example.demo.enums.UserType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MyUser")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    private UserType type;

    private LocalDate lastRequest;

    private Double balance;

    public User() {
    }

    public User(String name, UserType type, LocalDate lastRequest, Double balance) {
        this.name = name;
        this.type = type;
        this.lastRequest = lastRequest;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public LocalDate getLastRequest() {
        return lastRequest;
    }

    public void setLastRequest(LocalDate lastRequest) {
        this.lastRequest = lastRequest;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
