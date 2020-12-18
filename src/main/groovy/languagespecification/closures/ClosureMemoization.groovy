package languagespecification.closures

import org.junit.Test

class ClosureMemoization {

    @Test
    void testNotMemoization(){
        def fib ;
        fib = {long n -> n<2?n:fib(n-1)+fib(n-2)};
        println fib(15);
        println fib(25);
    }

    @Test
    void testMemoization(){
        def fib;
        fib = {long n->n<2?n:fib(n-1)+fib(n-2)}.memoize();
        println fib(25);
    }

}
