package com.jiangls.behavioralpattern.eventobjecteventlistener.eventlistener;

import com.jiangls.behavioralpattern.eventobjecteventlistener.eventobject.DoorEvent;

import java.util.EventListener;

/**
 * DoorState 监听器
 */
public class DoorStateListener implements EventListener {
    public void doorEvent(DoorEvent event) {
        if (event.getValue() != null && event.getValue().equals("open")) {
            System.out.println("监听门状态：门1打开");
        } else {
            System.out.println("监听门状态：门1关闭");
        }
    }
}
