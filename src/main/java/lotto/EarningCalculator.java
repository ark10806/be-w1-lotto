package lotto;

import java.util.HashMap;
import java.util.Map;

public class EarningCalculator {
    private final Map<Integer, Integer> prizeTable = new HashMap<>();

    public EarningCalculator() {
        prizeTable.put(3, 5000);
        prizeTable.put(4, 50000);
        prizeTable.put(5, 1500000);
        prizeTable.put(6, 2000000000);
    }

    public double getEarningRate(LottoResult lottoResult) {
        double totalCount = 0.0;

        for(int i = 3; i <= 6; i++) {
            totalCount += (prizeTable.get(i) * lottoResult.getStatistics().get(i));
        }

        return (totalCount - lottoResult.getPrincipal()) / lottoResult.getPrincipal() * 100;
    }
}
