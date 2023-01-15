package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionDemo {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("");
        FileReader reader = new FileReader(file);
        smth1();
    }

    public static void smth1() {
        try {
            smth2();
        } catch (Exception e) {
            System.out.println("nothing happened");
        }
    }

    public static void smth2() throws Exception {
        smth3();
    }

    public static void smth3() throws Exception {
        smth4();
        throw new Exception();
    }

    public static void smth4() {
        smth5();
    }

    public static void smth5() {
        throw new RuntimeException();
    }

    public static int smth() {
        try {
            return 1;
        } finally {
            System.out.println("this is after it ends");
        }
    }

}

