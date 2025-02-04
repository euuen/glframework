package com.euuen.application;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Manager {
    public CopyOnWriteArrayList<Runnable> tasks = new CopyOnWriteArrayList<>();
    public ArrayList<Controllable> controllables = new ArrayList<>();
    public void initialize(){

    }

    public void update(){
        for (Runnable task : tasks){
            task.run();
        }
        tasks.clear();
        for (Controllable controllable : controllables){
            controllable.update();
        }
    }

    public void cleanup(){

    }

    public void execute(Runnable task){
        tasks.add(task);
    }

    public void addControllable(Controllable controllable){
        execute(() -> controllables.add(controllable));
    }
}









