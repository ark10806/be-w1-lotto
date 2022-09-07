package lotto;

public enum Rank {

    MISS(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6,2000000000, false);

    private int matchCount;
    private int reward;

    private boolean bonus;

    Rank(int matchCount, int reward, boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
    }
    public int getMatchCount(){
        return matchCount;
    }

    public int getReward(){
        return reward;
    }

    public boolean getBonus(){
        return bonus;
    }

    public static Rank getRankOfResult(int matchCount, boolean bonus){

        for (Rank rank : Rank.values()){
            if (rank.getMatchCount() == matchCount && rank.getBonus() == bonus)
                return rank;
        }
        return Rank.MISS;
    }
}
