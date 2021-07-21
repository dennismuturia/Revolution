package com.dennis.revolution_test;

import com.dennis.revolution_test.Models.Games;
import com.dennis.revolution_test.Service.GameService;
import com.dennis.revolution_test.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    private PlayerService playerService;
    @Autowired
    GameService gameService;

    @GetMapping("/balance/{id}")
    public long getBalance(@PathVariable("id") long id){
        return playerService.getBalance(id);
    }


    @PostMapping("/play/{id}")
    public String play(@PathVariable("id") long id,  @RequestBody Map<String, Integer> betAmount){
        if(playerService.hasFreeEntry(id,  betAmount.get("amount")))
            return playerService.play(id, betAmount.get("amount")).toString();
        else
            return "Please enter a value between 1 and 10";
    }

    @GetMapping("/all/games/{id}")
    public List<Games> getAllGames(@PathVariable("id")long id){
        return gameService.findGamesForaPlayer(id);
    }
}
