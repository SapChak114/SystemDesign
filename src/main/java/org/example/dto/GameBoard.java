package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@SuperBuilder
public class GameBoard {
    protected Dice dice;
    protected Queue<Players> nextPlayer;
    protected List<Pipe> snakes;
    protected List<Pipe> ladders;
    protected Map<Players,Integer> playersCurrentPosition;
    protected int boardSize;
}
