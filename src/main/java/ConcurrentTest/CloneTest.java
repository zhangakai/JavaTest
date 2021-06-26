package ConcurrentTest;



import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class CloneTest {
    private int age;
    private String name;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class c = Random.class;
        Field f = c.getDeclaredField("seedUniquifier");
        f.setAccessible(true);
        AtomicLong atomicLong = (AtomicLong) f.get("seedUniquifier");
        System.out.println(atomicLong.get());
        Random r1 = new Random();
        System.out.println(atomicLong.get());
        Random r2 = new Random();
        System.out.println(atomicLong.get());
    }


}
