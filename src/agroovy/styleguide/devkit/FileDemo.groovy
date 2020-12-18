package agroovy.styleguide.devkit

import org.junit.Test

class FileDemo {


    @Test
    void readFile() {
        new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt").eachLine {
            line -> println line
        }
        new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt").eachLine("utf-8") {
            line, nb -> println "Line ${nb}: ${line}"
        }

    }

    @Test
    void readFileException() {
        def count = 0, MAXSIZE = 3;

        new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt").withReader {
            reader ->
                while (reader.readLine()) {
                    if (++count > MAXSIZE) {
                        throw new RuntimeException("should 3 verbose");
                    }
                }
        }
    }

    @Test
    void readFileList() {
        def list = new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt").collect {
            it
        };
        println "list :${list}";
        def array = new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt") as String[];
        println "array :${array}";
    }

    @Test
    void readFileByte(){
        def file = new File("C:\\Users\\DPN\\Desktop\\demo\\", "test.txt");
        def contents = file.bytes;
        println "byte :${contents}"
    }

}
