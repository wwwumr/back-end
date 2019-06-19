package com.client.mutithreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

import com.client.mutithreads.MyConsumer;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Container container = new Container();
        Thread consumer1 = new Thread(new MyConsumer("Consumer1"), "Consumer1");
        Thread consumer2 = new Thread(new MyConsumer("Consumer2"), "Consumer2");
        Thread producer1 = new Thread(new MyProducer("producer1"), "Producer1");

        container.execute(producer1);
        container.execute(consumer1);
        container.execute(consumer2);
        container.execute(consumer2);
        container.execute(consumer2);
        container.shutdown();
    }
}
