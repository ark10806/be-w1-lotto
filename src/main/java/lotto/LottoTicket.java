package lotto;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
        numbers.forEach(number -> validateLottoNumber(number));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
    }

    protected void validateLottoNumber(Integer number) {
        if(number < 1 || 45 < number) {
            throw new IllegalArgumentException("로또 숫자는 1~45만 가능합니다.");
        }
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoTicket lottoTicket = (LottoTicket) o;

        return numbers != null ? numbers.equals(lottoTicket.numbers) : lottoTicket.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
