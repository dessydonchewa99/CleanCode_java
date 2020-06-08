package bookStore;
/**
 * Represents a Magazine.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Magazine extends PrintEdition {

    public static final double RAISE_PRICE_WITH_POSTERS = 1.50;

    private boolean hasPosters;
    private int numberOfInterviews;

    /**
     * Default constructor for class Magazine.
     */
    public Magazine() {
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setHasPosters(false);
        setNumberOfInterviews(0);
    }

    /**
     * Constructor with parameters for class Magazine.
     * @param pricePerPage This is the price per page of the Magazine.
     * @param pages This is the amount of pages of the Magazine.
     * @param issueInThousands This is the issue count in thousands of the Magazine.
     * @param name This is the name of the Magazine.
     * @param hasPosters Shows if the Magazine has posters.
     * @param numberOfInterviews This is the number of interviews of the Magazine.
     */
    public Magazine(double pricePerPage, int pages, int issueInThousands, String name, boolean hasPosters, int numberOfInterviews) {
        super(pricePerPage, pages, issueInThousands, name);
        setHasPosters(hasPosters);
        setNumberOfInterviews(numberOfInterviews);
    }
    /**
     * Copy constructor for class Magazine.
     * @param magazine Object of class Magazine.
     */
    public Magazine(Magazine magazine) {
        super(magazine.getPricePerPage(), magazine.getPages(), magazine.getIssueInThousands(), magazine.getName());
        setHasPosters(magazine.hasPosters);
        setNumberOfInterviews(magazine.numberOfInterviews);
    }

    /**
     * This method sets hasPosters of class Magazine.
     * @param hasPosters Shows if the Magazine has posters.
     */
    public final void setHasPosters(boolean hasPosters) {
        this.hasPosters = hasPosters;
    }
    /**
     * This method sets numberOfInterviews of class Magazine.
     * @param numberOfInterviews This is the number of interviews of the Magazine.
     */
    public final void setNumberOfInterviews(int numberOfInterviews) {
        this.numberOfInterviews = numberOfInterviews < 0 ? 0 : numberOfInterviews;
    }

    /**
     * This method gets hasPosters of class Magazine.
     * @return boolean Shows if the Magazine has posters.
     */
    public final boolean getHasPosters(){
        return hasPosters;
    }
    /**
     * This method gets numberOfInterviews of class Magazine.
     * @return int This is the number of interviews of the Magazine.
    */
    public final int getNumberOfInterviews() {
        return numberOfInterviews;
    }

    /**
     * This method searches for Magazines with number of interviews in bounds
     * and returns a new Magazine list with interviews in that bound.
     * @param magazines This is the input parameter Magazine list.
     * @param leftBound This is the left bound of numberOfInterviews.
     * @param rightBound This is the right bound of numberOfInterviews.
     * @return Magazine list This is the output Magazine list.
     */
    public static List<Magazine> intervalOfInterviews(List<Magazine> magazines, int leftBound, int rightBound){
        List<Magazine> result = new ArrayList<>();
        
        for(Magazine magazine : magazines){
            if(magazine.numberOfInterviews >= leftBound && magazine.numberOfInterviews <= rightBound) {
                result.add(magazine);
            }
        }
        return result;
    }
    /**
     * This method searches and returns the first Magazine with exact parameters
     * of boolean variable hasPosters and the count of numberOfInterviews.
     * @param magazines This is the input parameter Magazine list.
     * @param hasPosters Shows if the Magazine has posters.
     * @param numberOfInterviews This is the number of interviews of the Magazine.
     * @return Magazine This is the first Magazine with this interface.
     */
    public static Magazine findSpecialMagazine(List<Magazine> magazines, boolean hasPosters, int numberOfInterviews){
        for(Magazine magazine : magazines){
            if(magazine.hasPosters == hasPosters && magazine.numberOfInterviews == numberOfInterviews) {
                return magazine;
            }
        }
        return null;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class MagazinePrice implements PricePerPrintEdition {

        /**
         * This method calculates the price per Magazine.
         * @return double This is the total price of the Magazine.
         */
        @Override
        public double calculatePricePerEdition() {
            if (hasPosters) {
                return (calculatePrintPrice() + numberOfInterviews + RAISE_PRICE_WITH_POSTERS);
            }else {
                return (calculatePrintPrice() + numberOfInterviews);
            }
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class MagazineInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the Magazine.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Has posters: %b%nNumber of interviews: %d%n",
                    hasPosters, numberOfInterviews);
        }
    }

    /**
     * This method gets an instance of the private inner class MagazinePrice.
     * @return new object of MagazinePrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new MagazinePrice();
    }
    /**
     * This method gets an instance of the private inner class MagazineInformation.
     * @return new object of MagazineInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new MagazineInformation();
    }
}

