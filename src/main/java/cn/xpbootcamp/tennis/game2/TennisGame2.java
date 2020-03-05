package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

import java.util.Optional;

public class TennisGame2 implements TennisGame {
    private Player player1 = new Player("player1");
    private Player player2 = new Player("player2");

    public String getScore() {
        String score = "";
        score = Optional.ofNullable(player1.getAllScore(player2)).orElse(score);

        score = Optional.ofNullable(player1.getPlayerAndOtherLoveScore(player2)).orElse(score);
        score = Optional.ofNullable(player2.getPlayerAndOtherLoveScore(player1)).orElse(score);
        score = Optional.ofNullable(player1.getPlayerScore(player2)).orElse(score);
        score = Optional.ofNullable(player2.getPlayerScore(player1)).orElse(score);

        score = Optional.ofNullable(player1.getWinnerInfo(player2)).orElse(score);
        score = Optional.ofNullable(player2.getWinnerInfo(player1)).orElse(score);
        return score;
    }

    public void wonPoint(String player) {
        player1.setPointIfWin(player);
        player2.setPointIfWin(player);
    }
}