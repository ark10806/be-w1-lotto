package lotto;

import java.util.*;

public class Award extends LottoRule {
    Scanner sc = new Scanner(System.in);
    private HashSet<Integer> winnerNumber = new HashSet<>();
    private int bonusNumber;
    private HashSet<Integer> intersection = new HashSet<>();
    private ArrayList<Integer> panel = new ArrayList<>(Collections.nCopies(LOTTONUM+2, 0));
    private ScoreBoard scoreBoard;

    public void init() {
        try {
            setWinnerNumbers();
            setBonusNumber();
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    private void setWinnerNumbers() {
        int num;
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastNumber = sc.nextLine();
        for (String s : lastNumber.split(", ")) {
            num = Integer.parseInt(s);
            if (num < 1 || num > LOTTOMAX) {
                throw new IllegalArgumentException(num + "은 적절한 값이 아닙니다. (1~45)");
            }
            winnerNumber.add(num);
        }
        if (winnerNumber.size() != LOTTONUM) {
            throw new IllegalArgumentException("당첨번호를 중복되지 않는 6개 값으로 설정해주세요");
        }
    }

    private void setBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = sc.nextInt();
    }

    private Integer getMatchNum(HashSet<Integer> candidate) {
        intersection = new HashSet<>(winnerNumber);
        intersection.retainAll(candidate);

        // 5개 + 보너스볼이면 -1을 반환
        if (intersection.size() == 5 && candidate.contains(bonusNumber))
            return LOTTONUM+1;
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
        System.out.printf("3개 일치 (5000원)- %d개\n", panel.get(3));
        System.out.printf("4개 일치 (50000원)- %d개\n", panel.get(4));
        System.out.printf("5개 일치 (1500000원)- %d개\n", panel.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30000000원)- %d개\n", panel.get(LOTTONUM+1));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", panel.get(6));
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
        float yield = ((income - (float)coin) / (float)coin) * 100;
        System.out.printf("총 수익률은 %.2f%% 입니다.", yield);
    }
}
