package ClassTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ServiceImpl implements Service {

    @Override
    public void connectDB() {
        System.out.println("connectDB");
    }

    @Override
    public void dealRequest() {
        System.out.println("deal request");

    }
}
