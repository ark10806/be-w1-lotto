package lotto;

import java.io.BufferedReader;
import java.util.*;

public class Main {

    public static final int UNIT_COST = 1000;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("구입금액을 입력해 주세요\n");
        int money = scan.nextInt();
        scan.nextLine();

        int ticketCount = money / UNIT_COST;

        TicketAutomaticMaker ticketAutomaticMaker = new TicketAutomaticMaker();

        Set<Ticket> tickets = ticketAutomaticMaker.make(ticketCount);
        for(Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }

        Set<Integer> winningNumbers = new HashSet<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = scan.nextLine().split(",");

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input.trim()));
        }

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = scan.nextInt();

        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);

//        LottoResult result = Lotto.run(tickets, winningTicket, ticketCount  * UNIT_COST);
        LottoResult result = Lotto.runWithBonus(tickets, winningTicket ,ticketCount  * UNIT_COST);

        printStatistics(result);
    }

    public static void printStatistics(LottoResult result){

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