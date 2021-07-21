package com.dennis.revolution_test.Repository;

import com.dennis.revolution_test.Models.Games;
import com.dennis.revolution_test.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Games, Long> {
    @Query("select e from Games e where e.player=:player")
    List<Games>getAllGamesForPlayer(@Param("player")Player player);
}
