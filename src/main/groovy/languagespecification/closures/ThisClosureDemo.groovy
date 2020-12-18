package languagespecification.closures

import org.junit.Test


class ThisEnclosing {
    @Test
    void run() {
        def whatIsThisObject = { getThisObject() };
        assert whatIsThisObject() == this;
        def whatIsThis = { this };
        assert whatIsThis() == this;
    }
}

class ThisEnclosingInInnerClass {

    class Inner {
        Closure cl = { this };
    }

    @Test
    void run() {
        def inner = new Inner();
        assert inner.cl() == inner;
    }
}


class ThisNestedClosures {
    @Test
    void run() {

        def nestedClosures = {
            def cl = { this };
            cl();// 相当于return cl();
        }

        println nestedClosures();

        assert nestedClosures() == this;
    }
}


class Person {

    String name;
    int age;

    String toString() {
        "$name is $age years old"
    }

    String dump() {
        def cl = {
            String msg = this.toString();
            println msg;
            msg;
        }
        cl();
    }

    @Test
    void run() {
        def p = new Person(name: "Janice", age: 74);
        assert p.dump() == "Janice is 74 years old";
    }

}
