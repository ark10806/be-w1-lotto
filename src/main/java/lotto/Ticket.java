package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {

    private final Set<Integer> numbers;

    public Ticket(Set<Integer> numbers){
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers(){
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
