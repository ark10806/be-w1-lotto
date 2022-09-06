package lotto;

import java.util.*;

public class TicketAutomaticMaker {
    private final List<Integer> numbers = new ArrayList<>();

    public TicketAutomaticMaker() {
        for (int i = 1; i <= 45; i++){
            numbers.add(i);
        }
    }

    public Set<Ticket> make(int ticketCount){

        Set<Ticket> tickets = new HashSet<>();

        for (int i = 0 ; i < ticketCount; i++){
            tickets.add(new Ticket(getRandomNumbers()));
        }

        return tickets;
    }

    private Set<Integer> getRandomNumbers() {
        Collections.shuffle(numbers);

        Set<Integer> randomNumbers = new HashSet<>();
        for (int j = 0;j < 6; j++){
            randomNumbers.add(numbers.get(j));
        }
        return randomNumbers;
    }
}
