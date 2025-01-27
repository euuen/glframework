package com.euuen.application;

import java.util.Calendar;

public class Clock {
    long lastStartedTime;       // 以毫秒为单位
    float sleepRate = 60;            // 其实是刷新频率，用Clock可以帮你休眠正确的时间

    public Clock(){
        lastStartedTime = Calendar.getInstance().getTimeInMillis();
    }

    public long now(){
        return Calendar.getInstance().getTimeInMillis();
    }

    public long last(){
        return lastStartedTime;
    }

    public long optimal(){      // 返回总共需要休眠多长的时间
        return (long) (1000/sleepRate);
    }

    public void start(){
        lastStartedTime = now();
    }

    public void restart(){
        lastStartedTime = Calendar.getInstance().getTimeInMillis();
    }

    public long getDuration(){
        return now() - lastStartedTime;
    }

    public void setSleepRate(float sleepRate){
        this.sleepRate = sleepRate;
    }

    // 记得要先start之后才能拿用这个方法
    public void sleep(){
        long duration = getDuration();
        long optimal = optimal();
        long needSleepTime = optimal - duration;
        if (needSleepTime > 0){
            try {
                Thread.sleep(needSleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        restart();
    }
}






















