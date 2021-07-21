package com.dennis.revolution_test.Repository;

import com.dennis.revolution_test.Models.Games;
import com.dennis.revolution_test.Models.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@DataJpaTest
class GameRepositoryTest {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Test
    void shouldCheckByPlayer(){
        //given
        playerRepository.save(new Player(5000));
        Games game = new Games(20, 0, playerRepository.getById(1l));
        gameRepository.save(game);

        Games p = gameRepository.getById(1l);

        //when
        List<Games>allGames = gameRepository.getAllGamesForPlayer(playerRepository.getById(1l));
        //then
        Assertions.assertEquals(1, allGames.size());
    }


}