package lotto;

import java.util.*;

public class SlotMachine extends LottoRule {
    private int coin, numPapers, numManual, numAuto;
    private ArrayList<HashSet<Integer>> papers = new ArrayList<>();

    public int getCoin() {
        return coin;
    }

    public ArrayList getPapers() {
        return papers;
    }

    public void purchase() {
        papers.clear();

        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        coin = sc.nextInt();
        numPapers = coin / 1000;

        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        numManual = sc.nextInt();
        numAuto = numPapers - numManual;
    }


    public void publish() {
        publishManualPaper(numManual);
        publishAutoPaper(numAuto);
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", numManual, numAuto);
    }

    private void publishAutoPaper(int numAuto) {
        Random rand = new Random();
        HashSet<Integer> paper = new HashSet<>();
        for (int i=0; i<numAuto; i++) {
            paper.clear();
            while (paper.size() < LOTTONUM) {
                paper.add(rand.nextInt(LOTTOMAX) + 1);
            }
            papers.add(paper);
        }
    }

    private void publishManualPaper(int numManual) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요");
        for (int i = 0; i < numManual; i++) {
            papers.add(lottoNumParser());
        }
    }

    public void showPapers() {
        for (HashSet<Integer> paper : papers) {
            System.out.println(paper);
        }
    }
}
