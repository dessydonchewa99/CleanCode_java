package bookStore;

public class Poster extends PrintEdition {
    public static final double PRICE_STICKY_POSTER = 1.75;

    private boolean sticky = false;

    public Poster() {
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setSticky(false);
    }

    /**
     *
     * @param pricePerPage
     * @param pages
     * @param issueInThousands
     * @param name
     * @param sticky
     */
    public Poster(double pricePerPage, int pages, int issueInThousands, String name, boolean sticky) {
        super(pricePerPage, pages, issueInThousands, name);
        setSticky(sticky);
    }

    /**
     *
     * @param poster
     */
    public Poster(Poster poster) {
        super(poster.getPricePerPage(), poster.getPages(), poster.getIssueInThousands(), poster.getName());
        setSticky(poster.sticky);
    }

    public final void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public final boolean getSticky() {
        return sticky;
    }

    private class PosterPrice implements PricePerPrintEdition {

        @Override
        public double calculatePricePerEdition() {
            if(sticky) {
                return calculatePrintPrice() + PRICE_STICKY_POSTER;
            }
            else return calculatePrintPrice();
        }
    }

    private class PosterInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Sticky: %b%n", sticky);
        }
    }

    public final PricePerPrintEdition getPosterPrice(){
        return new PosterPrice();
    }

}

