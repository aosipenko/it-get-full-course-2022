package org.prog.coll;

import java.util.HashSet;

public class CollectionsSetMain {

    public static void main(String... args) {
        HashSet<String> stringSet = new HashSet<>();
        stringSet.add("testString");
        stringSet.add("testString");
        System.out.println(stringSet.size());


    }
}
