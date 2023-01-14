package org.prog.coll;

import java.util.ArrayList;

public class CollectionsListMain {

    public static void main(String... args) {

        ArrayList<String> aList = new ArrayList<>();
        ArrayList<String> bList = new ArrayList<>();

        aList.add("Alice");
        aList.add("Bob");

        bList.add("Alice");
        bList.add("Joe");

        System.out.println(aList.contains("Alice"));

        System.out.println("======================================");
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("======================================");
        aList.addAll(bList);

        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("======================================");
        aList.removeAll(aList);

        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        System.out.println("======================================");

        for (int i = 0; i < bList.size(); i++) {
            System.out.println(bList.get(i));
        }
    }
}
