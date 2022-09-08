package lotto;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public interface LottoGenerator {
    Lotto generate() throws IOException;

    default void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
