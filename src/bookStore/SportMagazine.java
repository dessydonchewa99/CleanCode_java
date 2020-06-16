package bookStore;
/**
 * Represents a SportMagazine.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportMagazine extends Magazine {

    private static final double FOOTBALL_HAT_PRICE = 9.0;
    private static final double VOLLEYBALL_HAT_PRICE = 7.0;
    private final char[] CODES = {'F', 'V'}; // Code should starts with F(Football) or V(Volleyball) fan hat

    private boolean bonusHat; // not every edition should make bonus hats with Magazine
    private String codeOfHat;

    private double priceForHat;

    /**
     * Default constructor for class SportMagazine.
     */
    public SportMagazine(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false, 0);
        setBonusHat(false);
        setCodeOfHat(null);
        priceForHat = 0;
    }
    /**
     * Constructor with parameters for class SportMagazine.
     * @param pricePerPage This is the price per page of the SportMagazine.
     * @param pages This is the amount of pages of the SportMagazine.
     * @param issueInThousands This is the issue count in thousands of the SportMagazine.
     * @param name This is the name of the SportMagazine.
     * @param hasPosters Shows if the SportMagazine has posters.
     * @param numberOfInterviews This is the number of interviews of the SportMagazine.
     * @param bonusHat Shows if the SportMagazine has bonus hat.
     * @param codeOfHat This is the code of the bonus hat.
     */
    public SportMagazine(double pricePerPage, int pages, int issueInThousands, String name, boolean hasPosters,
                         int numberOfInterviews, boolean bonusHat, String codeOfHat){
        super(pricePerPage, pages, issueInThousands, name, hasPosters, numberOfInterviews);
        setBonusHat(bonusHat);
        setCodeOfHat(codeOfHat);
        if(bonusHat) priceForHat = calculatePriceWithHat();
        else priceForHat = 0;
    }
    /**
     * Copy constructor for class SportMagazine.
     * @param sportMagazine Object of class SportMagazine.
     */
    public SportMagazine(SportMagazine sportMagazine){
        super(sportMagazine.getPricePerPage(), sportMagazine.getPages(), sportMagazine.getIssueInThousands(),
                sportMagazine.getName(), sportMagazine.getHasPosters(), sportMagazine.getNumberOfInterviews());
        setBonusHat(sportMagazine.bonusHat);
        setCodeOfHat(sportMagazine.codeOfHat);
        if(sportMagazine.bonusHat) priceForHat = calculatePriceWithHat();
        else priceForHat = 0;
    }

    /**
     * This method gets bonusHat of class SportMagazine.
     * @return boolean Shows if the SportMagazine has bonus hat.
     */
    public boolean getBonusHat(){
        return bonusHat;
    }
    /**
     * This method gets codeOfHat of class SportMagazine.
     * @return String This is the code of the bonus hat.
     */
    public String getCodeOfHat() {
        return codeOfHat;
    }
    /**
     * This method gets priceForHat of class SportMagazine.
     * @return double This is the total price of the SportMagazine with hat.
     */
    public double getPriceForHat() {
        return calculatePriceWithHat();
    }

    /**
     * This method sets codeOfHat of class SportMagazine.
     * @param codeOfHat This is the code of the bonus hat.
     */
    public void setCodeOfHat(String codeOfHat) {
        this.codeOfHat = codeOfHat;
    }

    /**
     * This method sets bonusHat of class SportMagazine.
     * @param bonusHat Shows if the SportMagazine has bonus hat.
     */
    public void setBonusHat(boolean bonusHat) {
        this.bonusHat = bonusHat;
    }

    /**
     * This method prints all SportMagazine with bonus hat in SportMagazine list.
     * @param sportMagazines This is the Magazine list.
     */
    public static void showAllBonusHat(List<SportMagazine> sportMagazines){
        for(SportMagazine sportMagazine : sportMagazines){
            if(sportMagazine.bonusHat)
                sportMagazine.getPrintInformation().printEditionInformation();
        }
    }
    /**
     * This method prints all SportMagazine with bonus hat sorted by code in SportMagazine list.
     * @param sportMagazines This is the Magazine list.
     */
    public static void printSortedCodes(List<SportMagazine> sportMagazines){
        List<String> codes = new ArrayList<>();
        for (SportMagazine sportMagazine : sportMagazines){
            if(sportMagazine.bonusHat) {
                codes.add(sportMagazine.codeOfHat);
            }
        }

        java.util.Collections.sort(codes);

        for(int i = 0; i < codes.size(); i++){
            System.out.println(codes.get(i));
        }
    }
    /**
     * This method calculate the total price of the SportMagazine with hat.
     * @return double This is the total price of the SportMagazine with hat.
     * @see MagazineParameterException#hatCodeValidation(SportMagazine, String) 
     */
    public double calculatePriceWithHat(){
        Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(),
                                         getName(), getHasPosters(), getNumberOfInterviews());
        PricePerPrintEdition pricePerPrintEdition = magazine.getPrintEditionPrice();

        assert codeOfHat != null;

        char[] typeHat = new char[1];
        typeHat[0] = codeOfHat.charAt(0);

        if(typeHat[0] == CODES[0]){
            priceForHat = FOOTBALL_HAT_PRICE;
            return pricePerPrintEdition.calculatePricePerEdition() + priceForHat;
        } else if(typeHat[0] == CODES[1]){
            priceForHat = VOLLEYBALL_HAT_PRICE;
            return pricePerPrintEdition.calculatePricePerEdition() + priceForHat;
        } else {
            SportMagazine sportMagazine = new SportMagazine(getPricePerPage(), getPages(), getIssueInThousands(),
                                                            getName(), getHasPosters(), getNumberOfInterviews(),
                                                            bonusHat, codeOfHat);

            MagazineParameterException exception = new MagazineParameterException();
            exception.hatCodeValidation(sportMagazine, "WRONG CODE");
        }

        return pricePerPrintEdition.calculatePricePerEdition() + priceForHat;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class SportMagazinePrice implements PricePerPrintEdition{

        /**
         * This method calculates the price per SportMagazine.
         * @return double This is the total price of the SportMagazine.
         */
        @Override
        public double calculatePricePerEdition() {
            if(bonusHat) {
                return calculatePriceWithHat();
            } else{
                Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews());
                PricePerPrintEdition printPrice = magazine.getPrintEditionPrice();
                return printPrice.calculatePricePerEdition();
            }
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class SportMagazineInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the SportMagazine.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Has posters: %b%nNumber of interviews: %d%nBonusHat: %b%nCode of hat: %s%n",
                    getHasPosters(), getNumberOfInterviews(), bonusHat, codeOfHat);
        }
    }

    /**
     * This method gets an instance of the private inner class SportMagazinePrice.
     * @return PricePerPrintEdition new object of SportMagazinePrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new SportMagazinePrice();
    }
    /**
     * This method gets an instance of the private inner class SportMagazineInformation.
     * @return PrintEditionInformation new object of SportMagazineInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new SportMagazineInformation();
    }

    /**
     * This method gets a code at index.
     * @param index This is the index of an array.
     * @return char This is the code at the index.
     */
    public char getCodes(int index) {
        return CODES[index];
    }
}
