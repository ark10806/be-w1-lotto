package lotto;

import java.util.*;

public class Award {
    private HashSet<Integer> winnerNumber = new HashSet<>();
    private HashSet<Integer> intersection = new HashSet<>();
    private ArrayList<Integer> panel = new ArrayList<>(Collections.nCopies(7, 0));

    public void setWinnerNumbers() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String lastNumber = sc.nextLine();
            for (String s : lastNumber.split(",")) {
                winnerNumber.add(Integer.parseInt(s));
            }
            if (winnerNumber.size() != 6) {
                throw new IllegalArgumentException("당첨번호를 중복되지 않는 6개 값으로 설정해주세요");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
            setWinnerNumbers();
        }
    }

    private Integer getMatchNum(HashSet<Integer> candidate) {
        intersection = new HashSet<>(winnerNumber);
        intersection.retainAll(candidate);
        return intersection.size();
    }

    public void compute(ArrayList<HashSet<Integer>> candidates) {
        for (int i=0; i<candidates.size(); i++) {
            Integer matchNum = getMatchNum(candidates.get(i));
            panel.set(matchNum, panel.get(matchNum)+1);
        }
    }

    public void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------------");
        System.out.printf("3개 일치 (5000원)- %d개\n", panel.get(3));
        System.out.printf("4개 일치 (50000원)- %d개\n", panel.get(4));
        System.out.printf("5개 일치 (1500000원)- %d개\n", panel.get(5));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", panel.get(6));
    }
}
