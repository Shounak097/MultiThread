package Synchronization;

import java.util.concurrent.locks.Lock;

/**
 * 1. synchronized() is block level which hold lock depending upon obj. if this is paased the all the sync methods in the same obj will get block
 * 2. If Counter obj is passed inside synchronized() then all the synchronized method inside the Counter will get blocked
 * 3. Synchronized method act as Synchronized(this) for instance method
 * 4. for static method, synchronized method will work in class level blocking only static method across objects
 * 5. private final Object lock = new Object() can we passed for better synchronization in sychronization()
 */
public class Subtractor implements Runnable {
    Counter counter;
    Lock lock;

    public Subtractor(Counter counter, Lock lock){
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i < 10000; i++) {
                this.counter.incValue(-i);
            }
        }
    }

    public synchronized void start(){
        System.out.println("t");
    }
}
