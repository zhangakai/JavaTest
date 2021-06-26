package ConcurrentTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        blockingQueue.put("now");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
    }
}
