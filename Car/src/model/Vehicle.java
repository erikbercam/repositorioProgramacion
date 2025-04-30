package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public abstract class Vehicle {

    private String brand;
    private String registration;
    private String model;
    private int horsepower;
    private int capacity;
    private ColorEnum color;
    private EngineType engine;
    private double speed;
    private final String fabricationDate;
    private TransmissionType transmission;
    private double weight;

    // CONSTRUCTOR
    public Vehicle(String fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public Vehicle(String brand, String registration, String model, int horsepower, int capacity, ColorEnum color, EngineType engine, TransmissionType transmission, String fabricationDate, double weight) {
        this.brand = brand;
        this.registration = registration;
        this.model = model;
        this.horsepower = horsepower;
        this.capacity = capacity;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.speed = 0;
        this.fabricationDate = fabricationDate;
        this.weight = weight;
    }

    // GETTERs y SETTERs
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = Math.max(0, Math.min(speed, 220));
    }

    public String getFabricationDate() {
        return fabricationDate;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // METHOD TO CALCULATE AGE
    public int calculateAge() {
        LocalDate fabDate = LocalDate.parse(fabricationDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(fabDate, currentDate);
        return period.getYears();
    }

    // METHODS TO ACCELERATE AND BRAKE
    public void accelerate() {
        double accelerationBase = 10.0;
        speed = Math.min(speed + accelerationBase, 200);
    }

    public void accelerate(double acceleration) {
        speed = Math.min(speed + acceleration, 200);
    }

    public void brake() {
        double brakeBase = 10.0;
        speed = Math.max(speed - brakeBase, 0);
    }

    public void brake(double brake) {
        speed = Math.max(speed - brake, 0);
    }

    // TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vehicle Details:\n");
        sb.append("Brand: ").append(brand).append("\n");
        sb.append("Registration: ").append(registration).append("\n");
        sb.append("Model: ").append(model).append("\n");
        sb.append("Horsepower: ").append(horsepower).append(" HP\n");
        sb.append("Capacity: ").append(capacity).append(" seats\n");
        sb.append("Fabrication Date: ").append(fabricationDate).append("\n");
        sb.append("Age: ").append(calculateAge()).append(" years\n");
        sb.append("Speed: ").append(speed).append(" km/h\n");
        sb.append("Weight: ").append(weight).append(" Kg\n");
        if (color != null) {
            sb.append("Color: ").append(color).append("\n");
        }
        if (engine != null) {
            sb.append("Engine: ").append(engine).append("\n");
        }
        if (transmission != null) {
            sb.append("Transmission: ").append(transmission).append("\n");
        }
        return sb.toString();
    }
    
    //METODOS PROPIOS
    public abstract double calcularConsumo();
}