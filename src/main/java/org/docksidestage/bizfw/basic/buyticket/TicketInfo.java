package org.docksidestage.bizfw.basic.buyticket;

// TODO done zaya javadoc by jflute (2019/10/03)

/**
 * @author zaya
 */
public class TicketInfo {
    // done zaya finalが付けられるものには付けてみよう。すると可読性良くなるかなと by jflute (2019/10/02)
    private final int days;
    private final int price;
    private int quantity;

    public TicketInfo(int days, int price, int quantity) {
        this.days = days;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDays() {
        return days;
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
