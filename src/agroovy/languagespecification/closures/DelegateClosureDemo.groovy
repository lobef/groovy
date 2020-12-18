package agroovy.languagespecification.closures

import org.junit.Test

class DelegateEnclosing {

    @Test
    void run() {
        def cl = {
            getDelegate();
        }
        println cl();
        def cl2 = {
            delegate;
        }
        println cl2();
        assert cl() == cl2();
    }
}

class DelegateEnclosed {

    @Test
    void run() {
        def enclosed = {
            { -> delegate }.call();
            // 这两个是一样的
//            def t = { -> delegate };
//            t();
        }
        println enclosed();
        println enclosed;
        assert enclosed() == enclosed;
    }

}

class DelegatePerson {

    String name;

    int age;

    def fetchAge = { age }

    def pretty = {
        "My name is $name";
    }

    String toString() {
        pretty();
    }
}

class DelegateThing {
    String name;
}

class DelegateChange {

    @Test
    void run() {
        def p = new DelegatePerson(name: "Norman");
        def t = new DelegateThing(name: "Teapot");
        def upperCasedName = { delegate.name.toUpperCase() }
        upperCasedName.delegate = p;
        println upperCasedName();
        assert upperCasedName() == "NORMAN";
        upperCasedName.delegate = t;
        println upperCasedName();
        assert upperCasedName() == "TEAPOT";
        def target = p;
        def upperCasednameUsingVar = {
            target.name.toUpperCase();
        };
        println upperCasednameUsingVar();
        assert upperCasednameUsingVar() == "NORMAN";
    }
}

class DelegateStrategy {
    @Test
    void run() {

        def p = new DelegatePerson(name: "Igor");
        def cl = {
            name.toUpperCase();
        }
        cl.delegate = p;
        println cl();

    }

    @Test
    void testDelegateStrategy() {
        def p = new DelegatePerson(name: "Sarah");
        def t = new DelegateThing(name: "Teapot");
        println p;
        assert p.toString() == "My name is Sarah";
        p.pretty.delegate = t;
        println p;
        assert p.toString() == "My name is Sarah";
    }
}

class DelegateStrategy2 {

    @Test
    void run() {
        def p = new DelegatePerson(name: "Jessica", age: 42);
        def t = new DelegateThing(name: "Printer");
        def cl = p.fetchAge;
        cl.delegate = p;
        println cl();
        assert cl() == 42;
        cl.delegate = t;
        println cl();
        assert cl() == 42;
        cl.resolveStrategy = Closure.DELEGATE_ONLY;
        cl.delegate = p;
        println cl();
        assert cl() == 42;
        cl.delegate = t;
        try {
            println cl();
            assert false;
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
