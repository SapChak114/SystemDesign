package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Dice {
    private int noOfDice;

    public int rollDice(){
        return (int)((Math.random()*(6*noOfDice-1*noOfDice))+1);
    }

    public static void main(String[] args) {
        Dice dice = new Dice(1);
        System.out.println(dice.rollDice());
    }
}
