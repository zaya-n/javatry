package org.docksidestage.bizfw.basic.buyticket;

public class TicketInfo {
    // TODO done zaya finalが付けられるものには付けてみよう。すると可読性良くなるかなと by jflute (2019/10/02)
    private final int day;
    private final int price;
    private int quantity;

    public TicketInfo(int day, int price, int quantity) {
        this.day = day;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDays() {
        return day;
    }

    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity() {
        this.quantity--;
    }
}
