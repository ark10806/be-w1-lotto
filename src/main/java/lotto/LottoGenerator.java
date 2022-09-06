package lotto;

import java.util.Collections;
import java.util.List;

public interface LottoGenerator {
    Lotto generate();

    default void sort(List<Integer> numbers){
        Collections.sort(numbers);
    }
}
