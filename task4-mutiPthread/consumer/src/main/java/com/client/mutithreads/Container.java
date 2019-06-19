package com.client.mutithreads;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Container {
    private ExecutorService pool;
    private static BlockingQueue threadQue = new LinkedBlockingDeque<Runnable>(Repo.MAX_CAP);

    Container() {
        pool = new ThreadPoolExecutor(3,3,0l,TimeUnit.MICROSECONDS,threadQue);
    }

    public static void setBlocking(BlockingQueue bQueue) {
        threadQue = bQueue;
    }
    
    public static BlockingQueue getBlocking() {
        return threadQue;
    }

    public void execute(Runnable command) {
        pool.execute(command);
        if(threadQue.remainingCapacity()==0) {
            threadQue.clear();
        }
    }   
    
    public void shutdown() {
        pool.shutdown();
    }
}