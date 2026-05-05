package Synchronization;

import java.util.Locale;
import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Counter counter;
    Lock lock;
    public Adder(Counter counter, Lock lock){
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
            synchronized (counter) {
                for (int i = 0; i < 10000; i++) {
                    //lock.lock();
                    this.counter.incValue(i);
                    //lock.unlock();
                }
            }
    }
}
