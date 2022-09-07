package lotto;

import java.util.*;

public class Input {

    public int inputPrice() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public int inputLottoSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

//    public ArrayList<ArrayList<Integer>> inputBuyNumbers() {
//        System.out.println("");
//        Scanner scan = new Scanner(System.in);
//        return new ArrayList<ArrayList<Integer>>();
//    }

    public ArrayList<Integer> inputLottoNumbers(){
        System.out.println("");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine().replaceAll(" ","");
        String numbers[] = inputString.split(",");

        for (int i=0; i< numbers.length; i++){
            lottoNumbers.add(Integer.parseInt(numbers[i]));
        }

        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public ArrayList<ArrayList<Integer>> inputLottoManualNumbers(int manualLottoNum){
        System.out.println("");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        ArrayList<ArrayList<Integer>> lottoManualNumbers = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        for (int i=0; i< manualLottoNum; i++){
            ArrayList<Integer> lottoNumbers = new ArrayList<>();

            String inputString = scan.nextLine().replaceAll(" ","");
            String numbers[] = inputString.split(",");

            for (int j=0; j< numbers.length; j++){
                lottoNumbers.add(Integer.parseInt(numbers[j]));
            }

            lottoManualNumbers.add(lottoNumbers);
        }
        return lottoManualNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

}
