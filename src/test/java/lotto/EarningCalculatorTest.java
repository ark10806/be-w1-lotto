package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EarningCalculatorTest {

    @Test
    void getEarningRate() {
        var earningCalculator = new EarningCalculator();

        var actual = earningCalculator.getEarningRate(new LottoResult(getResultMap(), 5000));

        assertThat(actual).isEqualTo(0);
    }

    private Map<Rank,Integer> getResultMap() {
        var resultMap = new HashMap<Rank, Integer>();
        resultMap.put(Rank.MISS, 0);
        resultMap.put(Rank.FIFTH, 1);
        resultMap.put(Rank.FOURTH, 0);
        resultMap.put(Rank.THIRD, 0);
        resultMap.put(Rank.SECOND, 0);
        resultMap.put(Rank.FIRST, 0);

        return resultMap;
    }
}