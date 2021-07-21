package com.dennis.revolution_test.Service;

import com.dennis.revolution_test.Models.Games;
import com.dennis.revolution_test.Repository.GameRepository;
import com.dennis.revolution_test.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    public List<Games> findGamesForaPlayer(long playerId){
        return gameRepository.getAllGamesForPlayer(playerRepository.getById(playerId));
    }
}
