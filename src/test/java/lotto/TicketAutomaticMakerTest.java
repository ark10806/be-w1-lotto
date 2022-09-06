package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class TicketAutomaticMakerTest {
    @Test
    public void makeTest(){
        Set<Ticket> tickets = TicketAutomaticMaker.make(3);

        for(Ticket ticket : tickets){
            assertThat(ticket.getNumbers().size()).isEqualTo(6);
        }
    }
}