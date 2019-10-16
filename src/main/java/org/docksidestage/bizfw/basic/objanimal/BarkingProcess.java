package org.docksidestage.bizfw.basic.objanimal;

/**
 * @author zaya
 */
public class BarkingProcess {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private Animal animal;

    // ===================================================================================
    //                                                                               Bark
    //                                                                              ======
    public BarkingProcess(Animal animal) {
        this.animal = animal;
    }

    public BarkedSound bark() {
        animal.breatheIn();
        animal.prepareAbdominalMuscle();
        String barkWord = animal.getBarkWord();
        return doBark(barkWord);
    }

    protected BarkedSound doBark(String barkWord) {
        animal.downHitPoint();
        return new BarkedSound(barkWord);
    }


}
