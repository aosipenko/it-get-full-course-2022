package org.prog.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsListMain {

  public static void main(String... args) {
    ArrayList<String> aList = new ArrayList<>();
    aList.add("asdasd");
    aList.add("asda");
    aList.add("asdasdasdasd");
    aList.add("a");
    aList.add("asdasdasdazxczxc");
    aList.add("asdasljkh");
    aList.add("");

    ArrayList<Integer> intList = new ArrayList<>();
    for (String s : aList) {
      if (s.length() < 6) {
        intList.add(s.length());
      }
    }

    List<Integer> intList2 = aList.stream()
        .filter(listElement -> listElement.length() < 6)
        .map(listElement -> listElement.length())
        .collect(Collectors.toList());
  }

  private static List<Integer> smth(List<String> input) {
    return input.stream()
        .filter(listElement -> listElement.length() < 6)
        .map(String::length)
        .collect(Collectors.toList());
  }
}
