package com.jiangls.behavioralpattern.eventobjecteventlistener.eventsource;

import com.jiangls.behavioralpattern.eventobjecteventlistener.eventlistener.DoorNameListener;
import com.jiangls.behavioralpattern.eventobjecteventlistener.eventlistener.DoorStateListener;
import com.jiangls.behavioralpattern.eventobjecteventlistener.eventobject.DoorEvent;

/**
 * 属性name和status改变，被监听。
 * Door作为EventSource被监听，当name和status改变的时候需要触发Event，触发Event之后Listener就监听到了
 */
public class Door {
    private String state = "";
    private String name = "";
    private DoorStateListener stateListener;
    private DoorNameListener nameListener;

    public void setState(String newValue) {
        if (state != newValue) {
            state = newValue;
            if (stateListener != null){
                //触发Event，触发Event之后Listener就监听到了
                DoorEvent event = new DoorEvent(this, "state",newValue);
                stateListener.doorEvent(event);
            }
        }
    }

    public void setName(String newValue) {
        if (name != newValue) {
            name = newValue;
            if (nameListener != null){
                //触发Event，触发Event之后Listener就监听到了
                DoorEvent event = new DoorEvent(this,"name", newValue);
                nameListener.doorEvent(event);
            }
        }
    }

    public void setStateListener(DoorStateListener stateListener) {
        this.stateListener = stateListener;
    }

    public void setNameListener(DoorNameListener nameListener) {
        this.nameListener = nameListener;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
