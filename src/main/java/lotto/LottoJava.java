package lotto;


import java.util.Scanner;

public class LottoJava {
    private int coin;

    public void insertCoin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        coin = sc.nextInt();
    }
}
