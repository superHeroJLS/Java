package com.jiangls.serializable.constant;

/**
 * 业务数据域标准业务动作<br>
 */
public enum DomainStandardAction {

    READ("READ"), WRITE("WRITE"), DELETE("DELETE"), AUTHORIZE("AUTHORIZE"), ALLOW("ALLOW"), DENY("DENY"), UNKNOWN("UNKNOWN");

    private final String actionCode;

    DomainStandardAction(final String actionCode) {
        this.actionCode = actionCode;
    }

    @Override
    public String toString() {
        return actionCode;
    }
}
