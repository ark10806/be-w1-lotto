package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTicketTest {
    @Test
    public void duplicateNumberTest(){
        assertThatThrownBy(()->new WinningLottoTicket(Set.of(1,2,3,4,5,6), 1))
                .isInstanceOf(DuplicateLottoNumberException.class)
                .hasMessage("숫자가 중복되었습니다.");
    }
}