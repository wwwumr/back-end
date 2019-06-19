package com.client.mutithreads;

import com.client.mutithreads.Repo;

class MyConsumer implements Runnable {
    private String name;

    MyConsumer(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Running "+this.name);
        try {
            for(int i=0; i<10; i++) {
                String item = Repo.take();
                System.out.println(name+" take "+item);
                Thread.sleep(1000);
            }
        } catch(InterruptedException exception) {
            System.out.println("Thread "+this.name+" interruptted.");
        }
    }
}