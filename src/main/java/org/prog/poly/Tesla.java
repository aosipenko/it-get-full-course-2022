package org.prog.poly;

public class Tesla implements ICar {

  private float chargeLevel = 0.0F;

  public void fuel() {
    chargeLevel = 100.0F;
  }

  public void startIgnition() {
    System.out.println("Tesla has no ignition!");
  }

  public void setGear() {
    System.out.println("Tesla has no gear");
  }

  public void accelerate() {

  }
}
