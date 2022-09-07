package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceTest {

    @Test
    @DisplayName("수동 로또의 개수가 전체 로또 개수를 넘으면 에러가 발생해야 한다")
    void validate() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Service(5, 20));
    }

    @Test
    @DisplayName("수동 로또 입력 시 숫자가 1이상 45이하가 아니면 에러가 발생해야 한다")
    void validate2() {
        Service service = new Service(14, 3);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.addLottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 50)))
        );
    }

    @Test
    @DisplayName("수동 로또 입력 시 6개의 숫자를 입력하지 않으면 에러가 발생해야 한다")
    void validate3() {
        Service service = new Service(14, 3);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.addLottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))
                );
    }

}
