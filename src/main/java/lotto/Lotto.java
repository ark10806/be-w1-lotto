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
}
