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
        var tickets = new HashSet<LottoTicket>();
        tickets.add(new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)));
        tickets.add(new LottoTicket(Set.of(8, 21, 23, 41, 42, 43)));
        tickets.add(new LottoTicket(Set.of(1, 3, 5, 14, 22, 45)));
        var winningTickets = new LottoTicket(Set.of(1, 2, 3, 4, 5, 6));

        var actual = Lotto.run(tickets, winningTickets, 3000);

        var expected = new LottoResult(expectedResultMap(), 3000);
        assertThat(actual).isEqualTo(expected);
    }

    private Map<Rank, Integer> expectedResultMap() {
        var expectedMap = new HashMap<Rank, Integer>();
        expectedMap.put(Rank.MISS, 1);
        expectedMap.put(Rank.FIFTH, 1);
        expectedMap.put(Rank.FOURTH, 0);
        expectedMap.put(Rank.THIRD, 0);
        expectedMap.put(Rank.SECOND, 0);
        expectedMap.put(Rank.FIRST, 1);

        return expectedMap;
    }
}
