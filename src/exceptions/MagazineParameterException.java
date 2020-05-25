package exceptions;

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

    public void hatCodeValidation(SportMagazine sportMagazine, String message){
        Scanner scanner = new Scanner(System.in);
        char[] typeHat = new char[1];
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

    public void tombolaTicketValidation(FashionMagazine fashionMagazine, String message){
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (true){
            for (int i = 0; i < fashionMagazine.AVAILABLE_DESTINATIONS.length; i++) {
                if (fashionMagazine.getTombolaTicketDestination().equals(fashionMagazine.AVAILABLE_DESTINATIONS[i])) {
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

