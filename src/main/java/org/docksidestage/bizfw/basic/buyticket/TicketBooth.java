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
    private TicketInfo oneDayInfo = new TicketInfo(1, 7400, MAX_QUANTITY);
    private TicketInfo twoDayInfo = new TicketInfo(2, 13200, MAX_QUANTITY);
    private TicketInfo fourDayInfo = new TicketInfo(4, 22400, MAX_QUANTITY);
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    public TicketInfo getOneDayInfo() {
        return oneDayInfo;
    }

    public TicketInfo getTwoDayInfo() {
        return twoDayInfo;
    }

    public TicketInfo getFourDayInfo() {
        return fourDayInfo;
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public TicketBuyResult buyOneDayPassport(int money) {
        return buyPassport(money, oneDayInfo);
    }

    public TicketBuyResult buyTwoDayPassport(int money) {
        return buyPassport(money, twoDayInfo);
    }

    public TicketBuyResult buyFourDayPassport(int money) {
        return buyPassport(money, fourDayInfo);
    }

    private TicketBuyResult buyPassport(int money, TicketInfo ticketInfo) {
        check(money, ticketInfo);
        ticketInfo.setQuantity(ticketInfo.getQuantity() - 1);
        addSales(ticketInfo.getPrice());

        TicketBuyResult ticketBuyResult = new TicketBuyResult();
        if ( ticketInfo.getDay() == 1) {
            ticketBuyResult.setTicket(new OneDayTicket(oneDayInfo.getPrice()));
        } else {
            ticketBuyResult.setTicket(new MultipleDaysTicket(ticketInfo));
        }
        int change = money - ticketInfo.getPrice();
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

    private void check(int money, TicketInfo ticketInfo) {
        if (ticketInfo.getQuantity() <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (money < ticketInfo.getPrice()) {
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
    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
