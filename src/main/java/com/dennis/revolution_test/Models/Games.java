package com.dennis.revolution_test.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;
    private int cost;
    private int winAmount;
    @OneToOne
    private Player player;

    public Games(){}

    public Games(int cost, int winAmount, Player player){
        this.cost = cost;
        this.winAmount = winAmount;
        this.player = player;
    }
}
