package CCKS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class GsonToText {
    private static final String JSON_FILE_PATH = "";

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i : list) {

            System.out.println(i);
        }
    }


}
