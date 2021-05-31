package com.jiangls.behavioralpattern.eventobjecteventlistener.eventlistener;

import com.jiangls.behavioralpattern.eventobjecteventlistener.eventobject.DoorEvent;
import com.jiangls.behavioralpattern.eventobjecteventlistener.eventsource.Door;

import java.util.EventListener;

/**
 * DoorName 监听器
 */
public class DoorNameListener implements EventListener {
    public void doorEvent(DoorEvent event) {
        Door door = (Door) event.getSource();
        System.out.println("monitor the door name: I got a new name,named \"" + door.getName() + "\"");
    }
}
