package com.euuen.application;

import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Controllable {
    public CopyOnWriteArrayList<Runnable> tasks = new CopyOnWriteArrayList<>();
    public ArrayList<Control> controls = new ArrayList<>();

    public void update(){
        for (Runnable task : tasks){
            task.run();
        }
        tasks.clear();
        for (Control control : controls){
            control.update();
        }
    }

    public void addControl(Control control){
        control.setControllable(this);
        control.initialize();
        execute(() -> controls.add(control));
    }

    public void execute(Runnable task){
        tasks.add(task);
    }
}















