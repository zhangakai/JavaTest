package MemoryTest;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Contended;

import java.util.HashMap;

public class MemoryTest {
    public static void main(String[] args) {
        Student student = new Student(23, "ak");
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
        synchronized (student) {
            System.out.println(ClassLayout.parseInstance(student).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(student).toPrintable());

    }

    public static class Isolated {

        @Contended
        private int v1;

        @Contended
        private long v2;
    }
}
