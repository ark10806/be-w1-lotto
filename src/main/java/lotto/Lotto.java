package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lotto {
    public static LottoResult run(Set<Ticket> tickets, Ticket winningTicket, int money) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        initMap(resultMap);

        for (var ticket : tickets) {
            var target = new HashSet<>(ticket.getNumbers());
            target.retainAll(winningTicket.getNumbers());

            resultMap.put(Rank.getRankOfResult(target.size(), false), resultMap.get(Rank.getRankOfResult(target.size(), false)) + 1);
        }

        return new LottoResult(resultMap, money);
    }

    private static void initMap(Map<Rank, Integer> resultMap) {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public static LottoResult runWithBonus(Set<Ticket> tickets, Ticket winningTicket, int bonusNumber, int money) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        initMap(resultMap);

        for (var ticket : tickets) {
            var target = new HashSet<>(ticket.getNumbers());
            target.retainAll(winningTicket.getNumbers());

            boolean bonus = ticket.getNumbers().contains(bonusNumber);
            resultMap.put(Rank.getRankOfResult(target.size(), bonus), resultMap.get(Rank.getRankOfResult(target.size(), bonus)) + 1);
        }

        return new LottoResult(resultMap, money);
    }
}
