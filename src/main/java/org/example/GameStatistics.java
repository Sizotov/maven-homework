package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class GameStatistics {

    private int wins;
    private int losses;

    public GameStatistics() {
        this.wins = 0;
        this.losses = 0;
    }

    public void incrementWins() {
        wins++;
    }
    public void incrementLosses() {
        losses++;
    }
    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

}
