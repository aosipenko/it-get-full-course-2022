package org.prog.poly;

public class RaceCar implements ICar {

  private int fuelLevel = 0;

  @Override
  public void fuel() {
    this.fuelLevel = 10;
  }

  @Override
  public void startIgnition() {
    fuelLevel = 9;
    System.out.println("car started!");
  }

  @Override
  public void setGear() {
    System.out.println("switching to gear 1");
  }

  @Override
  public void accelerate() {

  }
}
