package agroovy.languagespecification.closures


import org.junit.Test

class ClosureDemo {

    @Test
    void testSyntax(){

        def demo1 = {++it}

        assert demo1(12) ==13;


    }

    @Test
    void testIt() {
        def greeting = { "Hello, $it!" }// it代表传进去的值
        println greeting("greeting");
        def greeting2 = { it -> "Hello, $it!" };
        println greeting2("greeting2");
        def print1 = { println it };
        print1.call("213");

    }

    @Test
    void testRefer() {
        def add = { int a, int b -> a + b };

        def add1 = { int a, int b = 3 -> a + b };

        def add2 = { a, b = 3 -> a + b };

        println add(1, 2);
        println add1(32);
        println add2(12, 34);

        println add.call(4, 6);
    }

    @Test
    void testObject() {
        def isTextFile = {
            File it -> it.name.endsWith(".txt");
        }

        println isTextFile instanceof Closure;

        println isTextFile(new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt"));
    }

    @Test
    void testClosureCall() {
        def code = { 123 };
        assert code() == 123;
        assert code.call() == 123;
        def isOdd = { int i -> i % 2 != 0 }
        assert isOdd(3) == true;
        assert isOdd.call(2) == false;
        def isEven = { it % 2 == 0 };
        assert isEven(2) == true;
    }

    @Test
    void testVarargs() {
        def concat1 = { String... args -> args.join(",") };
        println concat1("abc", "bcd", "qwe");
        def concat2 = { String[] args -> args.join("%") }
        println concat2("abc", "bcd", "qwe");

        def multiConcat = { int n, String... args -> args.join("") * n }
        println multiConcat(3, "abc", "bcd", "qwe");
    }


}
