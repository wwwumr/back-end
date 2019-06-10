package com.client.mutithreads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.client.mutithreads.Container;

public class Repo {
        
    public static final int MAX_CAP = 5;
    private static BlockingQueue<String> repo = new LinkedBlockingDeque<String>(MAX_CAP);

    public static void add(String item) {
        if(repo.remainingCapacity()>0){
            repo.add(item);
        }
    }

    public static String take() {
        try{
            int count = 0;
            while(repo.size()==0 && count <10) {
                Thread.sleep(500);
                count++;
            }
        }catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        return repo.poll();
    }

    public static BlockingQueue<String> getRepo(){
        return repo;
    }

    public static int getRemainning() {
        return repo.remainingCapacity();
    }
}