package lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final int Cost = 1000;
    public static final int bonusMagicNumber = 7;

    public static String getHello() {
        return "Hello";
    }
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();

        int inputCost = input.inputPrice();
        int lottoNum = inputCost/Cost;

        //수동으로 입력
        int manualLottoNum = input.inputLottoSize();

        //서비스 생성
        Service service = new Service(lottoNum, manualLottoNum);

        ArrayList<ArrayList<Integer>> lottoManualNumbers = input.inputLottoManualNumbers(manualLottoNum);

        output.printLottoPurchase(lottoNum, manualLottoNum);


//        ArrayList<ArrayList<Integer>> lottoNumbers = new ArrayList<>();

        for (int i=0; i<lottoNum - lottoManualNumbers.size(); i++){
            ArrayList<Integer> numbers = service.createLottoNumbers();
            service.addLottoNumbers(numbers);
        }

        for (int i=0; i<lottoManualNumbers.size(); i++){
            service.addLottoNumbers(lottoManualNumbers.get(i));
        }


        ArrayList<ArrayList<Integer>> lottoNumbers = service.getLottoManualNumbers();

        output.printLottoNumbers(lottoNumbers);

        ArrayList<Integer> winningNumber = input.inputLottoNumbers();

        ArrayList<Integer> count = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));

        int bonusNumber = input.inputBonusNumber();

        for (ArrayList<Integer> lottoNumber : lottoNumbers){
            int matchNum = service.countCorrectNumber(winningNumber,lottoNumber);
            if (checkBonusNumber(service, count, bonusNumber, lottoNumber, matchNum)) continue;
            count.set(matchNum, count.get(matchNum) + 1);
        }

        output.printResultString();

        for (int i = 3; i <= 7; i++){
            if(i == 6) output.printLottoResult(i + 1,count.get(i + 1));
            else if(i == 7) output.printLottoResult(i - 1,count.get(i - 1));
            else output.printLottoResult(i,count.get(i));
        }
        output.printProfitRate(inputCost,count);

    }

    private static boolean checkBonusNumber(Service service, ArrayList<Integer> count, int bonusNumber, ArrayList<Integer> lottoNumber, int matchNum) {
        if(matchNum == 5) {
            ArrayList<Integer> bonusNumbers = new ArrayList<>();
            bonusNumbers.add(bonusNumber);

            if(service.countCorrectNumber(bonusNumbers, lottoNumber) == 1) {
                count.set(bonusMagicNumber, count.get(bonusMagicNumber) + 1);
                return true;
            }
        }
        return false;
    }
}
