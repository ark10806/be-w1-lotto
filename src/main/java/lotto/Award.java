package lotto;

import java.util.*;

public class Award extends LottoRule {
    private HashSet<Integer> winnerNumber = new HashSet<>();
    private int bonusNumber;
    private HashSet<Integer> intersection = new HashSet<>();
    private ArrayList<Integer> panel = new ArrayList<>(Collections.nCopies(LOTTONUM + 2, 0));
    private ScoreBoard scoreBoard;

    public void init() {
        try {
            setWinnerNumbers();
            setBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private void setWinnerNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        winnerNumber = lottoNumParser();
    }

    private void setBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        bonusNumber = sc.nextInt();
    }

    private Integer getMatchNum(HashSet<Integer> candidate) {
        intersection = new HashSet<>(winnerNumber);
        intersection.retainAll(candidate);

        if (intersection.size() == 5 && candidate.contains(bonusNumber))
            return LOTTONUM + 1;
        return intersection.size();
    }

    public void compute(ArrayList<HashSet<Integer>> candidates) {
        int matchNum;
        for (int i = 0; i < candidates.size(); i++) {
            matchNum = getMatchNum(candidates.get(i));
            panel.set(matchNum, panel.get(matchNum) + 1);
        }
    }

    public void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------------");
        System.out.printf("3개 일치 (%d원) - %d개\n", ScoreBoard.FOURTH.getWinningMoney(), panel.get(3));
        System.out.printf("4개 일치 (%d원)- %d개\n", ScoreBoard.THIRD.getWinningMoney(), panel.get(4));
        System.out.printf("5개 일치 (%d원)- %d개\n", ScoreBoard.SECOND.getWinningMoney(), panel.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원)- %d개\n", ScoreBoard.BONUS.getWinningMoney(), panel.get(LOTTONUM + 1));
        System.out.printf("6개 일치 (%d원)- %d개\n", ScoreBoard.FIRST.getWinningMoney(), panel.get(6));
//        System.out.printf("3개 일치 (5000원)- %d개\n", panel.get(3));
//        System.out.printf("4개 일치 (50000원)- %d개\n", panel.get(4));
//        System.out.printf("5개 일치 (1500000원)- %d개\n", panel.get(5));
//        System.out.printf("5개 일치, 보너스 볼 일치 (30000000원)- %d개\n", panel.get(LOTTONUM+1));
//        System.out.printf("6개 일치 (2000000000원)- %d개\n", panel.get(6));
    }

    public void showYield(int coin) {
        System.out.println(panel);
//        float income = panel.get(3) * 5000 + panel.get(4) * 50000 + panel.get(5) * 1500000
//                + panel.get(6) * 2000000000 + panel.get(LOTTONUM+1) * 30000000;
        float income = panel.get(scoreBoard.FIRST.getMatchNum()) * scoreBoard.FIRST.getWinningMoney()
                + panel.get(scoreBoard.BONUS.getMatchNum()) * scoreBoard.BONUS.getWinningMoney()
                + panel.get(scoreBoard.SECOND.getMatchNum()) * scoreBoard.SECOND.getWinningMoney()
                + panel.get(scoreBoard.THIRD.getMatchNum()) * scoreBoard.THIRD.getWinningMoney()
                + panel.get(scoreBoard.FOURTH.getMatchNum()) * scoreBoard.FOURTH.getWinningMoney();
        float yield = ((income - (float) coin) / (float) coin) * 100;
        System.out.printf("총 수익률은 %.2f%% 입니다.", yield);
    }
}
