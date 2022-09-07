package lotto;

public enum ScoreBoard {
    FIRST(6, 2000000000),
    BONUS(6+1, 30000000),
    SECOND(5, 1500000),
    THIRD(5, 50000),
    FOURTH(4, 5000);

    private int matchNum;
    private int winningMoney;

    private ScoreBoard(int matchNum, int winningMoney){
        this.matchNum = matchNum;
        this.winningMoney = winningMoney;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
