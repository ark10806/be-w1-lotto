package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoManualGenerator implements LottoGenerator {
    @Override
    public Lotto generate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> lottoString = Arrays.asList(br.readLine().split(", "));
        List<Integer> lotto = new ArrayList<>();
        for (String s : lottoString) lotto.add(Integer.parseInt(s));

        return new Lotto(lotto);
    }
}
