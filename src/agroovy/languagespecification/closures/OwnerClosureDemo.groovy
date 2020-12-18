package agroovy.languagespecification.closures

import org.junit.Test

class OwnerEnclosing {

    @Test
    void run() {
        def whatIsOwnerObject = { getOwner() }
        assert whatIsOwnerObject() == this;
        def whatIsOwner = { owner }
        assert whatIsOwner() == this;

    }

}

class OwnerEnclosedInnerClass {

    class Inner {
        Closure cl = { owner }
    }

    @Test
    void run() {
        def inner = new Inner();
        assert inner.cl() == inner;

    }
}

class OwnerNestedClosure {

    @Test
    void run() {
        def nestedClosures = {
            def cl = {
                owner
            };
            cl();
        }

        assert nestedClosures() == nestedClosures;

    }


}
