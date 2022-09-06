package lotto;


import java.util.Scanner;

public class LottoJava {
    private int coin;
    private int count;

    public void insertCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        coin = sc.nextInt();
    }
    public void lottoCount() {
        count = coin / 1000;
        System.out.println("로또의 개수는 :" + count);
    }
}
