package org.docksidestage.bizfw.basic.buyticket;

public class MultipleDaysTicket implements Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int displayPrice;
    private int numberOfDays;
    private int enteredDays;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public MultipleDaysTicket(int displayPrice, int days) {
        this.displayPrice = displayPrice;
        this.numberOfDays = days;
        this.enteredDays = 0;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (enteredDays >= numberOfDays) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        enteredDays++;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getEnteredDays() {
        return enteredDays;
    }

    public boolean isTwoDayTicket() {
        return numberOfDays==2;
    }

    public boolean isOneDayTicket() {
        return false;
    }
}
