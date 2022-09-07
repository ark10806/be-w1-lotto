package lotto;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LottoJava {
    final int LOTTONUM = 6;
    final int LOTTOMAX = 45;
    final Random rand = new Random();
    private int coin, count;
    private String lastNumber;

    private ArrayList<ArrayList<Integer>> papers = new ArrayList<>();

    public void insertCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        coin = sc.nextInt();
    }
    public void lottoCount() {
        count = coin / 1000;
        System.out.println("로또의 개수는 :" + count);
    }
    private ArrayList getPaper() {
        ArrayList<Integer> paper = new ArrayList<>();
        for (int i = 0; i < LOTTONUM; i++) {
            paper.add(rand.nextInt(LOTTOMAX) + 1);
        }
        return paper;
    }
    public void getAllPapers() {
        papers.clear();
        for (int i = 0; i < count; i++) {
            papers.add(getPaper());
        }

        Iterator iter = papers.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    public String[] lastWinner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        lastNumber = sc.nextLine();
        String[] Number = lastNumber.split(",");
        return Number;
    }
    public void run() {
        insertCoin();
        lottoCount();
        getAllPapers();
        lastWinner();
    }
}
