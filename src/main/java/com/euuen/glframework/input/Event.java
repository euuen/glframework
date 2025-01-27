package com.euuen.glframework.input;

import java.util.ArrayList;

public class Event {
    public int key;
    public int action;
    public Event(KeyTrigger keyTriggers){
        this.key = keyTriggers.key;
    }

    public boolean trigger(int key, int action){
        if (this.key == key){
            this.action = action;
            return true;
        }else {
            return false;
        }
    }
}
