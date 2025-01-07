import java.util.*;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Lab10 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Bir sayı girin: ");
            String numberInput = scanner.nextLine();

           
            int number = validateNumber(numberInput);

            System.out.print("Yaşınızı girin: ");
            String ageInput = scanner.nextLine();

        
            int age = validateAge(ageInput);

            System.out.println("Doğru formatta bir sayı girdiniz: " + number);
            System.out.println("Uygun bir yaş girdiniz: " + age);
            System.out.println("Girilen sayının karesi: " + (number * number));

        } catch (NumberFormatException e) {
            System.out.println("Hatalı sayı formatı: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Hatalı yaş bilgisi: " + e.getMessage());
        }
    }

    public static int validateNumber(String input) throws NumberFormatException {
        try {
            return Integer.parseInt(input); 
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Geçersiz sayı formatı: " + input);
        }
    }

    public static int validateAge(String input) throws InvalidAgeException {
        try {
            int age = Integer.parseInt(input); 
            if (age < 18) {
                throw new InvalidAgeException("Yaş 18'den küçük olamaz: " + age);
            }
            return age;
        } catch (NumberFormatException e) {
            throw new InvalidAgeException("Geçersiz yaş formatı: " + input);
        }
    }
}