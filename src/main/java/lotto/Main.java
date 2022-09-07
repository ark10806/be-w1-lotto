package lotto;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Main {
    public static Controller controller = new Controller();

    public static void main(String[] args) {
//        controller.start();

        LinkedHashMap<Rank, Integer> winningCount = new LinkedHashMap<>();
        lhm.put(Rank.valueOf(3,false), 5);
        lhm.put(Rank.valueOf(4,false), 5);
        lhm.put(Rank.valueOf(5,false), 5);
        lhm.put(Rank.valueOf(5,true), 5);
        lhm.put(Rank.valueOf(6,false), 5);


        Set<Rank> set = lhm.keySet();
        Iterator<Rank> iter = set.iterator();
        while(iter.hasNext()) {
            Rank key = (Rank)iter.next();
            Integer value = lhm.get(key);
            System.out.println("key : < " + key.getCountOfMatch() + ", " + key.getWinningMoney() + ">, value : " + value);
        }
    }
}