package lotto;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int coin;
        ArrayList<HashSet<Integer>> papers;
        SlotMachine slotMachine = new SlotMachine();
        Award award = new Award();

        coin = slotMachine.insertCoin();
        slotMachine.lottoCount();
        papers = slotMachine.getAllPapers();

        award.init();
        award.compute(papers);
        award.showResult();
        award.showYield(coin);
    }


}
