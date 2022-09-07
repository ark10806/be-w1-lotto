package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoTicketAutomaticMakerTest {
    @Test
    public void makeTest(){
        TicketAutomaticMaker ticketAutomaticMaker = new TicketAutomaticMaker();
        Set<LottoTicket> lottoTickets = ticketAutomaticMaker.make(3);

        for(LottoTicket lottoTicket : lottoTickets){
            assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
        }
    }
}