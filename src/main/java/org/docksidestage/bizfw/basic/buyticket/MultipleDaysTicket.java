package org.docksidestage.bizfw.basic.buyticket;

// TODO zaya javadoc by jflute (2019/10/03)
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
    public MultipleDaysTicket(TicketInfo ticketInfo) {
        this.displayPrice = ticketInfo.getPrice();
        // done zaya こっちが Days なら、getDays() も Days にしたいかもね by jflute (2019/10/02)
        // TODO zaya (続き)その場合、getDays()だけじゃなく、TicketInfo内部の変数などもdaysにしよう by jflute (2019/10/03)
        this.numberOfDays = ticketInfo.getDays();
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

    public int getTicketDays() { return this.numberOfDays; }
}
