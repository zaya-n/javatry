package org.docksidestage.bizfw.basic.buyticket;

// TODO zaya 最低限のjavadocお願い by jflute (2019/10/02)
public class TicketInfo {
    // TODO zaya finalが付けられるものには付けてみよう。すると可読性良くなるかなと by jflute (2019/10/02)
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
