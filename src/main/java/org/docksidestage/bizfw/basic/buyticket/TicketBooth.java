/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author zaya
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // TODO zaya [なるほど]定義と状態をひとつにまとめたクラスにしたんだね by jflute (2019/10/02)
    private TicketInfo oneDayInfo = new TicketInfo(1, 7400, MAX_QUANTITY);
    private TicketInfo twoDayInfo = new TicketInfo(2, 13200, MAX_QUANTITY);
    private TicketInfo fourDayInfo = new TicketInfo(4, 22400, MAX_QUANTITY);
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public TicketBuyResult buyOneDayPassport(int money) {
        return buyPassport(oneDayInfo, money);
    }

    public TicketBuyResult buyTwoDayPassport(int money) {
        return buyPassport(twoDayInfo, money);
    }

    public TicketBuyResult buyFourDayPassport(int money) {
        return buyPassport(fourDayInfo, money);
    }

    private TicketBuyResult buyPassport(TicketInfo ticketInfo, int money) {
        check(ticketInfo, money);
        // TODO done zaya この辺は、TicketInfo自体に数量を減らすメソッドがあってもいいかもね(実装ポリシー次第だけど) by jflute (2019/10/02)
        ticketInfo.reduceQuantity();
        addSales(ticketInfo.getPrice());

        TicketBuyResult ticketBuyResult = new TicketBuyResult();
        // TODO done zaya "if (" のところ空白が空いてる？他のifでは空いてないので統一しよう by jflute (2019/10/02)
        if (ticketInfo.getDays() == 1) {
            ticketBuyResult.setTicket(new OneDayTicket(oneDayInfo.getPrice()));
        } else {
            ticketBuyResult.setTicket(new MultipleDaysTicket(ticketInfo));
        }
        int change = money - ticketInfo.getPrice();
        ticketBuyResult.setChange(change);
        return ticketBuyResult;
    }

    // TODO done zaya もうすでに money ではないので変数名を考えよう by jflute (2019/10/02)
    private void addSales(int price) {
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + price;
        } else {
            salesProceeds = price;
        }
    }

    // TODO done zaya ここも、メソッドの定義順序をもう少し呼び出しと直感的にしよう by jflute (2019/10/02)
    // 一箇所からしか呼び出されないようなprivateメソッドは、呼び出し順序と合わせた方が見やすい
    private void check(TicketInfo ticketInfo, int money) {
        if (ticketInfo.getQuantity() <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (money < ticketInfo.getPrice()) {
            throw new TicketShortMoneyException("Short money: " + money);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Integer getSalesProceeds() {
        return salesProceeds;
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // TODO done zaya getterは、タグコメント Accessor のところで宣言しよう by jflute (2019/10/02)
    public TicketInfo getOneDayInfo() {
        return oneDayInfo;
    }

    public TicketInfo getTwoDayInfo() {
        return twoDayInfo;
    }

    public TicketInfo getFourDayInfo() {
        return fourDayInfo;
    }
}
