package lotto;

import java.util.*;
import java.util.stream.Collectors;

class View {
    Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(sc.nextLine());
        return money;
    }

    public ArrayList<Integer> inputWinningNumbers() {
        String str = sc.nextLine();
        ArrayList<Integer> winningNumbers = new ArrayList<>();

        String[] strings = str.split(", ");
        int[] values = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        winningNumbers = (ArrayList<Integer>) Arrays.stream(values).boxed().collect(Collectors.toList());

        return winningNumbers;
    }
}
class Controller {


    public void start() {

    }
}
public class Main {


    public static void main(String[] args) {

    }
}
