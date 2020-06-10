package bookStore;
/**
 * Represents a RetroPoster.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.util.List;

public class RetroPoster extends Poster {
    public static final double PRICE_EFFECT_POSTER = 3.35;

    private boolean specialEffect = false; //special retro effect

    /**
     * Default constructor for class RetroPoster.
     */
    public RetroPoster(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false);
        setSpecialEffect(false);
    }

    /**
     * Constructor with parameters for class RetroPoster.
     * @param pricePerPage This is the price per page of the RetroPoster.
     * @param pages This is the amount of pages of the RetroPoster.
     * @param issueInThousands This is the issue count in thousands of the RetroPoster.
     * @param name This is the name of the RetroPoster.
     * @param sticky Shows if the RetroPoster is sticky or not.
     * @param specialEffect Shows if the RetroPoster has special effect or not.
     */
    public RetroPoster(double pricePerPage, int pages, int issueInThousands, String name, boolean sticky, boolean specialEffect){
        super(pricePerPage, pages, issueInThousands, name, sticky);
        setSpecialEffect(specialEffect);
    }
    /**
     * Copy constructor for class RetroPoster.
     * @param retroPoster Object of class RetroPoster.
     */
    public RetroPoster(RetroPoster retroPoster){
        super(retroPoster.getPricePerPage(), retroPoster.getPages(), retroPoster.getIssueInThousands(), retroPoster.getName(), retroPoster.getSticky());
        setSpecialEffect(retroPoster.specialEffect);
    }

    /**
     * This method sets specialEffect of class RetroPoster.
     * @param specialEffect Shows if the RetroPoster has special effect or not.
     */
    public void setSpecialEffect(boolean specialEffect) {
        this.specialEffect = specialEffect;
    }

    /**
     * This method gets specialEffect of class RetroPoster.
     * @return boolean Shows if the RetroPoster has special effect or not.
     */
    public boolean getSpecialEffect() {
        return specialEffect;
    }

    /**
     * This method calculates the ratio of the number of special effect Retro Posters
     * to the number of not special effect Retro Posters.
     * @param retroPosters This is a RetroPoster list.
     * @return double This is the calculated ratio.
     */
    public static double calculateRatio(List<RetroPoster> retroPosters){
        int countSpecial = 0;
        int countNotSpecial = 0;

        if(retroPosters != null) {
            for(RetroPoster retroPoster : retroPosters){
                if (retroPoster.specialEffect) {
                    countSpecial++;
                } else {
                    countNotSpecial++;
                }
            }
        }

        if (countSpecial == 0 || countNotSpecial == 0) {
            System.out.println("Divide by zero");
            return -1;
        }
        else {
            return (double)countSpecial/(double)countNotSpecial;
        }
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class RetroPosterPrice implements PricePerPrintEdition {

        /**
         * This method calculates the price per RetroPoster.
         * @return double This is the total price of the RetroPoster.
         */
        @Override
        public double calculatePricePerEdition() {
            Poster poster = new Poster(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getSticky());
            PricePerPrintEdition printPrice = poster.getPrintEditionPrice();
            double resultPrice = printPrice.calculatePricePerEdition();

            if(specialEffect) {
                return resultPrice + PRICE_EFFECT_POSTER;
            }
            else {
                return resultPrice;
            }
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class RetroPosterInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the RetroPoster.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Sticky: %b%nRetro poster: %b%n", getSticky(), specialEffect);
        }
    }

    /**
     * This method gets an instance of the private inner class RetroPosterPrice.
     * @return new object of RetroPosterPrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new RetroPosterPrice();
    }
    /**
     * This method gets an instance of the private inner class RetroPosterInformation.
     * @return new object of RetroPosterInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new RetroPosterInformation();
    }
}

