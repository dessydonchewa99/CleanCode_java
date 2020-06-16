package bookStore;
/**
 * Represents a Comic.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Comic extends PrintEdition {

    public static final double RAISE_PICTURESONLY_SPECIALFONT = 4.50;
    public static final double RAISE_HASSPECIALFONT = 3.50;
    public static final double RAISE_PICTURESONLY = 2.50;

    private boolean picturesOnly = false;
    private boolean hasSpecialFont = false;

    /**
     * Default constructor for class Comic.
     */
    public Comic(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setPicturesOnly(false);
        setHasSpecialFont(false);
    }
    /**
     * Constructor with parameters for class Comic.
     * @param pricePerPage This is the price per page of the Comic.
     * @param pages This is the amount of pages of the Comic.
     * @param issueInThousands This is the issue count in thousands of the Comic.
     * @param name This is the name of the Comic.
     * @param picturesOnly This shows if the Comic has only pictures or not. 
     * @param hasSpecialFont This shows if the Comic has special font or not.
     */
    public Comic(double pricePerPage, int pages, int issueInThousands, String name, boolean picturesOnly, boolean hasSpecialFont){
        super(pricePerPage, pages, issueInThousands, name);
        setPicturesOnly(picturesOnly);
        setHasSpecialFont(hasSpecialFont);
    }
    /**
     * Copy constructor for class Comic.
     * @param comic Object of class Comic.
     */
    public Comic(Comic comic){
        super(comic.getPricePerPage(), comic.getPages(), comic.getIssueInThousands(), comic.getName());
        setPicturesOnly(picturesOnly);
        setHasSpecialFont(hasSpecialFont);
    }

    /**
     * This method sets picturesOnly of class Comic.
     * @param picturesOnly This shows if the Comic has only pictures or not. 
     */
    public void setPicturesOnly(boolean picturesOnly) {
        this.picturesOnly = picturesOnly;
    }
    /**
     * This method sets hasSpecialFont of class Comic.
     * @param hasSpecialFont This shows if the Comic has special font or not. 
     */
    public void setHasSpecialFont(boolean hasSpecialFont) {
        this.hasSpecialFont = hasSpecialFont;
    }

    /**
     * This method gets picturesOnly of class Comic.
     * @return boolean This shows if the Comic has only pictures or not.
     */
    public boolean getPicturesOnly(){
        return picturesOnly;
    }
    /**
     * This method gets hasSpecialFont of class Comic.
     * @return boolean This shows if the Comic has special font or not.
     */
    public boolean getHasSpecialFont(){
        return hasSpecialFont;
    }

    /**
     * This method searches by criteria of the variables picturesOnly
     * and hasSpecialFont condition in the Comic list and returns
     * a new Comic list full of the statements of the boolean variables.
     * @param comics This is the input parameter Comic list.
     * @param picturesOnly This shows if the Comic has only pictures or not.
     * @param hasSpecialFont This shows if the Comic has special font or not.
     * @return Comic list This is the output Comic list.
     */
    public static List<Comic> searchByCriteria(List<Comic> comics, boolean picturesOnly, boolean hasSpecialFont){
        List<Comic> result = new ArrayList<>();
        for (Comic comic : comics){
            if(comic.hasSpecialFont == hasSpecialFont && comic.picturesOnly == picturesOnly) {
                result.add(comic);
            }
        }
        return result;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class ComicsPrice implements PricePerPrintEdition{

        /**
         * This method calculates the price per Comic.
         * @return double This is the total price of the Comic.
         */
        @Override
        public double calculatePricePerEdition(){
            if (hasSpecialFont && picturesOnly) {
                return calculatePrintPrice() * RAISE_PICTURESONLY_SPECIALFONT;
            }
            else if (hasSpecialFont && !picturesOnly) {
                return calculatePrintPrice() * RAISE_HASSPECIALFONT;
            }
            else if (!hasSpecialFont && picturesOnly) {
                return calculatePrintPrice() * RAISE_PICTURESONLY;
            }
            else if (!hasSpecialFont && !picturesOnly) {
                return calculatePrintPrice();
            }
            else return 0;
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class ComicsInformation implements PrintEditionInformation{

        /**
         * This method prints formatted information of the Comic.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Pictures only: %b%nHas special font: %b%n",
                    picturesOnly, hasSpecialFont);
        }
    }
    /**
     * This method gets an instance of the private inner class ComicsPrice.
     * @return PricePerPrintEdition new object of ComicsPrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new ComicsPrice();
    }
    /**
     * This method gets an instance of the private inner class ComicsInformation.
     * @return PrintEditionInformation new object of ComicsInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new ComicsInformation();
    }
}

