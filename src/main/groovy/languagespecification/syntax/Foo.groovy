package languagespecification.syntax

import org.junit.Test

/**@
 * Some class groovydoc for Foo
 */
class Foo {

    /**@
     * Some method groovydoc for bar
     */
    void bar(){

    }

    @Test
    void run(){
        println Foo.class.groovydoc.content;
        println  Foo.class.getMethod("bar",new Class[0]).groovydoc.content;
    }

    @Test
    void testString(){

        assert "ab"=="a"+"b";
        println "\\ \b"

        println  "1 + 2 == ${ w -> w << 3}";

        def cal ={w -> w << 3};
        println cal(0);

    }
}
