package org.example;

import org.example.dto.Dice;
import org.example.dto.GameBoard;
import org.example.dto.Pipe;
import org.example.dto.Players;
import org.example.service.PlayGame;

import java.util.*;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Players player1 = new Players(1,"Subham");
        Players player2 = new Players(2,"Saptarshi");
        Queue<Players> nextPlayer = new LinkedList<>();
        nextPlayer.add(player1);
        nextPlayer.add(player2);

        List<Pipe> snakes = new ArrayList<>();
        snakes.add(new Pipe(10,2));
        snakes.add(new Pipe(99,12));

        List<Pipe> ladders = new ArrayList<>();
        ladders.add(new Pipe(5,25));
        ladders.add(new Pipe(40,89));

        Map<Players,Integer> playersCurrentPostion = new HashMap<>();
        playersCurrentPostion.put(player1,0);
        playersCurrentPostion.put(player2,0);

        PlayGame game = PlayGame.builder()
                .boardSize(100)
                .ladders(ladders)
                .snakes(snakes)
                .dice(dice)
                .nextPlayer(nextPlayer)
                .playersCurrentPosition(playersCurrentPostion)
                .build();

        game.startGame();
    }
}