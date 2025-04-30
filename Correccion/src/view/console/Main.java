package view.console;

import java.util.ArrayList;
import java.util.Scanner;
import model.Car;
import model.ColorEnum;
import model.EngineType;
import model.TransmissionType;
import model.Vehicle;
import model.Truck;
import model.Motorcycle;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nVehicle Management Menu:");
            System.out.println("1. Create Car");
            System.out.println("2. Create Motorcycle");
            System.out.println("3. Create Truck");
            System.out.println("4. Show Registrations");
            System.out.println("5. Search Vehicle by Registration");
            System.out.println("6. Show Total Vehicles");
            System.out.println("7. Show Total Cars");
            System.out.println("8. Show Total Motorcycles");
            System.out.println("9. Show Total Trucks");
            System.out.println("10. Delete Vehicle by Registration");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    vehicles.add(createCar());
                    break;
                case 2:
                    vehicles.add(createMotorcycle());
                    break;
                case 3:
                    vehicles.add(createTruck());
                    break;
                case 4:
                    showRegistrations();
                    break;
                case 5:
                    searchVehicle();
                    break;
                case 6:
                    System.out.println("Total vehicles: " + vehicles.size());
                    break;
                case 7:
                    showTotalCars();
                    break;
                case 8:
                    showTotalMotorcycles();
                    break;
                case 9:
                    showTotalTrucks();
                    break;
                case 10:
                    deleteVehicle();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 11);

        sc.close();
    }

    private static Vehicle createCar() {
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Registration: ");
        String registration = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Horsepower: ");
        int horsepower = sc.nextInt();
        System.out.print("Capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();
        System.out.print("Color (BLACK, WHITE, RED, BLUE, GREEN): ");
        ColorEnum color = ColorEnum.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Engine type (GASOLINE, DIESEL, ELECTRIC, HYBRID): ");
        EngineType engine = EngineType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Transmission type (MANUAL, AUTOMATIC, SEMIAUTOMATIC): ");
        TransmissionType transmission = TransmissionType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Manufacturing date (dd/MM/yyyy): ");
        String fabricationDate = sc.nextLine();
        System.out.print("Number of doors: ");
        int numberOfDoors = sc.nextInt();
        System.out.print("Weight: ");
        double weight = sc.nextDouble();
        sc.nextLine();

        return new Car(brand, registration, model, horsepower, capacity, color, engine, transmission, fabricationDate, numberOfDoors, weight);
    }

    private static Vehicle createMotorcycle() {
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Registration: ");
        String registration = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Horsepower: ");
        int horsepower = sc.nextInt();
        System.out.print("Capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();
        System.out.print("Color (BLACK, WHITE, RED, BLUE, GREEN): ");
        ColorEnum color = ColorEnum.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Engine type (GASOLINE, DIESEL, ELECTRIC, HYBRID): ");
        EngineType engine = EngineType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Transmission type (MANUAL, AUTOMATIC, SEMIAUTOMATIC): ");
        TransmissionType transmission = TransmissionType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Manufacturing date (dd/MM/yyyy): ");
        String fabricationDate = sc.nextLine();
        System.out.print("Has sidecar? (true/false): ");
        boolean hasSidecar = sc.nextBoolean();
        System.out.print("Engine displacement (Cilindrada): ");
        int engineDisplacement = sc.nextInt();
        sc.nextLine();
        System.out.print("Weight: ");
        double weight = sc.nextDouble();
        sc.nextLine();

        return new Motorcycle(brand, registration, model, horsepower, capacity, color, engine, transmission, fabricationDate, hasSidecar, engineDisplacement, weight);
    }

    private static Vehicle createTruck() {
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Registration: ");
        String registration = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Horsepower: ");
        int horsepower = sc.nextInt();
        System.out.print("Capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();
        System.out.print("Color (BLACK, WHITE, RED, BLUE, GREEN): ");
        ColorEnum color = ColorEnum.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Engine type (GASOLINE, DIESEL, ELECTRIC, HYBRID): ");
        EngineType engine = EngineType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Transmission type (MANUAL, AUTOMATIC, SEMIAUTOMATIC): ");
        TransmissionType transmission = TransmissionType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Manufacturing date (dd/MM/yyyy): ");
        String fabricationDate = sc.nextLine();
        System.out.print("Number of doors: ");
        int numberOfDoors = sc.nextInt();
        System.out.print("Load capacity (kg): ");
        double loadCapacity = sc.nextDouble();
        System.out.print("Height (m): ");
        double height = sc.nextDouble();
        sc.nextLine();
        System.out.print("Weight: ");
        double weight = sc.nextDouble();
        sc.nextLine();

        return new Truck(brand, registration, model, horsepower, capacity, color, engine, transmission, fabricationDate, numberOfDoors, loadCapacity, height, weight);
    }

    private static void showRegistrations() {
        for (Vehicle v : vehicles) {
            if (v.getRegistration() == null) {
                System.out.println("Null registration, not valid.");
            } else {
                System.out.println("Registration: " + v.getRegistration());
            }
        }
    }

    private static void searchVehicle() {
        System.out.print("Enter vehicle registration: ");
        String registration = sc.nextLine();
        for (Vehicle v : vehicles) {
            if (v.getRegistration().equals(registration)) {
                System.out.println(v);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    private static void deleteVehicle() {
        System.out.print("Enter vehicle registration to delete: ");
        String registration = sc.nextLine();
        for (Vehicle v : vehicles) {
            if (v.getRegistration().equals(registration)) {
                vehicles.remove(v);
                System.out.println("Vehicle deleted.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    private static void showTotalCars() {
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                count++;
            }
        }
        System.out.println("Total cars: " + count);
    }

    private static void showTotalMotorcycles() {
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Motorcycle) {
                count++;
            }
        }
        System.out.println("Total motorcycles: " + count);
    }

    private static void showTotalTrucks() {
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Truck) {
                count++;
            }
        }
        System.out.println("Total trucks: " + count);
    }

    private static double calculateConsumption(Vehicle v) {
        return v.getWeight() * 10 / 100;
    }
}