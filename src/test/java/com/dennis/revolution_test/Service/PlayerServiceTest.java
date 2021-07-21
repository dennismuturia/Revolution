package com.dennis.revolution_test.Service;

import com.dennis.revolution_test.Models.Player;
import com.dennis.revolution_test.Repository.GameRepository;
import com.dennis.revolution_test.Repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataJpaTest
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    private AutoCloseable autoCloseable;

    @MockBean
    private GameRepository  gameRepository;

    private PlayerService playerService;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        playerService = new PlayerService();
    }

    @Test
    void getBalance() {
        long id = 1;
        //upon startup
        Mockito.when(playerRepository.getById(id)).thenReturn(new Player(5000));
        Assertions.assertEquals(5000, playerRepository.getById(id).getBalance());
    }
    //Testing the random numbers generation
    @Test
    void runRandom() {
        int rands;
        int low = 10000;
        int high = -10000;

        for(int i = 0; i <1000000; i++ ){
            rands = new Random().nextInt((100-1) + 2);
            if(rands > 100){
                Assertions.fail("More than 100 values generated");
            }
            if(rands < 0){
                Assertions.fail("Incorrect value of randoms numbers");
            }

            if(high < rands){
                high = rands;
            }
            if(low > rands){
                low = rands;
            }
        }
        if(low == high){
            Assertions.fail("The high count is the same as the low count. Check the method returning the random number");
        }
        if(low != 0){
            Assertions.fail("The low value shold be 0");
        }
        if(high != 100){
            Assertions.fail("the gighest value should be 100");
        }
    }

    @Test
    void hasFreeEntry() {
        Player p = new Player(5000);
        //when
        p.setFree(true);
        ArgumentCaptor<Player>playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        playerRepository.save(p);
        verify(playerRepository).save(playerArgumentCaptor.capture());

        Assertions.assertTrue(playerArgumentCaptor.getValue().isFree());
    }
}