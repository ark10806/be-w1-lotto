package lotto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static LottoGenerator lottoGenerator = new LottoAutoGenerator();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        int cnt = (int) Math.floor(Integer.parseInt(br.readLine())/1000);
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
    }

}
