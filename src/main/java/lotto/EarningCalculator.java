package lotto;

import java.util.HashMap;
import java.util.Map;

public class EarningCalculator {

    public static double getEarningRate(LottoResult lottoResult) {
        double totalCount = 0.0;

        for(int i = 3; i <= 6; i++) {
            totalCount += (Rank.get(i) * lottoResult.getStatistics().get(i));
        }

        return (totalCount - lottoResult.getPrincipal()) / lottoResult.getPrincipal() * 100;
    }
}
