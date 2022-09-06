package lotto;

import java.util.List;

public class Lotto {
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> numbers;

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int getHitRate(List<Integer> hit) {
        int hitRate = 0;
        for (int i = 0; i < 6; i++) {
            hitRate = numbers.contains(hit.get(i)) ? hitRate + 1 : hitRate;
        }
        return hitRate;
    }
}
