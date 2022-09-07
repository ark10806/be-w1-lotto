package lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private View view = new View();
    private int lottoNumber;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private ArrayList<Integer> winningNumbers;
    private ArrayList<Integer> winningCount;
    private double yield;
    ArrayList<Integer> winnings = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 2000000000));

    public void start() {
        lottoNumber = view.inputMoney() / 1000;
        view.printLottoNumber(lottoNumber);
        buy();
        view.printLottos(lottos);
        winningNumbers = view.inputWinningNumbers();
        calculateWinningCount();
        calculateYield();
        view.printStat(winningCount, winnings, yield);
    }

    public void calculateWinningCount() {
        winningCount = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            winningCount.add(0);
        }

        for (int i = 0; i < lottos.size(); i++) {
            int index = lottos.get(i).match(winningNumbers);
            winningCount.set(index, winningCount.get(index) + 1);
        }
    }

    public void calculateYield() {
        int totalWinnings = 0;
        for (int i = 3; i <= 6; i ++) {
            totalWinnings += winningCount.get(i) * winnings.get(i-3);
        }
        yield = ((totalWinnings-(lottoNumber*1000))/(lottoNumber*1000.0))*100;
    }

    public void buy() {
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(new Lotto());
        }
    }
}
