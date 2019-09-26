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
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private int quantity2day = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public OneDayTicket buyOneDayPassport(int handedMoney) {
        check(handedMoney, ONE_DAY_PRICE);
        --quantity;
        addSales(handedMoney);
        return new OneDayTicket(ONE_DAY_PRICE);
    }

    public TicketBuyResult buyTwoDayPassport(int money) {
        check(money, TWO_DAY_PRICE);
        --quantity2day;
        addSales(TWO_DAY_PRICE);

        TicketBuyResult ticketBuyResult = new TicketBuyResult();
        ticketBuyResult.setTicket(new MultipleDaysTicket(TWO_DAY_PRICE, 2));
        int change = money - TWO_DAY_PRICE;
        ticketBuyResult.setChange(change);
        return ticketBuyResult;
    }

    private void addSales(int handedMoney) {
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + handedMoney;
        } else {
            salesProceeds = handedMoney;
        }
    }

    private void check(int money, int passportPrice) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (money < passportPrice) {
            throw new TicketShortMoneyException("Short money: " + money);
        }
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

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public int get2DayQuantity() {
        return quantity2day;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
