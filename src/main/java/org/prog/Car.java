package org.prog;


public class Car {
    private String color;
    private String licensePlate;
    public int speed;
    public String currentTrafficLight;

    public Car(String carColor, String plateNumber) {
        color = carColor;
        licensePlate = plateNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Car) &&
                ((Car) obj).color.equals(this.color);
    }

    @Override
    public String toString() {
        return color + licensePlate;
    }
}
