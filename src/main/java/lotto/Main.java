package lotto;

import java.util.*;

public class Main {

    public static final int UNIT_COST = 1000;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int money = inputNumber("구입금액을 입력해 주세요\n");

        InputChecker.naturalNumber(money);

        int ticketCount = money / UNIT_COST;

        int manualTicketCount = inputNumber("수동으로 구매할 로또 수를 입력해 주세요.");

        InputChecker.naturalNumber(manualTicketCount);
        InputChecker.validateTicketCount(manualTicketCount, ticketCount);

        Set<LottoTicket> manualLottoTickets = inputManualLottoTicket("수동으로 구매할 번호를 입력해 주세요.", manualTicketCount);

        TicketAutomaticMaker ticketAutomaticMaker = new TicketAutomaticMaker();

        var tickets = ticketAutomaticMaker.make(ticketCount - manualTicketCount);

        tickets.addAll(manualLottoTickets);
        for(LottoTicket lottoTicket : tickets){
            System.out.println(lottoTicket.toString());
        }

        InputChecker.checkTicketDuplication(tickets, ticketCount);

        Set<Integer> winningNumbers = new HashSet<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = scan.nextLine().split(",");

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input.trim()));
        }

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = scan.nextInt();

        WinningLottoTicket winningTicket = new WinningLottoTicket(winningNumbers, bonusNumber);

        LottoResult result = Lotto.runWithBonus(tickets, winningTicket ,ticketCount  * UNIT_COST);

        printStatistics(result);
    }

    private static Set<LottoTicket> inputManualLottoTicket(String prompt,  int manualTicketCount) {
        System.out.print(prompt);
        System.out.print(prompt);

        Set<LottoTicket> manualLottoTickets = new HashSet<>();

        for(int i = 0; i < manualTicketCount; i++) {
            manualLottoTickets.add(new LottoTicket(inputTicketNumberSet()));
        }

        return manualLottoTickets;
    }

    private static Set<Integer> inputTicketNumberSet() {
        Set<Integer> inputNumbers = new HashSet<>();
        String[] inputs = scan.nextLine().split(",");
        for(String input : inputs) {
            inputNumbers.add(Integer.parseInt(input.trim()));
        }
        return inputNumbers;
    }

    private static int inputNumber(String prompt) {
        System.out.print(prompt);

        int number = scan.nextInt();
        scan.nextLine();

        return number;
    }


    private static void printStatistics(LottoResult result){

        System.out.println("당첨 통계");
        System.out.println("------------------");

        for(Rank rank : Rank.values()){
            if(rank == Rank.MISS) continue;
            if(rank == Rank.SECOND){
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n",rank.getMatchCount(), rank.getReward(), result.getStatistics().get(rank));
                continue;
            }
            System.out.printf("%d개 일치 (%d원) - %d개\n",rank.getMatchCount(), rank.getReward(), result.getStatistics().get(rank));
        }

        System.out.printf("총 수익률 %.2f%%\n", EarningCalculator.getEarningRate(result));
    }
}