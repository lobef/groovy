package languagespecification.closures

import org.junit.Test

class ClosureComposition {

    @Test
    void run() {
        def plus2 = { it + 2 };
        def times3 = { it * 3 };
        def times3plus2 = plus2 << times3;
        println times3plus2(3);
        assert times3plus2(3) == 11;
        println plus2(times3(3));
        assert times3plus2(3) == plus2(times3(3));
        def plus2times3 = times3 << plus2;
        println plus2times3(5);
        assert plus2times3(5) == 21;
        assert plus2times3(3) == times3(plus2(3));

        assert times3plus2(3)==(times3>>plus2)(3);
    }


}

class ClosureTrampoline {

    @Test
    void testTrampoline() {

        def factorial;
        factorial = {int n,def accu=1G->
            if(n<2) return accu;
            factorial.trampoline(n - 1, n * accu);
        }
        factorial = factorial.trampoline();
//        println factorial(1);
        println factorial(7);
    }
}
