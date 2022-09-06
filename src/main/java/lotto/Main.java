package lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final int Cost = 1000;

    public static String getHello() {
        return "Hello";
    }
    public static void main(String[] args) {

        Input input = new Input();
        Service service = new Service();
        Output output = new Output();

        int inputCost = input.inputPrice();
        int lottoNum = inputCost/Cost;
        output.printLottoPurchase(lottoNum);

        ArrayList<ArrayList<Integer>> lottoNumbers = new ArrayList<>();

        for (int i=0; i<lottoNum; i++){
            lottoNumbers.add(service.createLottoNumbers());
        }

        ArrayList<Integer> winningNumber = input.inputLottoNumbers();

        ArrayList<Integer> count = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0));
        for (ArrayList<Integer> lottoNumber:lottoNumbers){
            int matchNum = service.countCorrectNumber(winningNumber,lottoNumber);
            count.set(matchNum,count.get(matchNum)+1);
        }

        output.printResultString();

        for (int i=3;i<7;i++){
            output.printLottoResult(i,count.get(i));
        }
        output.printProfitRate(inputCost,count);

    }
}
