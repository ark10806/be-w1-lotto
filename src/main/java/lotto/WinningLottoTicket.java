package lotto;

import java.util.Set;

public class WinningLottoTicket extends LottoTicket {
    private final int bonusNumber;

    public WinningLottoTicket(Set<Integer> numbers, int bonusNumber) {
        super(numbers);

        this.validateLottoNumber(bonusNumber);

        if(numbers.contains(bonusNumber)){
            throw new DuplicateLottoNumberException("숫자가 중복되었습니다.");
        }

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
