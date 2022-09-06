package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lotto {
    public static LottoResult run(Set<Ticket> tickets, Ticket winningTicket, int money) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        initMap(resultMap);

        for (var ticket : tickets) {
            var target = new HashSet<>(ticket.getNumbers());
            target.retainAll(winningTicket.getNumbers());
            resultMap.put(target.size(), resultMap.get(target.size()) + 1);
        }

        return new LottoResult(resultMap, money);
    }

    private static void initMap(Map<Integer, Integer> resultMap) {
        for (int i = 0; i <= 6; i++) {
            resultMap.put(i, 0);
        }
    }
}
