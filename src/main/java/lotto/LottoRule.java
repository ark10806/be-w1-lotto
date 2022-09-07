package lotto;

import java.util.HashSet;
import java.util.Scanner;

public class LottoRule {
    final int LOTTONUM = 6;
    final int LOTTOMAX = 45;
    protected Scanner sc = new Scanner(System.in);

    protected HashSet lottoNumParser() {
        int num;
        HashSet<Integer> numbers = new HashSet<>();

        String lastNumber = sc.nextLine();
        for (String s : lastNumber.split(", ")) {
            num = Integer.parseInt(s);
            if (num < 1 || num > LOTTOMAX) {
                throw new IllegalArgumentException(num + "은 적절한 값이 아닙니다. (1~45)");
            }
            numbers.add(num);
        }
        if (numbers.size() != LOTTONUM) {
            throw new IllegalArgumentException("중복되지 않는 6개 값으로 설정해주세요");
        }

        return numbers;
    }
}
