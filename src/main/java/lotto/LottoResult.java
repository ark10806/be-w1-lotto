package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> statistics;
    private final int principal;

    public LottoResult(Map<Rank, Integer> statistics, int principal) {
        this.statistics = statistics;
        this.principal = principal;
    }

    public int getPrincipal() {
        return principal;
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoResult lottoResult = (LottoResult) o;

        if (principal != lottoResult.principal) return false;

        return checkMap(lottoResult.statistics);
    }

    private boolean checkMap(Map<Rank, Integer> targetMap) {

        for (Rank rank : Rank.values()){
            if (statistics.get(rank) != targetMap.get(rank))
                return false;
        }

//        for (int i = 0; i <= 6; i++) {
//            if (statistics.get(i) != targetMap.get(i)) {
//                return false;
//            }
//        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = statistics != null ? statistics.hashCode() : 0;
        result = 31 * result + principal;
        return result;
    }
}
