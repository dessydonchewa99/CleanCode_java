package bookStore;
/**
 * Represents a Poster.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public class Poster extends PrintEdition {
    public static final double PRICE_STICKY_POSTER = 1.75;

    private boolean sticky = false;

    /**
     * Default constructor for class Poster.
     */
    public Poster() {
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setSticky(false);
    }
    /**
     * Constructor with parameters for class Poster.
     * @param pricePerPage This is the price per page of the Poster.
     * @param pages This is the amount of pages of the Poster.
     * @param issueInThousands This is the issue count in thousands of the Poster.
     * @param name This is the name of the Poster.
     * @param sticky Shows if the Poster is sticky or not.
     */
    public Poster(double pricePerPage, int pages, int issueInThousands, String name, boolean sticky) {
        super(pricePerPage, pages, issueInThousands, name);
        setSticky(sticky);
    }
    /**
     * Copy constructor for class Poster.
     * @param poster Object of class Poster.
     */
    public Poster(Poster poster) {
        super(poster.getPricePerPage(), poster.getPages(), poster.getIssueInThousands(), poster.getName());
        setSticky(poster.sticky);
    }

    /**
     * This method sets sticky of class Poster.
     * @param sticky Shows if the Poster is sticky or not.
     */
    public final void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    /**
     * This method gets sticky  of class Poster.
     * @return boolean Shows if the Poster is sticky or not.
     */
    public final boolean getSticky() {
        return sticky;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class PosterPrice implements PricePerPrintEdition {

        /**
         * This method calculates the price per Poster.
         * @return double This is the total price of the Poster.
         */
        @Override
        public double calculatePricePerEdition() {
            if(sticky) {
                return calculatePrintPrice() + PRICE_STICKY_POSTER;
            }
            else {
                return calculatePrintPrice();
            }
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class PosterInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the Poster.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Sticky: %b%n", sticky);
        }
    }

    /**
     * This method gets an instance of the private inner class PosterPrice.
     * @return new object of PosterPrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new PosterPrice();
    }
    /**
     * This method gets an instance of the private inner class PosterInformation.
     * @return new object of PosterInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new PosterInformation();
    }

}

