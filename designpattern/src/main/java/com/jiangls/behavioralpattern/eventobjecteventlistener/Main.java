package com.jiangls.behavioralpattern.eventobjecteventlistener;

import com.jiangls.behavioralpattern.eventobjecteventlistener.eventlistener.DoorNameListener;
import com.jiangls.behavioralpattern.eventobjecteventlistener.eventlistener.DoorStateListener;
import com.jiangls.behavioralpattern.eventobjecteventlistener.eventsource.Door;

public class Main {
    public static void main(String[] args) {

        Door door = new Door();
        door.setStateListener(new DoorStateListener());
        door.setNameListener(new DoorNameListener());
        // 开门
        door.setState("open");
        System.out.println("我已经进来了");
        // 关门
        door.setState("close");
        // 改名
        door.setName("dengzy");
    }
}
