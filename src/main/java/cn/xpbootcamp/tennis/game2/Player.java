package cn.xpbootcamp.tennis.game2;

public class Player {
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String ALL = "-All";
    public static final String DEUCE = "Deuce";
    public static final String FORTY = "Forty";
    public static final String ADVANTAGE = "Advantage ";
    public static final String WIN_FOR = "Win for ";
    public static final String STR = "-";
    public static final String PLAYER1 = "player1";
    private String name;
    private int point;
    private String res;


    public Player(String player) {
        name = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setPointIfWin(String player) {
        if(player.equals(name)) {
            point += 1;
        }
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getAllScore(Player player) {
        String score = null;
        if(getPoint() == player.getPoint()) {
            if (getPoint() < 4) {
                if (getPoint() == 0)
                    score = LOVE;
                if (getPoint() == 1)
                    score = FIFTEEN;
                if (getPoint() == 2)
                    score = THIRTY;
                score += ALL;
            }
            if (getPoint() >= 3)
                score = DEUCE;
        }
        return score;
    }

    public String getPlayerAndOtherLoveScore(Player player) {
        String score = null;
        if( getPoint() > 0 && player.getPoint() == 0 ){
            if (getPoint() == 1)
                setRes(FIFTEEN);
            if (getPoint() == 2)
                setRes(THIRTY);
            if (getPoint() == 3)
                setRes(FORTY);
            player.setRes(LOVE);
            score = getName().equals(PLAYER1)? getRes() + STR + player.getRes(): player.getRes() + STR + getRes();
        }
        return score;
    }

    public String getPlayerScore(Player player) {
        String score = null;
        if ( getPoint() > player.getPoint() && getPoint() < 4) {
            if (getPoint() == 2)
                setRes(THIRTY);
            if (getPoint() == 3)
                setRes(FORTY);
            if (player.getPoint() == 1)
                player.setRes(FIFTEEN);
            if (player.getPoint() == 2)
                 player.setRes(THIRTY);
            score = getName().equals(PLAYER1)? getRes() + STR + player.getRes(): player.getRes() + STR + getRes();
        }
        return score;
    }

    public String getWinnerInfo(Player player) {
        String score = null;
        if (getPoint()> player.getPoint() && player.getPoint() >= 3) {
            score = ADVANTAGE+getName();
        }

        if (getPoint() >= 4 && player.getPoint()>= 0 && (getPoint()- player.getPoint()) >= 2) {
            score = WIN_FOR+getName();
        }
        return score;
    }
}
