package lotto;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
            winningNumbers.add(Integer.parseInt(input));
        }

        Ticket winningTicket = new Ticket(winningNumbers);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = scan.nextInt();

//        LottoResult result = Lotto.run(tickets, winningTicket, ticketCount  * UNIT_COST);
        LottoResult result = Lotto.runWithBonus(tickets, winningTicket, bonusNumber, ticketCount  * UNIT_COST);

        printStatistics(result);
    }

    public static void printStatistics(LottoResult result){
        EarningCalculator earningCalculator = new EarningCalculator();

        System.out.println("당첨 통계");
        System.out.println("------------------");
        for(int i = 3; i <= 6; i++){
            System.out.println(String.format("%d개 일치 (%d원) - %d개", i, earningCalculator.getPrizeTable().get(i), result.getStatistics().get(i)));
        }

        System.out.println(String.format("총 수익률 %.2f%%", earningCalculator.getEarningRate(result)));
    }
}