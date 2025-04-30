package model;

public class Car extends Vehicle {

    private int numberOfDoors;

    // CONSTRUCTORS
    public Car() {
        super(null);
    }

    public Car(String brand, String registration, String model, int horsepower, int capacity, ColorEnum color, EngineType engine, TransmissionType transmission, String fabricationDate, int numberOfDoors, double weight) {
        super(brand, registration, model, horsepower, capacity, color, engine, transmission, fabricationDate, weight);
        this.numberOfDoors = numberOfDoors;
    }

    // GETTERs y SETTERs
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    // TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Number of doors: ");
        if (numberOfDoors > 0) {
            sb.append(numberOfDoors);
        } else {
            sb.append("Not specified");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public double calcularConsumo() {
   double consumo = 0;
   
   consumo = this.getPeso() * 10/100;
   return consumo;
    }

    private int getPeso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}