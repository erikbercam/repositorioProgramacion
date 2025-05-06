/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;
import model.validations.UserDataValidations;
import model.exceptions.FormatException;
import model.exceptions.InvalidDataException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class main {
      static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String option;

        do {

            System.out.println("MENU: ");
            System.out.println("1. - Tester checkId");
            System.out.println("2. - Tester checkFormatDate");
            System.out.println("3. - Tester calculateAge");
            System.out.println("4. - Tester checkPostalCode");
            System.out.println("5. - Tester isNumeric");
            System.out.println("6. - Tester isAlphabetic");
            System.out.println("7. - Tester checkEmail");
            System.out.println("8. - Tester checkName");
            System.out.println("Z. - Salir");
            System.out.print("Option: ");
            option = sc.next().toUpperCase();

            switch (option) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testCheckFormatDate();
                    break;
                case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    testCheckName();
                    break;
                case "Z":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta, por favor intente de nuevo.");
            }
        } while (!option.equals("Z"));
    }

    public static void testCheckId() {
        System.out.println("NIF Validator");
        System.out.print("Enter your ID: ");
        String id = sc.next();

        try {
            UserDataValidations.checkID(1, id);
            System.out.println("Correct ID");
        } catch (FormatException | InvalidDataException e) {
            System.out.println("Incorrect ID: " + e.getMessage());
        }
    }

    public static void testCheckFormatDate() {
        System.out.println("DATE Validator");
        System.out.print("Enter a date (dd/mm/yyyy): ");
        String date = sc.next();
        try {
            UserDataValidations.checkFormatDate(date);
            System.out.println("Correct date ");
        } catch (FormatException e) {
            System.out.println("Incorrect date: " + e.getMessage());
        }
    }

    public static void testCalculateAge() {
        System.out.println("Age Validator");
        System.out.print("Enter your birth date(dd/mm/yyyy): ");
        String birthDate = sc.next();

        try {
            int age = UserDataValidations.checkCalculateDate(birthDate);
            System.out.println("Your age is: " + age);
        } catch (FormatException e) {
            System.out.println("Incorrect date, please enter your birth date: " + e.getMessage());
        }
    }

    public static void testCheckPostalCode() {
        System.out.println("Postal Code Validator");
        System.out.print("Enter your postal code: ");
        String zip = sc.next();

        try {
            UserDataValidations.checkPostalCode(zip);
            System.out.println("Correct postal code.");
        } catch (FormatException e) {
            System.out.println("Incorrect postal code: " + e.getMessage());
        }
    }

    static void testIsNumeric() {
        System.out.println("Enter a numeric String");
        String str = sc.next();
        try {
            UserDataValidations.isNumeric(str);
            System.out.println("Correct format.");
        } catch (FormatException e) {
            System.out.println("Incorrect format: " + e.getMessage());
        }
    }

    static void testIsAlphabetic() {
        System.out.println("Enter a String");
        String str = sc.next();
        try {
            UserDataValidations.isAlphabetic(str);
            System.out.println("Correct format.");
        } catch (FormatException e) {
            System.out.println("Incorrect format: " + e.getMessage());
        }
    }

    static void testCheckEmail() {
        System.out.println("Enter a valid email");
        String email = sc.next();
        try {
            UserDataValidations.checkEmail(email);
            System.out.println("Valid Email");
        } catch (FormatException e) {
            System.out.println("Invalid Email: " + e.getMessage());
        }
    }

    static void testCheckName() {
        System.out.println("Enter your name to see if it is valid: ");
        String name = sc.next();

        try {
            UserDataValidations.checkName(name);
            System.out.println("Valid Name");
        } catch (FormatException e) {
            System.out.println("Invalid Name: " + e.getMessage());
        }
    }
}