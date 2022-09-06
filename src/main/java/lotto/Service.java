package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class Service {

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
        System.out.println(result);
        return result;
    }


    public int countCorrectNumber(ArrayList<Integer> lottoNumbers, ArrayList<Integer> myNumbers){
        Collections.sort(lottoNumbers);
        Collections.sort(myNumbers);

        int correct = 0;
        for(int i = 0; i < 6; i++) {
            if (myNumbers.contains(lottoNumbers.get(i))) {
                correct ++;
            }
        }
        return correct;

    }

}
