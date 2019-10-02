package org.docksidestage.bizfw.basic.buyticket;

public class TicketInfo {
    private int day;
    private int price;
    private int quantity;

    public TicketInfo(int day, int price, int quantity) {
        this.day = day;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDay() {
        return day;
    }

    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
