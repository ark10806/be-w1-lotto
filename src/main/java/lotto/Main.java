package lotto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static LottoGenerator lottoGenerator = new LottoAutoGenerator();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        int buyingPrice = Integer.parseInt(br.readLine());
        int cnt = (int) Math.floor(buyingPrice/1000);
        System.out.printf("%d개를 구매했습니다.\n", cnt);

        // 랜덤 숫자 출력
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < cnt ; i++){
            Lotto lotto = lottoGenerator.generate();
            lottos.add(lotto);
            System.out.println(lotto.toString());
        }

        // 지난 주 당첨 번호
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> hitsString = Arrays.asList(br.readLine().split(", "));
        List<Integer> hits = new ArrayList<>();
        for(String s : hitsString) hits.add(Integer.parseInt(s));

        // 당첨 통계
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Integer, Integer> awards = new HashMap<>();

        for(Lotto l : lottos){
            int hitRate = 0;
            if((hitRate = l.getHitRate(hits)) >= 3){
                awards.put(hitRate, awards.getOrDefault(hitRate, 0) + 1);
            }
        }

        System.out.printf("3개 일치 (5000원)- %d개\n", awards.getOrDefault(3, 0));
        System.out.printf("4개 일치 (50000원)- %d개\n", awards.getOrDefault(4, 0));
        System.out.printf("5개 일치 (1500000원)- %d개\n", awards.getOrDefault(5,0));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", awards.getOrDefault(6, 0));

        // 수익률
        long earningPrice = getTotalAwards(awards);
        double earningRate = ((earningPrice / (double)buyingPrice) - 1) * 100;
        System.out.printf("총 수익률을 %.2f%%입니다.", earningRate);
    }

    private static long getTotalAwards(Map<Integer, Integer> awards) {
        long total = 0;
        for(Map.Entry<Integer, Integer> map : awards.entrySet()){
            total += Award.getPrice(map.getKey()) * map.getValue();
        }
        return total;
    }

}
