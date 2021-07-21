package com.dennis.revolution_test.Repository;

import com.dennis.revolution_test.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
