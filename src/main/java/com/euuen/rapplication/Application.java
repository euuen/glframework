package com.euuen.rapplication;

import java.util.HashMap;

public abstract class Application {
    public HashMap<String, Manager> managers = new HashMap<>();
    public static Application instance;
    public boolean isInitialized = false;
    public boolean isRunning = false;

    public static Application getInstance() {
        return instance;
    }

    public Application(){
        instance = this;
    }

    public void initialize(){

    }

    public void update(){

    }

    public void cleanup(){

    }

    public void start(){
        initialize();
        isInitialized = true;
        loop();
    }

    public void loop(){
        isRunning = true;
        while (isRunning){
            update();
            for (Manager mgr : managers.values()){
                mgr.update();
                if (!isRunning) break;
            }
        }
    }

    public void pause(){
        isRunning = false;
    }

    public void stop(){
        for (Manager mgr : managers.values()){
            mgr.cleanup();
        }
        cleanup();
        System.exit(0);
    }

    public void addManager(Manager manager){
        if (manager.id == null) {
            manager.id = manager.getClass().toString();
        }
        managers.put(manager.id, manager);
        manager.initialize();
    }
}























