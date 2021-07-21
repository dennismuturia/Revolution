package com.dennis.revolution_test.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long playerId;
    private int balance;
    private boolean isFree;

    public Player(int balance){
        this.balance = balance;
    }

    public Player() {
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
