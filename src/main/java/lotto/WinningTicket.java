package lotto;

import java.util.Set;

public class WinningTicket extends Ticket {
    private final int bonusNumber;

    public WinningTicket(Set<Integer> numbers, int bonusNumber) {
        super(numbers);

        if(numbers.contains(bonusNumber)){
            throw new DuplicateLottoNumberException("숫자가 중복되었습니다.");
        }

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
