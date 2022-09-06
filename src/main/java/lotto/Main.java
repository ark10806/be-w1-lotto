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

    public void printLottoNumber(int lottoNumber) {
        System.out.println(lottoNumber + "개를 구매했습니다.");
    }

    public void printLottos(ArrayList<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers().toString());
        }
        System.out.println();
    }

    public ArrayList<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String str = sc.nextLine();
        ArrayList<Integer> winningNumbers = new ArrayList<>();

        String[] strings = str.split(", ");
        int[] values = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        winningNumbers = (ArrayList<Integer>) Arrays.stream(values).boxed().collect(Collectors.toList());

        System.out.println();
        return winningNumbers;
    }

    public void printStat(ArrayList<Integer> winningCount, ArrayList<Integer> winnings, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + winnings.get(i - 3) + "원)- " + winningCount.get(i));
        }

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}

class Controller {
    private View view = new View();
    private int lottoNumber;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private ArrayList<Integer> winningNumbers;
    private ArrayList<Integer> winningCount;
    private double yield;
    ArrayList<Integer> winnings = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 2000000000));

    public void start() {
        lottoNumber = view.inputMoney() / 1000;
        view.printLottoNumber(lottoNumber);
        buy();
        view.printLottos(lottos);
        winningNumbers = view.inputWinningNumbers();
        calculateWinningCount();
        calculateYield();
        view.printStat(winningCount, winnings, yield);
    }

    public void calculateWinningCount() {
        winningCount = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            winningCount.add(0);
        }

        for (int i = 0; i < lottos.size(); i++) {
            int index = lottos.get(i).match(winningNumbers);
            winningCount.set(index, winningCount.get(index) + 1);
        }
    }

    public void calculateYield() {
        int totalWinnings = 0;
        for (int i = 3; i <= 6; i ++) {
            totalWinnings += winningCount.get(i) * winnings.get(i-3);
        }
        yield = ((totalWinnings-(lottoNumber*1000))/(lottoNumber*1000.0))*100;
    }

    public void buy() {
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(new Lotto());
        }
    }
}

public class Main {
    public static Controller controller = new Controller();

    public static void main(String[] args) {
        controller.start();
    }
}
