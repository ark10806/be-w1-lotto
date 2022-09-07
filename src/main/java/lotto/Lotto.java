package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lotto {
    public static LottoResult run(Set<LottoTicket> lottoTickets, LottoTicket winningLottoTicket, int money) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        initMap(resultMap);

        for (var ticket : lottoTickets) {
            var target = new HashSet<>(ticket.getNumbers());
            target.retainAll(winningLottoTicket.getNumbers());

            resultMap.put(Rank.getRankOfResult(target.size(), false), resultMap.get(Rank.getRankOfResult(target.size(), false)) + 1);
        }

        return new LottoResult(resultMap, money);
    }

    private static void initMap(Map<Rank, Integer> resultMap) {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public static LottoResult runWithBonus(Set<LottoTicket> lottoTickets, WinningLottoTicket winningTicket, int money) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        initMap(resultMap);

        for (var ticket : lottoTickets) {
            var target = new HashSet<>(ticket.getNumbers());
            target.retainAll(winningTicket.getNumbers());

            boolean bonus = ticket.getNumbers().contains(winningTicket.getBonusNumber());
            resultMap.put(Rank.getRankOfResult(target.size(), bonus), resultMap.get(Rank.getRankOfResult(target.size(), bonus)) + 1);
        }

        return new LottoResult(resultMap, money);
    }
}
