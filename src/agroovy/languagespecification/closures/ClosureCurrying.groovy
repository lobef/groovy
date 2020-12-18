package agroovy.languagespecification.closures

import org.junit.Test

class ClosureCurrying {

    @Test
    void runLeftCurrying() {
        def nCopies = { int n, String str -> str * n };
//        def twice = nCopies.curry(2,"bla");
        def twice = nCopies.curry(2);
        println twice("bla");
        assert twice("bla") == "blabla";
    }

    @Test
    void runRightCurrying() {
        def nCopies = { int n, String str -> str * n };
        def blah = nCopies.rcurry("bla");
        println blah(2);
        println nCopies(2, "bla");
        assert blah(2) == "blabla";
    }

    @Test
    void runIndexCurrying() {

        def volume = { double l, double w, double h -> l * w * h };
        def fixedWidthVolume = volume.ncurry(1, 2d);
        println fixedWidthVolume(3d, 4d);
        println volume(3d, 2d, 4d);
        assert fixedWidthVolume(3d, 4d) == volume(3d, 2d, 4d);
        def fixedWidthAndHeight = volume.ncurry(1, 2d, 4d);
        println fixedWidthAndHeight(3d);
        assert fixedWidthAndHeight(3d) == volume(3d, 2d, 4d);

    }


}
