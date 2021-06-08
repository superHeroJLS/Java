package com.jiangls.serializable.constant;

/**
 * 业务动作授权类型<br>
 * ALLOW:允许<br>
 * REJECT:不允许<br>
 * NONE:空白<br>
 */
public enum DomainActionAuthorize {

    ENABLE("E"), DISABLE("d"), NONE("n");

    private final String actionValue;

    DomainActionAuthorize(final String actionValue) {
        this.actionValue = actionValue;
    }

    @Override
    public String toString() {
        return actionValue;
    }

}
