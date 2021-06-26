package ConcurrentTest;

import java.util.concurrent.atomic.AtomicInteger;

public class PrinterTest {

    public static void main(String[] args) throws InterruptedException {

    }

    public void testPrintRunable1(){
        Thread thread1 = new Thread(new Print1(1));
        Thread thread2 = new Thread(new Print1(2));
        Thread thread3 = new Thread(new Print1(0));
        thread1.start();
        thread2.start();
        thread3.start();
    }


    /**
     * @Description: AtomicInteger + CAS 实现 速度应该是最快的 因为无阻塞
     * @Param: GAP_SIZE-打印间隔 oder 线程顺序
     * @Author: ZAk
     */
    public static class Print1 implements Runnable {
        private static AtomicInteger atomicInteger = new AtomicInteger(1);
        private static final int GAP_SIZE = 3;
        private int oder;
        public Print1(int oder){
            this.oder=oder;
        }
        @Override
        public void run() {
            while (atomicInteger.get()<1000000){
                if(atomicInteger.get()%GAP_SIZE==oder){
                    System.out.println(Thread.currentThread().getName()
                            +": "+atomicInteger.get());
                    atomicInteger.getAndIncrement();
                }
            }
        }
    }



}

