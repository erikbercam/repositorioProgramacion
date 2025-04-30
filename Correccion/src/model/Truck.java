package model;

public class Truck extends Vehicle {

    private int numberOfDoors;
    private double loadCapacity;
    private double height;

    // CONSTRUCTOR
    public Truck(String brand, String registration, String model, int horsepower, int capacity, ColorEnum color, EngineType engine, TransmissionType transmission, String fabricationDate, int numberOfDoors, double loadCapacity, double height, double weight) {
        super(brand, registration, model, horsepower, capacity, color, engine, transmission, fabricationDate, weight);
        this.numberOfDoors = numberOfDoors;
        this.loadCapacity = loadCapacity;
        this.height = height;
    }

    // GETTERs y SETTERs
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Number of doors: ").append(numberOfDoors).append("\n");
        sb.append("Load capacity: ").append(loadCapacity).append(" kg\n");
        sb.append("Height: ").append(height).append(" m\n");
        return sb.toString();
    }
}