package lotto;

import java.util.*;

public class SlotMachine extends LottoRule {
    Scanner sc = new Scanner(System.in);
    final Random rand = new Random();
    private int coin, count, notAuto, autoCount;
    private String lastNumber;


    private ArrayList<HashSet<Integer>> papers = new ArrayList<>();

    public Integer insertCoin() {
        System.out.println("구입금액을 입력해 주세요.");
        coin = sc.nextInt();
        return coin;
    }

    public Integer checkNotAuto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        notAuto = sc.nextInt();
        return notAuto;
    }

    //수동으로 3장, 자동으로 11개를 구매했습니다.
    public void lottoCount() {
        count = coin / 1000;
        autoCount = count - notAuto;
        System.out.println("로또의 개수는 :" + count);
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", notAuto, autoCount);
    }

    public String notAutoWrite() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String notAutoNumber = sc.nextLine();
        return notAutoNumber;
    }


    private HashSet getPaper() {
        HashSet<Integer> paper = new HashSet<>();
        while (paper.size() < LOTTONUM) {
            paper.add(rand.nextInt(LOTTOMAX) + 1);
        }
        return paper;
    }

    //Allpapers를 notAutoPapers와(수동) AllPapers(수동+자동)로 분리
    public ArrayList<HashSet<Integer>> getNotAutoPapers(String notAutoNumber) {
        HashSet<Integer> notAutoPapers 

    }
    public ArrayList<HashSet<Integer>> getAllPapers() {
        papers.clear();
        for (int i = 0; i < count; i++) {
            papers.add(getPaper());
        }

        Iterator iter = papers.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        return papers;
    }


}
