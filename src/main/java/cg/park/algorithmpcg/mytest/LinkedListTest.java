package cg.park.algorithmpcg.mytest;


class test10 {
    static String str;
}

public class LinkedListTest {
    static test10 test222;

    {
        test10.str = "aa";
    }
    LinkedListTest() {
        test10 test = new test10();
        test.str = "A";
    }

    public static void main(String[] args) {

    }

}
