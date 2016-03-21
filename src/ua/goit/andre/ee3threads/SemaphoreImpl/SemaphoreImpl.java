package ua.goit.andre.ee3threads.SemaphoreImpl;

import ua.goit.andre.ee3threads.SemaporeInterface.Semaphore;


public class SemaphoreImpl implements Semaphore {
    private int threadCounter;

    public SemaphoreImpl(int threadCounter) {
        this.threadCounter = threadCounter;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        acquire (1);
    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (permits < 0) throw new IllegalArgumentException();
        if (threadCounter >= permits) {
            threadCounter-=permits;
        } else {
            this.wait ();
        }

    }

    @Override
    public synchronized void release() throws InterruptedException {
        release (1);
    }

    @Override
    public synchronized void release(int permits) {
        if (permits < 0) throw new IllegalArgumentException();
        while (permits > 0) {
            threadCounter++;
            if (threadCounter > 0) this.notify ();
            permits--;
        }
    }

    @Override
    public int getAvailablePermits() {
        return threadCounter;
    }
}
