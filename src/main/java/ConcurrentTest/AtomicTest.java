package ConcurrentTest;



import java.util.concurrent.*;

public class AtomicTest {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CopyOnWriteArrayList<Integer> cwa = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cwa.set(1, finalI);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        Thread.sleep(1000);

    }
}
