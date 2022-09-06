package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EarningCalculatorTest {

    @Test
    void getEarningRate() {
        var earningCalculator = new EarningCalculator();

        var actual = earningCalculator.getEarningRate(new LottoResult(getResultMap(), 3500));

        assertThat(actual).isEqualTo(57142900);
    }

    private Map getResultMap() {
        var resultMap = new HashMap<Integer, Integer>();
        resultMap.put(0, 1);
        resultMap.put(1, 0);
        resultMap.put(2, 0);
        resultMap.put(3, 1);
        resultMap.put(4, 0);
        resultMap.put(5, 0);
        resultMap.put(6, 1);

        return resultMap;
    }
}