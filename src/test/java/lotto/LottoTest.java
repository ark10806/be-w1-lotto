package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void run() {
        var tickets = new HashSet<Ticket>();
        tickets.add(new Ticket(Set.of(1, 2, 3, 4, 5, 6)));
        tickets.add(new Ticket(Set.of(8, 21, 23, 41, 42, 43)));
        tickets.add(new Ticket(Set.of(1, 3, 5, 14, 22, 45)));
        var winningTickets = new Ticket(Set.of(1, 2, 3, 4, 5, 6));

        var actual = Lotto.run(tickets, winningTickets, 3500);

        var expected = new LottoResult(expectedResultMap(), 3500);
        assertThat(actual).isEqualTo(expected);
    }


    private Map expectedResultMap() {
        var expectedMap = new HashMap<Integer, Integer>();
        expectedMap.put(0, 1);
        expectedMap.put(1, 0);
        expectedMap.put(2, 0);
        expectedMap.put(3, 1);
        expectedMap.put(4, 0);
        expectedMap.put(5, 0);
        expectedMap.put(6, 1);

        return expectedMap;
    }
}
