package agroovy.languagespecification.closures

import org.junit.Test

class ClosureGStrings {

    @Test
    void run() {
        // gstring
        def x = 1;
        def gs = "x=${x}"
        println gs;
        assert gs == "x=1";
//        x =2;
//        assert gs == "x=2";

        def gs1 = "x=${-> x}"
        assert gs1 == "x=1";
        println gs1;
        x = 2;
        println gs1;
        assert gs1 == "x=2";
    }

}

class GstringsPerson{
    String name;
    String toString(){
        name;
    }
}

class ClosureGstringsObject{

    @Test
    void run(){

        def sam = new GstringsPerson(name:"Sam");
        def lucy = new GstringsPerson(name:"Lucy");
        def p = sam;
        def gs = "Name:${p}";
        println  gs;
        assert gs =="Name:Sam";
        p = lucy;
        println gs;
        assert gs =="Name:Sam";
        sam.name="Lucy"
        println gs;
        assert gs == "Name:Lucy";
        sam.name="Sam"
        p = sam;
        def gs1 ="Name:${ -> p}";
        println gs1;
        assert gs1 =="Name:Sam";
        p = lucy;
        println gs1;
        assert gs1 =="Name:Lucy";
    }
}