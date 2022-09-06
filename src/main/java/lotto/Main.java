package lotto;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static final int UNIT_COST = 1000;

    public static void main(String[] args) {
        // 1. money -> 14000원

        // 2. money -> 해당하는 티켓 갯수를 구해야한다. => ticketCnt

        // 3. TicketAutomaticMaker는 객체 -> ticket 갯수 받아서 ticket 리스트를 반환

        // LottoInput <- Ticket리스트, 당첨 번호, money, 단가

        // 4. LottoResult result = Lotto.run(LottoInput)

        /*
            인풋 : 구입금액, 로또단가, (로또번호), 당첨번호

            인풋클래스 : 구입금액, 로또단가, 로또(번호)

            헬퍼클래스 : 로또번호 생성기

            결과클래스 : LottoResult
         */

        Scanner scan = new Scanner(System.in);

        System.out.print("구입금액을 입력해 주세요\n");
        int money = scan.nextInt();

        int ticketCount = money / UNIT_COST;

        TicketAutomaticMaker ticketAutomaticMaker = new TicketAutomaticMaker();

        Set<Ticket> tickets = ticketAutomaticMaker.make(ticketCount);

        Set<Integer> winningNumbers = new HashSet<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = scan.nextLine().split(",");

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        Ticket winningTicket = new Ticket(winningNumbers);

        LottoResult result = Lotto.run(tickets, winningTicket, money);
    }
}
