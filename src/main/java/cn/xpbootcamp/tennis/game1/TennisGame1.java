package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {
    private int mScore1 = 0;
    private int mScore2 = 0;

    public void wonPoint(String playerName) {

        if (playerName.equals("player1"))
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (mScore1 == mScore2) {
            return getAllScore();
        } else if (mScore1 >= 4 || mScore2 >= 4) {
           return getPlayerInfo();
        } else {
            return getTwoPlayerScore();
        }
    }

    private String getTwoPlayerScore() {
        String score1 = getPlayerScore(mScore1);
        String score2 = getPlayerScore(mScore2);
        return String.join("-", score1, score2);
    }

    private String getPlayerScore(int mScore) {
        StringBuilder score = new StringBuilder();
        switch (mScore) {
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
        }
        return score.toString();
    }

    private String getPlayerInfo() {
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getAllScore() {
        switch (mScore1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}