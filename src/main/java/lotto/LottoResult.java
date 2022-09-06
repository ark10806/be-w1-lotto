package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> statistics;
    private final int principal;

    public LottoResult(Map<Integer, Integer> statistics, int principal) {
        this.statistics = statistics;
        this.principal = principal;
    }

    public int getPrincipal() {
        return principal;
    }

    public Map<Integer, Integer> getStatistics() {
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

    private boolean checkMap(Map<Integer, Integer> targetMap) {
        for (int i = 0; i <= 6; i++) {
            if (statistics.get(i) != targetMap.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = statistics != null ? statistics.hashCode() : 0;
        result = 31 * result + principal;
        return result;
    }
}
