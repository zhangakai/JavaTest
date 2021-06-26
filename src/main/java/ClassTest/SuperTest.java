package ClassTest;

public class SuperTest {
    public static void main(String[] args) {
        Son son = new Son();
        son.f1();
    }

    public static class Father {
        public void f1(){
            System.out.println("f1");
        }
        public static void f2(){
            System.out.println("f2");
        }
    }

    public static class Son extends Father {
        public void f1(){
            super.f1();
            super.f2();
        }
        public void f3(){
            super.f1();
            super.f2();
        }
    }


}
