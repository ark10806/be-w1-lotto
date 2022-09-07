package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private View view = new View();
    private int lottoCount;
    private int manualLottoCount;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private ArrayList<Integer> winningNumbers;
    private int bonusNumber;
    private LinkedHashMap<Rank, Integer> winningCount;
    private double yield;

    public void start() {
        lottoCount = view.inputMoney() / 1000;
        manualLottoCount = view.inputManualLottoCount(lottoCount);
        buyManualLottos(view.inputManualLottoNumbers(manualLottoCount));
        view.printLottoCount(lottoCount, manualLottoCount);
        buy();
        view.printLottoNumbers(lottos);
        winningNumbers = view.inputWinningNumbers();
        bonusNumber = view.inputBonusNumber(winningNumbers);
        calculateWinningCount();
        calculateYield();
        view.printStat(winningCount, yield);
    }

    public void buyManualLottos(ArrayList<ArrayList<Integer>> manualLottoNumbers) {
        lottos.addAll(manualLottoNumbers.stream().map(Lotto::new).collect(Collectors.toList()));
    }

    public void initWinningCount() {
        winningCount = new LinkedHashMap<>();
        winningCount.put(Rank.valueOf(3, false), 0);
        winningCount.put(Rank.valueOf(4, false), 0);
        winningCount.put(Rank.valueOf(5, false), 0);
        winningCount.put(Rank.valueOf(5, true), 0);
        winningCount.put(Rank.valueOf(6, false), 0);
    }

    public void calculateWinningCount() {
        initWinningCount();
        for (int i = 0; i < lottos.size(); i++) {
            int index = lottos.get(i).match(winningNumbers);
            boolean matched = false;
            if (index == 5 && lottos.get(i).bonusMatch(bonusNumber)) {
                matched = true;
            }
            if (index >= 3) {
                winningCount.replace(Rank.valueOf(index, matched), winningCount.get(Rank.valueOf(index, matched)) + 1);
            }
        }
    }

    public void calculateYield() {
        int totalWinnings = 0;

        Set<Rank> set = winningCount.keySet();
        Iterator<Rank> iter = set.iterator();
        while (iter.hasNext()) {
            Rank rank = ((Rank) iter.next());
            int count = winningCount.get(rank);
            totalWinnings += rank.getWinningMoney() * count;
        }

        yield = ((totalWinnings - (lottoCount * 1000)) / (lottoCount * 1000.0)) * 100;
    }

    public void buy() {
        for (int i = 0; i < lottoCount - manualLottoCount; i++) {
            lottos.add(new Lotto());
        }
    }
}
