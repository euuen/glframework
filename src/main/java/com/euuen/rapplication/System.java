package com.euuen.rapplication;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class System {
    public String id;
    public boolean isRunning = false;
    public HashMap<String, Manager> managers = new HashMap<>();
    public HashMap<String, Manager> managersToInit =new HashMap<>();
    public boolean isInitialized = false;
    public CopyOnWriteArrayList<Runnable> tasks = new CopyOnWriteArrayList<>();

    public final void create(){
        initialize();
        isInitialized = true;
        loop();
    }

    public final void destroy(){
        execute(() -> {
            isRunning = false;
            for (Manager mgr : managers.values()){
                mgr.cleanup();
            }
            managers = null;
            managersToInit = null;
            tasks = null;
            cleanup();
        });
    }

    public final void pause(){
        onPause();
        execute(() -> isRunning = false);
    }

    public final void resume(){
        onResume();
        isRunning = true;
        loop();
    }

    public void onPause(){
        // to override
    }

    public void onResume(){
        // to override
    }

    public void initialize(){
        // to override
    }

    public final void loop(){
        isRunning = true;
        while (isRunning){
            for (Runnable task : tasks){
                task.run();
                if (!isRunning) break;
                tasks.remove(task);
            }
            if (!isRunning) break;
            update();
            for (Manager mgr : managers.values()){
                if (!isRunning) break;
                mgr.update();
            }
        }
    }

    public void update(){
        // to override
    }

    public void cleanup(){
        // to override
    }

    public void execute(Runnable task){
        tasks.add(task);
    }

    public void regManager(Manager manager){
        if (manager.id == null) manager.id = manager.getClass().toString();
        managersToInit.put(manager.id, manager);
    }

    public void initManagers(){
        for (Manager mgr : managersToInit.values()){
            mgr.initialize();
            managers.put(mgr.id, mgr);
        }
        managersToInit.clear();
    }

    public void addManager(Manager mgr){
        if (mgr.id == null){
            mgr.id = managers.getClass().toString();
        }
        mgr.initialize();
        managers.put(mgr.id, mgr);

    }

    public Manager getManager(String id){
        Manager res = managers.get(id);
        if (res != null) return res;
        return managersToInit.get(id);
    }

    public void rmManager(String id){
        managers.remove(id);
    }
}














