package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private static final String LOVE_ALL = "Love-All";
    private static final String FIFTEEN_ALL = "Fifteen-All";
    private static final String THIRTY_ALL = "Thirty-All";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    private static final String WIN_FOR_PLAYER_1 = "Win for player1";
    private static final String WIN_FOR_PLAYER_2 = "Win for player2";
    private static final String STR = "-";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private Player player1 = new Player("player1");
    private Player player2 = new Player("player2");

    private int mScore1 = 0;
    private int mScore2 = 0;

    public void wonPoint(String playerName) {
        player1.updateScoreIfWon(playerName);
        player2.updateScoreIfWon(playerName);
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        if (mScore1 == mScore2) {
            score = getFinishedScore();
        } else if (mScore1 >= 4 || mScore2 >= 4) {
            score = getWinner();
        } else {
            getGoingScore(score);
        }
        return score.toString();
    }

    private void getGoingScore(StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = mScore1;
            else {
                score.append(STR);
                tempScore = mScore2;
            }
            switch (tempScore) {
                case 0:
                    score.append(LOVE);
                    break;
                case 1:
                    score.append(FIFTEEN);
                    break;
                case 2:
                    score.append(THIRTY);
                    break;
                case 3:
                    score.append(FORTY);
                    break;
            }
        }
    }

    private StringBuilder getWinner() {
        StringBuilder score;
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) score = new StringBuilder(ADVANTAGE_PLAYER_1);
        else if (minusResult == -1) score = new StringBuilder(ADVANTAGE_PLAYER_2);
        else if (minusResult >= 2) score = new StringBuilder(WIN_FOR_PLAYER_1);
        else score = new StringBuilder(WIN_FOR_PLAYER_2);
        return score;
    }

    private StringBuilder getFinishedScore() {
        StringBuilder score;
        switch (mScore1) {
            case 0:
                score = new StringBuilder(LOVE_ALL);
                break;
            case 1:
                score = new StringBuilder(FIFTEEN_ALL);
                break;
            case 2:
                score = new StringBuilder(THIRTY_ALL);
                break;
            default:
                score = new StringBuilder(DEUCE);
                break;

        }
        return score;
    }
}