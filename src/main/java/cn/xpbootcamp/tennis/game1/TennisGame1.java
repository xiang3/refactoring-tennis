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
            score = getAllScore();
        } else if (mScore1 >= 4 || mScore2 >= 4) {
            score = getPlayerInfo();
        } else {
            getThreeRoundScore(score);
        }
        return score.toString();
    }

    private void getThreeRoundScore(StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = mScore1;
            else {
                score.append("-");
                tempScore = mScore2;
            }
            switch (tempScore) {
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
        }
    }

    private StringBuilder getPlayerInfo() {
        StringBuilder score;
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private StringBuilder getAllScore() {
        StringBuilder score;
        switch (mScore1) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}