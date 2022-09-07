package lotto;

import java.util.HashMap;
import java.util.Map;

public class EarningCalculator {

    public static double getEarningRate(LottoResult lottoResult) {
        double totalCount = 0.0;

        for(Map.Entry<Rank, Integer> entry : lottoResult.getStatistics().entrySet()){
            totalCount += entry.getKey().getReward() * entry.getValue();
        }

        return (totalCount - lottoResult.getPrincipal()) / lottoResult.getPrincipal() * 100;
    }
}
