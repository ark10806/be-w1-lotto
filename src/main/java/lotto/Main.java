package lotto;

import lotto.LottoJava;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static String getHello() {
        return "Hello";
    }

    public static void main(String[] args) {
        LottoJava lotto = new LottoJava();

        int coin = lotto.insertCoin();

        lotto.lottoCount();
        ArrayList<HashSet<Integer>> papers = lotto.getAllPapers();

        Award award = new Award();
        award.setWinnerNumbers();
        award.compute(papers);
        award.showResult();
        award.showYield(coin);
    }


}
