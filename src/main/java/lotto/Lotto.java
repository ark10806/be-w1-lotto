package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private ArrayList<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        ArrayList<Integer> totalNumbers = new ArrayList<>();
        for(int i=1; i<=45; i++) {
            totalNumbers.add(i);
        }

        Collections.shuffle(totalNumbers);
        for(int i=0; i<6; i++) {
            numbers.add(totalNumbers.get(i));
        }

    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
