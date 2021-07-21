package com.dennis.revolution_test.Service;

import com.dennis.revolution_test.Framework.Betting;
import com.dennis.revolution_test.Models.Games;
import com.dennis.revolution_test.Models.Player;
import com.dennis.revolution_test.Repository.GameRepository;
import com.dennis.revolution_test.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class PlayerService implements Betting {

    private int percentageOfWinning = 30;

    private int freePercentage = 10;

    Random chances;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;


    public int getBalance(long id){
        return playerRepository.getById(id).getBalance();
    }

    public int runRandom(){
        return r.nextInt(100-1) + 2;
    }
    @Override
    public void getChanceToWin(int percentage, long playerId, Games games) {
        int num  = runRandom();

        Player player1 = playerRepository.getById(playerId);
        if(percentage == percentageOfWinning && num <= 30){
            player1.setBalance(player1.getBalance() + 20);
            games.setWinAmount(20);
            if(player1.isFree()){
                player1.setFree(true);
            }
        }
        else if(percentage == freePercentage && num <= 10){
            player1.setFree(true);
        }else{
            player1.setFree(false);
        }

        playerRepository.save(player1);
        gameRepository.save(games);
    }

    public Games play(long playerId, int amount){
        Player player = playerRepository.getById(playerId);
        //check if the user has a chance to play for free

        Games games;
        if(!player.isFree()){
             games  = new Games(amount, 0, player);
             player.setBalance(player.getBalance()  - amount);
        }else{
            games = new Games(0, 0, player);
        }
        playerRepository.save(player);
        getChanceToWin(freePercentage, playerId, games);
        getChanceToWin(freePercentage, playerId, games);


        return games;
    }

    public boolean hasFreeEntry(long id, int amount){
        List<Games>playerGames = gameRepository.getAllGamesForPlayer(playerRepository.getById(id));
        if(playerGames.size() == 0 ){
            if(amount == 0 ||amount > 10 || amount < 1){
                return false;
            }
        }else{
            if(playerGames.get(playerGames.size() -1).getPlayer().isFree()){
                return true;
            }else{
                if(amount == 0){
                    return false;
                }
                if(amount > 10 || amount < 1) return false;
                return true;
            }
        }
        return true;
    }
}
