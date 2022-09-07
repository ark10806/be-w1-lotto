package lotto;

import java.util.*;

public class Main {

    public static final int UNIT_COST = 1000;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("구입금액을 입력해 주세요\n");
        int money = scan.nextInt();
        scan.nextLine();
        if(money < 0) {
            throw new IllegalArgumentException("0이상의 숫자여야 한다.");
        }

        int ticketCount = money / UNIT_COST;

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualTicketCount = scan.nextInt();
        scan.nextLine();

        if(manualTicketCount < 0) {
            throw new IllegalArgumentException("0이상의 숫자여야 한다.");
        }

        if(manualTicketCount > ticketCount) {
            throw new IllegalArgumentException("금액 내의 범위를 입력해 주세요.");
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Set<LottoTicket> manualLottoTickets = new HashSet<>();

        for(int i = 0; i < manualTicketCount; i++) {
            Set<Integer> manualNumbers = new HashSet<>();

            String[] inputs = scan.nextLine().split(",");
            for(String input : inputs) {
                manualNumbers.add(Integer.parseInt(input.trim()));
            }

            if(manualNumbers.size() != 6) {
                throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
            }

            manualLottoTickets.add(new LottoTicket(manualNumbers));
        }

        if(manualLottoTickets.size() != manualTicketCount) {
            throw new IllegalArgumentException("중복된 로또 티켓은 발급할 수 없습니다.");
        }

        TicketAutomaticMaker ticketAutomaticMaker = new TicketAutomaticMaker();

        var tickets = ticketAutomaticMaker.make(ticketCount - manualTicketCount);

        tickets.addAll(manualLottoTickets);
        for(LottoTicket lottoTicket : tickets){
            System.out.println(lottoTicket.toString());
        }

        if(tickets.size() != ticketCount) {
            throw new IllegalArgumentException("로또 티켓은 중복될 수 없습니다.");
        }

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