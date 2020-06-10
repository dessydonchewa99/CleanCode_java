package exceptions;
/**
 * Represents a MagazineParameterException.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import bookStore.FashionMagazine;
import bookStore.SportMagazine;

import java.util.Scanner;

public class MagazineParameterException extends Exception {
    public MagazineParameterException(String message){
        super(message);
    }
    public MagazineParameterException(){
        this("WRONG CODE");
    }

    /**
     * This method validates the code of hat of class SportMagazine.
     * @param sportMagazine This is the input object of class SportMagazine.
     * @param message This is the message that user should see if the program throws exceptions.
     */
    public void hatCodeValidation(SportMagazine sportMagazine, String message){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(sportMagazine.getCodeOfHat().charAt(0) == sportMagazine.getCodes(0)
                    || sportMagazine.getCodeOfHat().charAt(0) == sportMagazine.getCodes(1)){
                break;
            }
            else {
                try {
                    throw new MagazineParameterException(message);
                } catch (MagazineParameterException e) {
                    System.err.println(message);
                }
            }
            sportMagazine.setCodeOfHat(scanner.next());
        }
    }

    /**
     * This method validates the destination of ticket of class FashionMagazine.
     * @param fashionMagazine This is the input object of class FashionMagazine.
     * @param message This is the message that user should see if the program throws exceptions.
     */
    public void tombolaTicketValidation(FashionMagazine fashionMagazine, String message){
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (true){
            for (int i = 0; i < FashionMagazine.AVAILABLE_DESTINATIONS.length; i++) {
                if (fashionMagazine.getTombolaTicketDestination().equals(FashionMagazine.AVAILABLE_DESTINATIONS[i])) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            else {
                try {
                    throw new MagazineParameterException(message);
                } catch (MagazineParameterException e) {
                    System.err.println(message);
                }
            }
            fashionMagazine.setTombolaTicketDestination(scanner.next());
        }
    }
}

