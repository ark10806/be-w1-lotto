package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class TicketAutomaticMakerTest {
    @Test
    public void makeTest(){
        TicketAutomaticMaker ticketAutomaticMaker = new TicketAutomaticMaker();
        Set<Ticket> tickets = ticketAutomaticMaker.make(3);

        for(Ticket ticket : tickets){
            assertThat(ticket.getNumbers().size()).isEqualTo(6);
        }
    }
}