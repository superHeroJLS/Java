package com.jiangls.behavioralpattern.eventobjecteventlistener.eventobject;

import java.util.EventObject;

/**
 * 事件对象  DoorEvent
 */
public class DoorEvent extends EventObject {
    private static final long serialVersionUID = 6496098798146410884L;

    private final String key ;
    private final String value  ;

    public DoorEvent(Object source, String key , String value) {
        super(source);
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public String getKey() {
        return key;
    }
}
