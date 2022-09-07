package lotto;

public enum Award {
    FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000);

    public final Integer hit;
    public final Integer price;

    Award(int hit, int price) {
        this.hit = hit;
        this.price = price;
    }

    public static Award getAwards(int hit) {
        for (Award award : Award.values()) {
            if (award.hit == hit && award != SECOND) {
                return award;
            }
        }

        return null;
    }
}
