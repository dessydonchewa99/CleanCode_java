package bookStore;
/**
 * Represents a FashionMagazine.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import exceptions.*;

import java.util.Arrays;
import java.util.List;

public class FashionMagazine extends Magazine {

    public static final String[] AVAILABLE_DESTINATIONS = {"ITALY", "GERMANY", "FRANCE", "UK", "USA"};
    public static final double PRICE_TOMBOLA = 3.15;

    private boolean tombolaTicket; // not every edition should have tombola tickets
    private String tombolaTicketDestination;

    /**
     * Default constructor for class FashionMagazine.
     */
    public FashionMagazine(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false, 0);
        setTombolaTicket(false);
        setTombolaTicketDestination(null);
    }
    /**
     * Constructor with parameters for class FashionMagazine.
     * @param pricePerPage This is the price per page of the FashionMagazine.
     * @param pages This is the amount of pages of the FashionMagazine.
     * @param issueInThousands This is the issue count in thousands of the FashionMagazine.
     * @param name This is the name of the FashionMagazine.
     * @param hasPosters Shows if the FashionMagazine has posters.
     * @param numberOfInterviews This is the number of interviews of the FashionMagazine.
     * @param tombolaTicket Shows if the FashionMagazine has tombola ticket.
     * @param tombolaTicketDestination This is the destination of the tombola ticket of the FashionMagazine.
     */
    public FashionMagazine(double pricePerPage, int pages, int issueInThousands, String name, boolean hasPosters,
                           int numberOfInterviews, boolean tombolaTicket, String tombolaTicketDestination){
        super(pricePerPage, pages, issueInThousands, name, hasPosters, numberOfInterviews);
        setTombolaTicket(tombolaTicket);
        if(tombolaTicket) setTombolaTicketDestination(tombolaTicketDestination);
        else setTombolaTicketDestination(null);
    }
    /**
     * Copy constructor for class FashionMagazine.
     * @param fashionMagazine Object of class FashionMagazine.
     */
    public FashionMagazine(FashionMagazine fashionMagazine){
        super(fashionMagazine.getPricePerPage(), fashionMagazine.getPages(), fashionMagazine.getIssueInThousands(),
                fashionMagazine.getName(), fashionMagazine.getHasPosters(), fashionMagazine.getNumberOfInterviews());
        setTombolaTicket(tombolaTicket);
        if(tombolaTicket) setTombolaTicketDestination(tombolaTicketDestination);
        else setTombolaTicketDestination(null);
    }

    /**
     * This method sets tombolaTicket of class FashionMagazine.
     * @param tombolaTicket Shows if the FashionMagazine has tombola ticket.
     */
    public void setTombolaTicket(boolean tombolaTicket) {
        this.tombolaTicket = tombolaTicket;
    }
    /**
     * This method sets tombolaTicketDestination of class FashionMagazine.
     * @param tombolaTicketDestination This is the destination of the tombola ticket of the FashionMagazine.
     */
    public void setTombolaTicketDestination(String tombolaTicketDestination) {
        this.tombolaTicketDestination = tombolaTicketDestination == null ? AVAILABLE_DESTINATIONS[0] : tombolaTicketDestination;
    }

    /**
     * This method gets tombolaTicket of class FashionMagazine.
     * @return boolean Shows if the FashionMagazine has tombola ticket.
     */
    public boolean getTombolaTicket() {
        return tombolaTicket;
    }

    /**
     * This method gets tombolaTicketDestination of class FashionMagazine.
     * @return String This is the destination of the tombola ticket of the FashionMagazine.
     */
    public String getTombolaTicketDestination() {
        return tombolaTicketDestination;
    }

    /**
     * This method searches if the input tombola ticket destination is in the
     * array of available destinations. If it's not, creates an object of
     * class MagazineParameterException.
     * @return boolean This is the result of if destination exists or not
     * @see MagazineParameterException#tombolaTicketValidation(FashionMagazine, String)
     */
    public boolean checkTombolaTicket(){

        if((tombolaTicket && tombolaTicketDestination != null) || (tombolaTicket && tombolaTicketDestination != "")) {
            for (String availableDestination : AVAILABLE_DESTINATIONS) {
                assert tombolaTicketDestination != null;
                if (tombolaTicketDestination.equals(availableDestination)) {
                    return true;
                }
            }

            FashionMagazine fashionMagazine = new FashionMagazine(getPricePerPage(), getPages(), getIssueInThousands(),
                                                                  getName(), getHasPosters(), getNumberOfInterviews(),
                                                                  tombolaTicket, tombolaTicketDestination);
            MagazineParameterException exception = new MagazineParameterException();
            return exception.tombolaTicketValidation(fashionMagazine, "WRONG DESTINATION");
        }
        else return false;
    }

    /**
     * This method calculates destinations ratio in FashionMagazine List, calculated in percents.
     * @param fashionMagazines This is the Magazine list.
     * @return double[] This is the result array with percents by destination.
     */
    public static double[] ratioDestinations(List<FashionMagazine> fashionMagazines){
        int[] countDestinations = new int[AVAILABLE_DESTINATIONS.length];

        for(FashionMagazine fashionMagazine : fashionMagazines){
            if(fashionMagazine.tombolaTicket){
                for (int j = 0; j < AVAILABLE_DESTINATIONS.length; j++) {
                    if(fashionMagazine.tombolaTicketDestination.equals(AVAILABLE_DESTINATIONS[j])){
                        int count = countDestinations[j];
                        countDestinations[j] = count + 1;
                    }

                }
            }
        }

        int all = 0;
        for (int countDestination : countDestinations) {
            all = all + countDestination;
        }

        double[] ratio = new double[countDestinations.length];
        for (int i = 0; i < countDestinations.length; i++){
            ratio[i] = countDestinations[i]/(double)all * 100;
        }

        return ratio;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class FashionMagazinePrice implements PricePerPrintEdition {
        Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews());
        PricePerPrintEdition printPrice = magazine.getPrintEditionPrice();
        double result = printPrice.calculatePricePerEdition();

        /**
         * This method calculates the price per FashionMagazine.
         * @return double This is the total price of the FashionMagazine.
         */
        @Override
        public double calculatePricePerEdition() {
            if (tombolaTicket) {
                return (result + PRICE_TOMBOLA);
            }else {
                return result;
            }
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class FashionMagazineInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the FashionMagazine.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Has posters: %b\nNumber of interviews: %d\nTombola ticket: %b\nTicket destination: %s\n",
                    getHasPosters(), getNumberOfInterviews(), tombolaTicket, tombolaTicketDestination);
        }
    }

    /**
     * This method gets an instance of the private inner class FashionMagazinePrice.
     * @return PrintEditionInformation new object of FashionMagazinePrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new FashionMagazinePrice();
    }
    /**
     * This method gets an instance of the private inner class FashionMagazineInformation.
     * @return PrintEditionInformation new object of FashionMagazineInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new FashionMagazineInformation();
    }
}
