package org.docksidestage.javatry.basic.st6.os;

/**
 * @author zaya
 */
public class St6Linux extends St6OperationSystem {
    public St6Linux(String loginId) {
        super(loginId);
    }

    @Override
    protected String getFileSeparator() {
        return "/";
    }

    @Override
    protected String getUserDirectory() {
        return "/home/";
    }
}
