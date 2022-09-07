package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    public int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public Award getAward(Lotto lotto) {
        int hitRate = 0;

        for (Integer i : this.numbers) {
            if (lotto.numbers.contains(i)) {
                hitRate++;
            }
        }

        if (hitRate == 5 && lotto.numbers.contains(bonus)) {
            return Award.SECOND;
        }

        return Award.getAwards(hitRate);
    }
}
