package lotto;

import java.util.Set;

public final class InputChecker {

    private InputChecker(){

    }

    public static void naturalNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("0이상의 숫자여야 한다.");
        }
    }

    public static void validateTicketCount(int manualTicketCount, int ticketCount){
        if(manualTicketCount > ticketCount) {
            throw new IllegalArgumentException("금액 내의 범위를 입력해 주세요.");
        }
    }

    public static void checkTicketDuplication(Set<LottoTicket> lottoTickets, int ticketCount){
        if(lottoTickets.size() != ticketCount) {
            throw new IllegalArgumentException("중복된 로또 티켓은 발급할 수 없습니다.");
        }
    }
}
