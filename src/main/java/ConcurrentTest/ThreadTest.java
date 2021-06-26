package ConcurrentTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        /*ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                try {
                    System.out.println("before wait");
                    condition.await();
                    System.out.println("after wait");

                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);
        lock.lock();
        try {
            System.out.println("20");
            Thread.sleep(1000);
            condition.signal();
        }finally {
            lock.unlock();
        }
*/
        Object o = new Object();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o) {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            i++;
        }
    }
}


