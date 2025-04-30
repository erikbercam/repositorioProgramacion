package model;

public class Motorcycle extends Vehicle {

    private boolean hasSidecar;
    private int engineDisplacement;

    // CONSTRUCTORS
    public Motorcycle(String brand, String registration, String model, int horsepower, int capacity, ColorEnum color, EngineType engine, TransmissionType transmission, String fabricationDate, boolean hasSidecar, int engineDisplacement, double weight) {
        super(brand, registration, model, horsepower, capacity, color, engine, transmission, fabricationDate, weight);
        this.hasSidecar = hasSidecar;
        this.engineDisplacement = engineDisplacement;
    }

    // GETTERs y SETTERs
    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    // TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Has sidecar: ");
        sb.append(hasSidecar ? "Yes" : "No");
        sb.append("\n");
        sb.append("Engine displacement(Cilindrada: ");
        sb.append(engineDisplacement);
        sb.append(" cc\n");
        return sb.toString();
    }
}
