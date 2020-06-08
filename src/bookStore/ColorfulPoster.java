package bookStore;
/**
 * Represents a ColorfulPoster.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public class ColorfulPoster extends Poster {
    public static final double PRICE_SHARP_COLORS = 5.55;
    public static final int CLIENT_NUMBER_DISCOUNT = 10;
    public static final int DISCOUNT = 2; //it means 50%

    private static int order = 0;

    private boolean sharpColors = false;

    /**
     * Default constructor for class ColorfulPoster.
     */
    public ColorfulPoster(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false);
        setSharpColors(false);
        order++;
    }
    /**
     * Constructor with parameters for class ColorfulPoster.
     * @param pricePerPage This is the price per page of the ColorfulPoster.
     * @param pages This is the amount of pages of the ColorfulPoster.
     * @param issueInThousands This is the issue count in thousands of the ColorfulPoster.
     * @param name This is the name of the ColorfulPoster.
     * @param sticky Shows if the ColorfulPoster is sticky or not.
     * @param sharpColors Shows if the ColorfulPoster has sharp colors or not.
     */
    public ColorfulPoster(double pricePerPage, int pages, int issueInThousands, String name, boolean sticky, boolean sharpColors){
        super(pricePerPage, pages, issueInThousands, name, sticky);
        setSharpColors(sharpColors);
        order++;
    }
    /**
     * Copy constructor for class ColorfulPoster.
     * @param colorfulPoster Object of class ColorfulPoster.
     */
    public ColorfulPoster(ColorfulPoster colorfulPoster){
        super(colorfulPoster.getPricePerPage(), colorfulPoster.getPages(), colorfulPoster.getIssueInThousands(),
                colorfulPoster.getName(), colorfulPoster.getSticky());
        setSharpColors(colorfulPoster.sharpColors);
        order++;
    }

    /**
     * This method sets sharpColors of class ColorfulPoster.
     * @param sharpColors Shows if the ColorfulPoster has sharp colors or not.
     */
    public void setSharpColors(boolean sharpColors) {
        this.sharpColors = sharpColors;
    }

    /**
     * This method gets sharpColors of class ColorfulPoster.
     * @return boolean Shows if the ColorfulPoster has sharp colors or not.
     */
    public boolean getSharpColors(){
        return this.sharpColors;
    }

    /**
     * This method gets number of static variable order.
     * @return int This is a static variable showing unique number of the order.
     */
    public static int getOrder(){
        return order;
    }
    /**
     * This method calculates number of clients that have received discount.
     */
    public void viewNumberDiscounts(){
        System.out.printf("Discounts made: %d\n", order/CLIENT_NUMBER_DISCOUNT);
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class ColorfulPosterPrice implements PricePerPrintEdition {

        /**
         * This method calculates the price per ColorfulPoster.
         * @return double This is the total price of the ColorfulPoster.
         */
        @Override
        public double calculatePricePerEdition() {
            Poster poster = new Poster(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getSticky());
            PricePerPrintEdition printPrice = poster.getPrintEditionPrice();
            double result = printPrice.calculatePricePerEdition();
            if(sharpColors) {
                if(order % CLIENT_NUMBER_DISCOUNT == 0) {
                    return (result + PRICE_SHARP_COLORS)/DISCOUNT;
                } else {
                    return result + PRICE_SHARP_COLORS;
                }
            }else {
                if(order % CLIENT_NUMBER_DISCOUNT == 0) {
                    return result/DISCOUNT;
                } else {
                    return result;
                }
            }

        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class ColorfulPosterInformation implements PrintEditionInformation {
        /**
         * This method prints formatted information of the ColorfulPoster.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());

            System.out.printf("Sticky: %b%nSharp colors: %b%n", getSticky(), sharpColors);
        }
    }

    /**
     * This method gets an instance of the private inner class ColorfulPosterPrice.
     * @return new object of ColorfulPosterPrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new ColorfulPosterPrice();
    }
    /**
     * This method gets an instance of the private inner class ColorfulPosterInformation.
     * @return new object of ColorfulPosterInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new ColorfulPosterInformation();
    }
}
