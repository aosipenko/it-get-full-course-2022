package org.prog;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {

    String s = null;

    Optional<String> opt = Optional.ofNullable(s);
    System.out.println(opt.isPresent());
  }


}


