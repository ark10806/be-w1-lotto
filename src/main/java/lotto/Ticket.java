package lotto;

import java.util.Set;

public class Ticket {

    private final Set<Integer> numbers;

    public Ticket(Set<Integer> numbers){
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers(){
        return this.numbers;
    }

}
