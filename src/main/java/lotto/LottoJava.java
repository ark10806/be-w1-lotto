package lotto;

import java.lang.reflect.Array;
import java.util.*;

public class LottoJava {
    final int LOTTONUM = 6;
    final int LOTTOMAX = 45;
    final Random rand = new Random();
    private int coin, count;
    private String lastNumber;

    private ArrayList<HashSet<Integer>> papers = new ArrayList<>();

    public void insertCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        coin = sc.nextInt();
    }
    public void lottoCount() {
        count = coin / 1000;
        System.out.println("로또의 개수는 :" + count);
    }
    private HashSet getPaper() {
        HashSet<Integer> paper = new HashSet<>();
        while (paper.size() < LOTTONUM) {
            paper.add(rand.nextInt(LOTTOMAX) + 1);
        }
        return paper;
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

    public ArrayList<HashSet<Integer>> run() {
        insertCoin();
        lottoCount();
        return getAllPapers();
    }
}
