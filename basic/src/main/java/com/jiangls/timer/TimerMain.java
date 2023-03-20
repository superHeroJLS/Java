package com.jiangls.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Jiangls
 * @date 2022/8/3
 */
public class TimerMain {
    public static void main(String[] args) {
        ActionListener listener = event -> {
            System.out.println("hello");
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(3, listener).start();
    }
}
