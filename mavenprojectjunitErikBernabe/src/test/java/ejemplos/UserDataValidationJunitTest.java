/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ejemplos;

import java.time.LocalDate;
import model.validations.UserDataValidations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author erikbercam
 */
public class UserDataValidationJunitTest {

    public UserDataValidationJunitTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCheckID() {
        System.out.println(" testCheckId");
        int typedoc = 1;
        String id = "47198531R";
        boolean expResult = true;
        boolean result = UserDataValidations.checkID(typedoc, id);
        assertEquals(expResult, result, " NIF Correcto");

        String idIncorrecto = "478531R";
        expResult = false;
        result = UserDataValidations.checkID(typedoc, idIncorrecto);
        assertEquals(expResult, result, " NIF Incorrecto");

        String idSinLetra = "47198531";
        expResult = false;
        result = UserDataValidations.checkID(typedoc, idSinLetra);
        assertEquals(expResult, result, " NIF Incorrecto");

        String idDemasiadoLargo = "4719853123515";
        expResult = false;
        result = UserDataValidations.checkID(typedoc, idDemasiadoLargo);
        assertEquals(expResult, result, " NIF Incorrecto");

        String idLetras = "wtagsklnlkbkl";
        expResult = false;
        result = UserDataValidations.checkID(typedoc, idLetras);
        assertEquals(expResult, result, " NIF Incorrecto");
    }

    @Test
    public void testCheckFormatDate() {

        System.out.println("testCheckFormatDate");
        String validDate = "15/10/2020";
        boolean expResult = true;
        boolean result = UserDataValidations.checkFormatDate(validDate);
        assertEquals(expResult, result, "Fecha Valida");

        String validDate1 = "29/02/2024";
        expResult = true;
        result = UserDataValidations.checkFormatDate(validDate1);
        assertEquals(expResult, result, "Fecha Valida");
        
        String validDate2 = "01/05/2024";
        expResult = true;
        result = UserDataValidations.checkFormatDate(validDate2);
        assertEquals(expResult, result, "Fecha Valida");
        
        String validDate3 = "11/07/2023";
        expResult = true;
        result = UserDataValidations.checkFormatDate(validDate3);
        assertEquals(expResult, result, "Fecha Valida");
        
        String validDate4 = "23/09/2000";
        expResult = true;
        result = UserDataValidations.checkFormatDate(validDate4);
        assertEquals(expResult, result, "Fecha Valida");
        
        String validDate5 = "27/04/2009";
        expResult = true;
        result = UserDataValidations.checkFormatDate(validDate5);
        assertEquals(expResult, result, "Fecha Valida");
        
        String validDate6 = "04/08/2007";
        expResult = true;
        result = UserDataValidations.checkFormatDate(validDate6);
        assertEquals(expResult, result, "Fecha Valida");
        
        String invalidDate = "32/1/2025";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidDate);
        assertEquals(expResult, result, "Fecha Invalida");

        String invalidFormat = "15-10-1990";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat);
        assertEquals(expResult, result, "Fecha Invalida");

        String invalidFormat1 = "15101990";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat1);
        assertEquals(expResult, result, "Fecha Invalida");

        String invalidFormat2 = "10/15/2020";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat2);
        assertEquals(expResult, result, "Fecha Invalida");
        
        String invalidFormat3 = "10/5/2020";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat3);
        assertEquals(expResult, result, "Fecha Invalida");
        
        String invalidFormat4 = "1/05/2021";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat4);
        assertEquals(expResult, result, "Fecha Invalida");
        
        String invalidFormat5 = "01/05/21";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat5);
        assertEquals(expResult, result, "Fecha Invalida");
        
        String invalidFormat6 = "1/5/21";
        expResult = false;
        result = UserDataValidations.checkFormatDate(invalidFormat6);
        assertEquals(expResult, result, "Fecha Invalida");

    }

    @Test
    public void testCheckPostalCode() {
        System.out.println("testCheckPostalCode");

        String zipValido = "08820";
        boolean expResult = true;
        boolean result = UserDataValidations.checkPostalCode(zipValido);
        assertEquals(expResult, result, "Codigo Postal Valido");

        String invalidZip = "0882";
        expResult = false;
        result = UserDataValidations.checkPostalCode(invalidZip);
        assertEquals(expResult, result, "Codigo Postal Invalido");

        String fueraRango = "99999";
        expResult = false;
        result = UserDataValidations.checkPostalCode(fueraRango);
        assertEquals(expResult, result, "Codigo Postal Invalido");

        String letras = "asfer";
        expResult = false;
        result = UserDataValidations.checkPostalCode(letras);
        assertEquals(expResult, result, "Codigo Postal Invalido");
    }

    @Test
    public void testIsNumeric() {
        System.out.println("testIsNumeric");

        String numeros = "12345";
        boolean expResult = true;
        boolean result = UserDataValidations.isNumeric(numeros);
        assertEquals(expResult, result, "Correcto");
        
        String numeros1 = "1505124";
         expResult = true;
         result = UserDataValidations.isNumeric(numeros1);
        assertEquals(expResult, result, "Correcto");
        
        String numeros2 = "34";
        expResult = true;
        result = UserDataValidations.isNumeric(numeros2);
        assertEquals(expResult, result, "Correcto");

        String mezcla = "123abc";
        expResult = false;
        result = UserDataValidations.isNumeric(mezcla);
        assertEquals(expResult, result, "Incorrecto");

        String letras = "abcag";
        expResult = false;
        result = UserDataValidations.isNumeric(letras);
        assertEquals(expResult, result, "Incorrecto");
        
        String letras1 = "ab";
        expResult = false;
        result = UserDataValidations.isNumeric(letras1);
        assertEquals(expResult, result, "Incorrecto");
    }

       @Test
    public void testCheckCalculateDate() {
        System.out.println("testCheckCalculateDate");

        String fechaCumple = "15/10/1990";
        int expResult = LocalDate.now().getYear() - 1991;
        int result = UserDataValidations.checkCalculateDate(fechaCumple);
        assertEquals(expResult, result, "Edad Correcta 1");

        String fechaCumple1 = "08/01/2006";
        expResult = LocalDate.now().getYear() - 2006;
        result = UserDataValidations.checkCalculateDate(fechaCumple1);
        assertEquals(expResult, result, "Edad Correcta 2");

        String fechaCumple2 = "18/11/2005";
        expResult = LocalDate.now().getYear() - 2006;
        result = UserDataValidations.checkCalculateDate(fechaCumple2);
        assertEquals(expResult, result, "Edad Correcta 3");

        String fechaCumple3 = "18/12/2001";
        expResult = LocalDate.now().getYear() - 2002;
        result = UserDataValidations.checkCalculateDate(fechaCumple3);
        assertEquals(expResult, result, "Edad Correcta 4");
        
        String fechaCumple4 = "07/02/1977";
        expResult = LocalDate.now().getYear() - 1977;
        result = UserDataValidations.checkCalculateDate(fechaCumple4);
        assertEquals(expResult, result, "Edad Correcta 5");
        
        String fechaCumple5 = "27/07/1920";
        expResult = LocalDate.now().getYear() - 1921;
        result = UserDataValidations.checkCalculateDate(fechaCumple5);
        assertEquals(expResult, result, "Edad Correcta 6");

        String futureDate = "15/10/2050";
        expResult = -1;
        result = UserDataValidations.checkCalculateDate(futureDate);
        assertEquals(expResult, result, "Fecha Invalida");

        String invalidFormat = "15-10-1990";
        expResult = -1;
        result = UserDataValidations.checkCalculateDate(invalidFormat);
        assertEquals(expResult, result, "Fecha Invalida");

        String invalidFormat1 = "15101990";
        expResult = -1;
        result = UserDataValidations.checkCalculateDate(invalidFormat1);
        assertEquals(expResult, result, "Fecha Invalida");
    }

    @Test
    public void testIsAlphabetic() {
        System.out.println("testIsAlphabetic");

        String letras = "abcde";
        boolean expResult = true;
        boolean result = UserDataValidations.isAlphabetic(letras);
        assertEquals(expResult, result, "Correcto");

        String mezcla = "abc123";
        expResult = false;
        result = UserDataValidations.isAlphabetic(mezcla);
        assertEquals(expResult, result, "Incorrecto");

        String numeros = "12343";
        expResult = false;
        result = UserDataValidations.isAlphabetic(numeros);
        assertEquals(expResult, result, "Incorrecto");
    }

    @Test
    public void testCheckEmail() {
        System.out.println("testCheckEmail");

        String validEmail = "erikbcamara2006@gmail.com";
        boolean expResult = true;
        boolean result = UserDataValidations.checkEmail(validEmail);
        assertEquals(expResult, result, "Correo Valido");

        String invalidEmail = "erikbernabe.com";
        expResult = false;
        result = UserDataValidations.checkEmail(invalidEmail);
        assertEquals(expResult, result, "Correo Invalido");

        String invalidEmailParteInicial = "erik@";
        expResult = false;
        result = UserDataValidations.checkEmail(invalidEmailParteInicial);
        assertEquals(expResult, result, "Correo Invalido");

        String invalidEmailParteInicial1 = "@pozo.com";
        expResult = false;
        result = UserDataValidations.checkEmail(invalidEmailParteInicial1);
        assertEquals(expResult, result, "Correo Invalido");
    }

    @Test
    public void testCheckName() {
        System.out.println("testCheckName");

        String validName = "Erik";
        boolean expResult = true;
        boolean result = UserDataValidations.checkName(validName);
        assertEquals(expResult, result, "Nombre Valido");

        String validNameCorto = "E";
        expResult = true;
        result = UserDataValidations.checkName(validNameCorto);
        assertEquals(expResult, result, "Nombre Valido");

        String invalidName = "Erik123";
        expResult = false;
        result = UserDataValidations.checkName(invalidName);
        assertEquals(expResult, result, "Nombre Invalido");

        String longName = "ErikErikErikErikErikErikErikErik";
        expResult = false;
        result = UserDataValidations.checkName(longName);
        assertEquals(expResult, result, "Nombre Invalido");

        String numberName = "12342345";
        expResult = false;
        result = UserDataValidations.checkName(numberName);
        assertEquals(expResult, result, "Nombre Invalido");

    }

}
