package lotto;

import lotto.exception.*;

import java.util.*;
import java.util.stream.Collectors;

public class View {
    Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    public int inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int money = Integer.parseInt(sc.nextLine());
                if (money < 0) {
                    throw new InvalidInputException("0보다 작은 값이 입력되었습니다.");
                }
                if (money < 1000) {
                    throw new InvalidInputException("1000원 이상을 입력해 주세요.");
                }
                return money;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값이 입력되었습니다.");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputManualLottoCount(int lottoCount) {
        while (true) {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            try {
                int manualLottoCount = Integer.parseInt(sc.nextLine());
                if (manualLottoCount < 0) {
                    throw new InvalidInputException("0보다 작은 값이 입력되었습니다.");
                }
                if (manualLottoCount > lottoCount) {
                    throw new InvalidInputException("구매할 수 없는 수량입니다.");
                }
                return manualLottoCount;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값이 입력되었습니다.");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printLottoCount(int lottoCount, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + (lottoCount - manualLottoCount) + "개를 구매했습니다.");
    }

    public ArrayList<ArrayList<Integer>> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        ArrayList<ArrayList<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            while (true) {
                try {
                    lottoNumbers.add(inputNumbers());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자가 아닌 값이 입력되었습니다.");
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return lottoNumbers;
    }

    public void printLottoNumbers(ArrayList<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers().toString());
        }
        System.out.println();
    }

    public ArrayList<Integer> inputNumbers() {
        String str = sc.nextLine();

        String[] strings = str.split(",");
        int[] values = Arrays.stream(strings).map(String::trim).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> winningNumbers = (ArrayList<Integer>) Arrays.stream(values).boxed().collect(Collectors.toList());

        winningNumbers.forEach(value -> {
            if (value <= 0 || value > 45) {
                throw new InvalidInputException("1부터 45 이내의 값만 입력할 수 있습니다.");
            }
        });

        if (winningNumbers.size() != 6) {
            throw new InvalidInputException("6개의 번호를 입력해 주세요.");
        }

        Set<Integer> winningSet = new HashSet<>(winningNumbers);
        if (winningSet.size() != 6) {
            throw new InvalidInputException("중복되지 않는 번호를 입력해 주세요.");
        }

        return winningNumbers;
    }

    public ArrayList<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            try {
                return inputNumbers();
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값이 입력되었습니다.");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public int inputBonusNumber(ArrayList<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 볼을 입력해 주세요.");
            try {
                int bonusNumber = Integer.parseInt(sc.nextLine());
                if (bonusNumber <= 0 || bonusNumber > 45) {
                    throw new InvalidInputException("1부터 45 이내의 값만 입력할 수 있습니다.");
                }

                winningNumbers.forEach(value -> {
                    if (value == bonusNumber) throw new InvalidInputException("중복되지 않는 번호를 입력해 주세요.");
                });

                System.out.println();
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값이 입력되었습니다.");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
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
