package java_;


public class Test {
    public static void main(String[] args) {
        testperson p = new testperson("ajmed", "asdfasdf", "adsfasdf");
        Register r = new Register(p);
        r.sendData();
    }
}
