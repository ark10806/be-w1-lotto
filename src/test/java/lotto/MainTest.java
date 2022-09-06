package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        assertThat(Main.getHello()).isEqualTo("Hello");
    }

    @Test
    public void integrationTest(){
        final int money = 14000;
        final int unitCost = 1000;

        //TODO : write integration test
    }
}