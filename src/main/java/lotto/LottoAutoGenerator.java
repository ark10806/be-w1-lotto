package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoAutoGenerator implements LottoGenerator{
    @Override
    public Lotto generate() {
        HashSet<Integer> numberSet = new HashSet<>();
        while(numberSet.size() < 6) {
            numberSet.add((int)((Math.random()) * 45) + 1);
        }
        List<Integer> numbers = new ArrayList<>(numberSet);
        sort(numbers);
        return new Lotto(numbers);
    }
}
