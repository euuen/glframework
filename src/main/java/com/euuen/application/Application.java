package com.euuen.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Application {
    private ArrayList<Manager> managers;
    public Clock clock;
    public boolean isRunning = false;
    public boolean isInitialized = false;
    public CopyOnWriteArrayList<Runnable> tasks = new CopyOnWriteArrayList<>();
    public Runnable afterRun;
    public Application(){
        managers = new ArrayList<>();
        clock = new Clock();
        afterRun = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public Application(Manager ... managers){
        this.managers = new ArrayList<>();
        this.clock = new Clock();
        afterRun = new Runnable() {
            @Override
            public void run() {

            }
        };

        this.managers.addAll(Arrays.asList(managers));
    }

    public void initialize(){

    }

    public void after(Runnable afterRun){
        this.afterRun = afterRun;
    }

    public void start(){
        initialize();
        initializeManagers();
        afterRun.run();
        isInitialized = true;
        clock.start();
        isRunning = true;
        while (isRunning){
            update();
            updateManagers();
            clock.sleep();
        }
    }

    public void startAsync(){
        Thread thread = new Thread(this::start, "async application");
        thread.start();
    }

    public void waitForInit(){
        while (!isInitialized){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop(){
        cleanupManagers();
        clean();
        isRunning = false;
    }

    public void clean(){

    }

    public void setUpdateRate(float updateRate){
        this.clock.setSleepRate(updateRate);
    }

    public void addManager(Manager ... managers){
        this.managers.addAll(Arrays.asList(managers));
    }

    public void update(){
        for (Runnable task : tasks){
            task.run();
        }
        tasks.clear();
    }

    private void updateManagers(){
        for (Manager manager : managers){
            manager.update();
        }
    }

    private void initializeManagers(){
        for (Manager manager : managers){
            manager.initialize();
        }
    }

    public void cleanupManagers(){
        for (Manager manager: managers){
            manager.cleanup();
        }
    }

    public void execute(Runnable task){
        tasks.add(task);
    }
}




























