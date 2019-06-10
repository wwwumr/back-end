package com.client.mutithreads;

import com.client.mutithreads.Repo;

class MyProducer extends Thread {
    private String name;

    MyProducer(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Running "+this.name);
        try {
            for(int i=0; i<35; i++) {
                Repo.add("item"+i);
                System.out.println(name+" add item"+i);
                Thread.sleep(2000);
            }
        } catch(InterruptedException exception) {
            System.out.println("Thread "+this.name+" interruptted.");
        }
    }
}