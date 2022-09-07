package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private ArrayList<Integer> numbers;

    public Lotto() {
        ArrayList<Integer> totalNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            totalNumbers.add(i);
        }

        Collections.shuffle(totalNumbers);
        numbers = new ArrayList<>(totalNumbers.subList(0, 6));
        Collections.sort(numbers);
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public int match(ArrayList<Integer> winningNumbers) {
        int lottoIndex, winningIndex;
        lottoIndex = winningIndex = 0;
        int matched = 0;

        while (lottoIndex < 6 && winningIndex < 6) {
            if (numbers.get(lottoIndex) == winningNumbers.get(winningIndex)) {
                matched++;
                lottoIndex++;
                winningIndex++;
                continue;
            }
            if (numbers.get(lottoIndex) < winningNumbers.get(winningIndex)) {
                lottoIndex++;
                continue;
            }
            if (numbers.get(lottoIndex) > winningNumbers.get(winningIndex)) {
                winningIndex++;
            }
        }

        return matched;
    }

    public boolean bonusMatch(int bonusNumber) {
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) == bonusNumber)
                return true;
        }
        return false;
    }
}
