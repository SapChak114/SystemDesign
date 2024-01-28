package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@Builder
public class GameBoard {
    private Dice dice;
    private Queue<Players> nextPlayer;
    private List<Pipe> snakes;
    private List<Pipe> ladders;
    private Map<Players,Integer> playersCurrentPosition;
    private int boardSize;

    public void startGame(){
        while(nextPlayer.size()>1){
            Players player = nextPlayer.poll();
            int currentPosition = playersCurrentPosition.get(player);
            int diceVal = dice.rollDice();
            int nextCell = currentPosition + diceVal;

            if(nextCell > boardSize){
                nextPlayer.add(player);
            }
            else if (nextCell == boardSize){
                System.out.println(player.getName()+" won the Match");
                break;
            } else{
                AtomicInteger nextPosition = new AtomicInteger();
                AtomicBoolean b = new AtomicBoolean();
                b.set(false);
                nextPosition.set(nextCell);
                snakes.forEach(o->{
                    if(o.getStartPoint()==nextCell){
                        nextPosition.set(o.getEndPoint());
                    }
                });

                if(nextPosition.get()!=nextCell){
                    System.out.println(player.getName()+" got bitten by snake at position "+nextCell);
                }

                ladders.forEach(o->{
                    if(o.getStartPoint()==nextCell){
                        nextPosition.set(o.getEndPoint());
                        b.set(true);
                    }
                });
                if(nextPosition.get()!=nextCell && b.get()){
                    System.out.println(player.getName()+" got a ladder at position "+nextCell);
                }
                if(nextPosition.get()==boardSize){
                    System.out.println(player.getName()+" has won the game...!!!");
                    break;
                } else{
                    playersCurrentPosition.put(player,nextPosition.get());
                    System.out.println(player.getName()+" has moved from poition "+nextCell+" to "+nextPosition.get());
                    nextPlayer.add(player);
                }
            }
        }
    }
}
