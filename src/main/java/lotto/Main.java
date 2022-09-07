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
        ArrayList<HashSet<Integer>> candidates = lotto.run();

        Award award = new Award();
        award.setWinnerNumbers();
        award.compute(candidates);
        award.showResult();
    }
}
