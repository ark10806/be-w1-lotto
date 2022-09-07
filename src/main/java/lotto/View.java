package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class View {
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

        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(sc.nextLine());

        System.out.println();
        return bonusNumber;
    }

    public void printStat(LinkedHashMap<Rank, Integer> winningCount, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Set<Rank> set = winningCount.keySet();
        Iterator<Rank> iter = set.iterator();
        while (iter.hasNext()) {
            Rank rank = ((Rank) iter.next());
            int count = winningCount.get(rank);
            if (rank == Rank.SECOND) {
                System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + rank.getWinningMoney() + "원)- " + count);
            } else {
                System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + count);
            }
        }

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
