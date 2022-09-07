package lotto;
public class Main {

    public static void main(String[] args) {
        SlotMachine slotMachine = new SlotMachine();
        Award award = new Award();

        slotMachine.purchase();
        slotMachine.publish();
        slotMachine.showPapers();

        award.init();
        award.compute(slotMachine.getPapers());
        award.showResult();
        award.showYield(slotMachine.getCoin());
    }


}
