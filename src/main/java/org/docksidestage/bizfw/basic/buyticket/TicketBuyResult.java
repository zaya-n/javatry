package org.docksidestage.bizfw.basic.buyticket;

public class TicketBuyResult {
    private int change;
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }
}
