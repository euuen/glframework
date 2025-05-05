package com.euuen.rapplication;

import java.util.HashMap;

public abstract class Application extends System{
    public static Application instance;
    public HashMap<String, System> systems = new HashMap<>();
    public HashMap<String, System> systemsToInit = new HashMap<>();

    public static Application getInstance() {
        return instance;
    }

    public Application(){
        instance = this;
    }

    public void start(){
        create();
    }

    public void stop(){
        destroy();
        for (System system : systems.values()){
            system.destroy();
        }

        systems = null;
        systemsToInit = null;
        java.lang.System.exit(0);
    }

    public void regSystem(System system){
        if (system.id == null) system.id = system.getClass().toString();
        systemsToInit.put(system.id, system);
    }

    public void initSystem(){
        for (System system : systemsToInit.values()){
            system.create();
            systems.put(system.id, system);
        }
        systemsToInit.clear();
    }

    public void addSystem(System system){
        if (system.id == null) system.id = system.getClass().toString();
        Thread thread = new Thread(system::create);
        thread.start();
        systems.put(system.id, system);
    }

    public System getSystem(String id){
        System res = systems.get(id);
        if (res != null) return res;
        return systemsToInit.get(id);
    }

    public void rmSystem(String id){
        systems.remove(id);
    }
}























