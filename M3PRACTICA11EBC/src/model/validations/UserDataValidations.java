package model.validations;

import java.time.LocalDate;
import model.exceptions.FormatException;
import model.exceptions.InvalidDataException;

/**
 *
 * @author User
 */
public class UserDataValidations {
     /**
     * Validamos un ID según el formato establecido.
     *
     * @param typeDoc indica el tipo de documento (1 indica ID válido).
     * @param ID es el identificador a validar.
     * @throws FormatException si el formato del ID no es válido
     * @throws InvalidDataException si el tipo de documento no es válido
     */
    public static void checkID(int typeDoc, String ID) throws FormatException, InvalidDataException {

        if (typeDoc != 1) {
            throw new InvalidDataException("Tipo de documento no válido");
        }

        // Verificamos que el ID no sea nulo y tenga 9 caracteres
        if (ID == null || ID.length() != 9) {
            throw new FormatException("El ID debe tener 9 caracteres", "NIF");
        }

        // Separamos la parte numerica y la letra 
        String parteNumeros = ID.substring(0, 8);
        char letraFinal = ID.charAt(8);

        for (int i = 0; i < parteNumeros.length(); i++) {
            if (!Character.isDigit(parteNumeros.charAt(i))) {
                throw new FormatException("Los primeros 8 caracteres deben ser números", "NIF");
            }
        }
        
        // Calculamos la letra esperada basandonos en la parte numérica
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        int valorNume = Integer.parseInt(parteNumeros);
        char letraEsperada = letrasDNI.charAt(valorNume % 23);

        // Comparamos la letra esperada con la letra en el ID
        if (letraFinal != letraEsperada) {
            throw new FormatException("La letra del NIF no es válida", "NIF");
        }
    }

    /**
     * Valida si una fecha tiene el formato "dd/MM/yyyy" y si es valida.
     *
     * @param date la fecha a validar.
     * @throws FormatException si el formato de la fecha no es válido
     */
   public static void checkFormatDate(String date) throws FormatException {
        if (date == null || date.length() != 10) {
            throw new FormatException("El formato de fecha debe ser dd/mm/yyyy", "fecha");
        }
 
        String[] partes = date.split("/");
 
        if (partes.length != 3) {
            throw new FormatException("El formato de fecha debe ser dd/mm/yyyy", "fecha");
        }
        
        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int año = Integer.parseInt(partes[2]);
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || año < 1000 || año > 9999) {
                throw new FormatException("Valores de fecha fuera de rango", "fecha");
            }
            
            if (mes == 2) {
                if ((año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
                    if (dia > 29) {
                        throw new FormatException("Día inválido para febrero en año bisiesto", "fecha");
                    }
                } else {
                    if (dia > 28) {
                        throw new FormatException("Día inválido para febrero en año no bisiesto", "fecha");
                    }
                }
            } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if (dia > 30) {
                    throw new FormatException("El mes especificado no tiene más de 30 días", "fecha");
                }
            } else if (dia > 31) {
                throw new FormatException("Día inválido para el mes especificado", "fecha");
            }
        } catch (NumberFormatException e) {
            throw new FormatException("Los componentes de la fecha deben ser números", "fecha");
        }
    }
    
    /**
     * Calcula la edad en base a una fecha de nacimiento.
     *
     * @param birthDate la fecha de nacimiento en formato "dd/MM/yyyy".
     * @return la edad calculada, o -1 si la fecha es invalida o incoherente.
     * @throws FormatException si el formato de la fecha no es válido
     */
    public static int checkCalculateDate(String birthDate) throws FormatException {
        // fecha actual
        LocalDate fechaHoy = LocalDate.now();

        int dia = fechaHoy.getDayOfMonth();
        int mes = fechaHoy.getMonthValue();
        int year = fechaHoy.getYear();

        // Validamos que no sea nula y tenga 10 caracteres
        if (birthDate == null || birthDate.length() != 10) {
            throw new FormatException("El formato de fecha debe ser dd/mm/yyyy", "fecha de nacimiento");
        }

        // Validamos que tenga 3 secciones
        String[] parts = birthDate.split("/");
        if (parts.length != 3) {
            throw new FormatException("El formato de fecha debe ser dd/mm/yyyy", "fecha de nacimiento");
        }

        try {
            // partes a enteros
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year1 = Integer.parseInt(parts[2]);
    
            //Verificamos rango
            if (month < 1 || month > 12) {
                throw new FormatException("Mes fuera de rango", "fecha de nacimiento");
            }
    
            //ultimos dias mes
            int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
            //verificamos bisiesto
            if (month == 2) {
                boolean esBisiesto = (year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0);
                if (esBisiesto) {
                    diasPorMes[1] = 29;
                }
            }
    
            //Validamos rango permitido de dias
            if (day < 1 || day > diasPorMes[month - 1]) {
                throw new FormatException("Día inválido para el mes especificado", "fecha de nacimiento");
            }
    
            //verificamos que no sea futura
            if (year1 > year || (year1 == year && month > mes)
                    || (year1 == year && month == mes && day > dia)) {
                throw new FormatException("La fecha de nacimiento no puede ser futura", "fecha de nacimiento");
            }
    
            //calculo edad
            int age = year - year1;
    
            if (month > mes || (month == mes && day > dia)) {
                age--;
            }
            return age;
        } catch (NumberFormatException e) {
            throw new FormatException("Los componentes de la fecha deben ser números", "fecha de nacimiento");
        }
    }

    /**
     * Verifica si un código postal es valido (5 dígitos entre 1000 y 52999)
     *
     * @param zip el codigo postal a validar
     * @throws FormatException si el formato del código postal no es válido
     */
    public static void checkPostalCode(String zip) throws FormatException {

        if (zip == null || zip.isEmpty()) {
            throw new FormatException("El código postal no puede estar vacío", "código postal");
        }
        
        //Comprobamos que tenga 5 digitos
        if (zip.length() != 5) {
            throw new FormatException("El código postal debe tener 5 dígitos", "código postal");
        }

        //comprobamos si son digitos       
        for (int i = 0; i < zip.length(); i++) {
            if (!Character.isDigit(zip.charAt(i))) {
                throw new FormatException("El código postal debe contener solo dígitos", "código postal");
            }
        }

        //conversion string a int y validación
        int numero = Integer.parseInt(zip);
        if (numero < 1000 || numero > 52999) {
            throw new FormatException("El código postal debe estar entre 1000 y 52999", "código postal");
        }
    }

    /**
     * Verifica si un string contiene solo caracteres numericos
     *
     * @param str el string a comprobar
     * @throws FormatException si el string no es numérico
     */
    public static void isNumeric(String str) throws FormatException {
        if (str == null || str.isEmpty()) {
            throw new FormatException("El texto no puede estar vacío", "campo numérico");
        }
        
        //comprobamos que los sean digitos
        for (char comprobar : str.toCharArray()) {
            if (!Character.isDigit(comprobar)) {
                throw new FormatException("El texto debe contener solo dígitos", "campo numérico");
            }
        }
    }

    /**
     * Verifica si un string contiene solo caracteres alfabéticos
     *
     * @param str el string a comprobar
     * @throws FormatException si el string no es alfabético
     */
    public static void isAlphabetic(String str) throws FormatException {
        if (str == null || str.isEmpty()) {
            throw new FormatException("El texto no puede estar vacío", "campo alfabético");
        }
        
        //comprobamos que sean solo letras
        for (char comprobar : str.toCharArray()) {
            if (!Character.isAlphabetic(comprobar)) {
                throw new FormatException("El texto debe contener solo letras", "campo alfabético");
            }
        }
    }

    /**
     * Valida si un correo electronico tiene un formato valido
     *
     * @param email el correo electronico a validar
     * @throws FormatException si el formato del correo electrónico no es válido
     */
    public static void checkEmail(String email) throws FormatException {
        //Comprobamos que no sea nulo ni vacio
        if (email == null || email.isEmpty()) {
            throw new FormatException("El email no puede estar vacío", "email");
        }
        
        //Dividimos para verificar la 1r parte
        String[] arroba = email.split("@");

        //comprobamos que tenga contenido antes y despues @
        if (arroba.length != 2 || arroba[0].isEmpty() || arroba[1].isEmpty()) {
            throw new FormatException("El email debe tener formato usuario@dominio", "email");
        }

        //Verifica la 2n parte - debe tener un punto
        if (!arroba[1].contains(".")) {
            throw new FormatException("El dominio debe tener al menos un punto", "email");
        }
        
        String[] despuesArroba = arroba[1].split("\\.");
        
        //Comprobamos que tenga un . almenos despues @
        if (despuesArroba.length < 2 || despuesArroba[0].isEmpty() || despuesArroba[1].isEmpty()) {
            throw new FormatException("El dominio debe tener una parte después del punto", "email");
        }
    }

    /**
     * Verifica si un nombre es valido
     *
     * @param name el nombre a validar
     * @throws FormatException si el formato del nombre no es válido
     */
    public static void checkName(String name) throws FormatException {
        if (name == null || name.isEmpty()) {
            throw new FormatException("El nombre no puede estar vacío", "nombre");
        }
        
        //Comprobamos que la longitud sea razonable
        if (name.length() < 1 || name.length() > 27) {
            throw new FormatException("El nombre debe tener entre 1 y 27 caracteres", "nombre");
        }
        
        //Comprobamos que sean solo letras
        for (char comprobar : name.toCharArray()) {
            if (!Character.isAlphabetic(comprobar)) {
                throw new FormatException("El nombre debe contener solo letras", "nombre");
            }
        }
    }
}