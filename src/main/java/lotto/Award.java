package lotto;

public enum Award {
    FIRST(6, 2000000000), SECOND(5, 1500000), THIRD(4, 50000), FOURTH(3, 5000);

    public final Integer hit;
    public final Integer price;

    Award(int hit, int price) {
        this.hit = hit;
        this.price = price;
    }

    public static Integer getPrice(int hit) {
        for (Award award : Award.values()) {
            if (award.hit == hit) return award.price;
        }
        return 0;
    }
}
