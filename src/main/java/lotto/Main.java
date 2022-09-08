package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static LottoGenerator lottoGenerator = new LottoAutoGenerator();
    public static LottoSeller lottoSeller = new LottoSeller();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        int buyingPrice = Integer.parseInt(br.readLine());

        List<Lotto> lottos = lottoSeller.buyLottos(buyingPrice);

        // 지난 주 당첨 번호
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> hits = getHits(br.readLine());
        System.out.println("보너스 볼을 입력해주세요.");
        int bonus = Integer.parseInt(br.readLine());
        WinningLotto winningLotto = new WinningLotto(hits, bonus);

        // 당첨 통계
        Map<Award, Integer> awards = getAwards(lottos, winningLotto);
        printAwards(awards);

        // 수익률
        printEarningPrice(awards, buyingPrice);
    }

    private static List<Integer> getHits(String str) {
        List<String> hitsString = Arrays.asList(str.split(", "));
        List<Integer> hits = new ArrayList<>();
        for (String s : hitsString) hits.add(Integer.parseInt(s));
        return hits;
    }

    private static Map<Award, Integer> getAwards(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Award, Integer> awards = new EnumMap<>(Award.class);

        for (Lotto l : lottos) {
            Award award = winningLotto.getAward(l);
            if (award != null) {
                awards.put(award, awards.getOrDefault(award, 0) + 1);
            }
        }

        return awards;
    }

    private static void printAwards(Map<Award, Integer> awards) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("%d개 일치 (%d원)- %d개\n", Award.FIFTH.hit, Award.FIFTH.price, awards.getOrDefault(Award.FIFTH, 0));
        System.out.printf("%d개 일치 (%d원)- %d개\n", Award.FOURTH.hit, Award.FOURTH.price, awards.getOrDefault(Award.FOURTH, 0));
        System.out.printf("%d개 일치 (%d원)- %d개\n", Award.THIRD.hit, Award.THIRD.price, awards.getOrDefault(Award.THIRD, 0));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", Award.SECOND.hit, Award.SECOND.price, awards.getOrDefault(Award.SECOND, 0));
        System.out.printf("%d개 일치 (%d원)- %d개\n", Award.FIRST.hit, Award.FIRST.price, awards.getOrDefault(Award.FIRST, 0));
    }

    private static void printEarningPrice(Map<Award, Integer> awards, int buyingPrice) {
        long earningPrice = getTotalAwards(awards);
        double earningRate = ((earningPrice / (double) buyingPrice) - 1) * 100;
        System.out.printf("총 수익률을 %.2f%%입니다.", earningRate);
    }

    private static long getTotalAwards(Map<Award, Integer> awards) {
        long total = 0;
        for (Map.Entry<Award, Integer> entry : awards.entrySet()) {
            total += (long) (entry.getKey().price) * entry.getValue();
        }
        return total;
    }

}
