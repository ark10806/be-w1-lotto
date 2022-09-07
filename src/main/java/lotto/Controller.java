package lotto;

import java.util.*;

public class Controller {
    private View view = new View();
    private int lottoNumber;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private ArrayList<Integer> winningNumbers;
    private int bonusNumber;
    private LinkedHashMap<Rank, Integer> winningCount;
    private double yield;

    public void start() {
        lottoNumber = view.inputMoney() / 1000;
        view.printLottoNumber(lottoNumber);
        buy();
        view.printLottos(lottos);
        winningNumbers = view.inputWinningNumbers();
        bonusNumber = view.inputBonusNumber();
        calculateWinningCount();
        calculateYield();
        view.printStat(winningCount, yield);
    }

    public void initWinningCount() {
        winningCount = new LinkedHashMap<>();
        winningCount.put(Rank.valueOf(3,false), 0);
        winningCount.put(Rank.valueOf(4,false), 0);
        winningCount.put(Rank.valueOf(5,false), 0);
        winningCount.put(Rank.valueOf(5,true), 0);
        winningCount.put(Rank.valueOf(6,false), 0);
    }

    public void calculateWinningCount() {
        initWinningCount();
        for (int i = 0; i < lottos.size(); i++) {
            int index = lottos.get(i).match(winningNumbers);
            boolean matched = false;
            if ( index == 4 && lottos.get(i).bonusMatch(bonusNumber) ) {
                index++;
                matched = true;
            }
            winningCount.put(Rank.valueOf(index, matched), winningCount.get(Rank.valueOf(index, matched))+1);
        }
    }

    public void calculateYield() {
        int totalWinnings = 0;
        for (int i = 3; i <= 6; i ++) {
            totalWinnings += winningCount.get(i) * Rank.valueOf(i, false).getWinningMoney();
        }
        yield = ((totalWinnings-(lottoNumber*1000))/(lottoNumber*1000.0))*100;
    }

    public void buy() {
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(new Lotto());
        }
    }
}
