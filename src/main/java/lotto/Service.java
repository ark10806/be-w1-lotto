package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {

    private int totalLottoNum;
    private int manualLottoNum;

    private ArrayList<ArrayList<Integer>> lottoManualNumbers;

    public ArrayList<ArrayList<Integer>> getLottoManualNumbers() {
        return lottoManualNumbers;
    }

    public Service(int totalLottoNum, int manualLottoNum) {
        this.totalLottoNum = totalLottoNum;
        this.manualLottoNum = manualLottoNum;

        if (totalLottoNum < manualLottoNum) {
            throw new IllegalArgumentException("수동 로또의 개수가 최댓값을 초과하였습니다.");
        }
    }

    public void addLottoNumbers(ArrayList<Integer> lottoNumbers) {
        //validation
        for (Object lottoNumber : lottoNumbers) {
            if ((Integer) lottoNumber > 45 || (Integer) lottoNumber < 1) {
                throw new IllegalArgumentException("숫자는 1~45입니다.");
            }
        }

        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }

        List<Integer> collect = lottoNumbers.stream().map(it -> (Integer) it)
                .collect(Collectors.toList());

        lottoManualNumbers.add((ArrayList<Integer>) collect);
    }



    public ArrayList<Integer> createLottoNumbers() {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        while(i < 6){
            int ran = (int)(Math.random()*45+1);
            if(!result.contains(ran)){
                result.add(ran);
                i ++;
            }
        }

        Collections.sort(result);
//        System.out.println(result);
        return result;
    }


    public int countCorrectNumber(ArrayList<Integer> lottoNumbers, ArrayList<Integer> myNumbers){
        // Collections.sort(lottoNumbers);
        // Collections.sort(myNumbers);

        int correct = 0;
        for(int i = 0; i < lottoNumbers.size(); i++) {
            if (myNumbers.contains(lottoNumbers.get(i))) {
                correct ++;
            }
        }
        return correct;

    }

}
