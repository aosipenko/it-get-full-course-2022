package org.prog.other;

public class FinalDemo {
  private final String s;
  private final Building building = new Building();
  private final int i = 5;

  public static void main(String... args) {
    new FinalDemo();
  }

  public FinalDemo() {
    this.s = "a";
    building.firstFloor = "Сільпо";
    building.firstFloor = "АТБ";
  }


  private final void smth() {
//    s = "a";
  }

  private final class InnerClass {

  }

}
