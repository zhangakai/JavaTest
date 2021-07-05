package SimpleTest;

public class Base {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println();
        }
    }


}
