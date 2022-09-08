package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    LottoAutoGenerator autoGenerator = new LottoAutoGenerator();
    LottoManualGenerator manualGenerator = new LottoManualGenerator();

    public List<Lotto> buyLottos(int buyingPrice) throws IOException {
        List<Lotto> lottos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCnt = Integer.parseInt(br.readLine());
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCnt; i++) {
            lottos.add(manualGenerator.generate());
        }

        // 자동 구매
        int autoCnt = (int) Math.floor(buyingPrice / 1000) - manualCnt;
        if(autoCnt < 0) autoCnt = 0;
        System.out.printf("수동으로 %d개, 자동으로 %d개를 구매했습니다.", manualCnt, autoCnt);
        lottos.addAll(getAndPrintAutoLottos(autoCnt));

        return lottos;
    }

    private List<Lotto> getAndPrintAutoLottos(int cnt){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Lotto lotto = autoGenerator.generate();
            lottos.add(lotto);
            System.out.println(lotto.toString());
        }
        return lottos;
    }
}
