package bookStore;
/**
 * Represents a PrintEdition.
 * @author Desislava Dontcheva
 * @version 1.0
 */
public class PrintEdition {

    public static final double DEFAULT_PRICE_PER_PAGE = 0.01;
    public static final int MIN_PAGES = 1;
    public static final int MIN_ISSUE = 1;

    private double pricePerPage;
    private int pages;
    private int issueInThousands;
    private String name;

    /**
     * Default constructor for class PrintEdition.
     */
    public PrintEdition(){
        setPricePerPage(DEFAULT_PRICE_PER_PAGE);
        setPages(MIN_PAGES);
        setIssueInThousands(MIN_ISSUE);
        setName(null);
    }
    /**
     * Constructor with parameters for class PrintEdition.
     * @param pricePerPage This is the price per page of the PrintEdition.
     * @param pages This is the amount of pages of the PrintEdition.
     * @param issueInThousands This is the issue count in thousands of the PrintEdition.
     * @param name This is the name of the PrintEdition.
     */
    public PrintEdition(double pricePerPage, int pages, int issueInThousands, String name){
        setPricePerPage(pricePerPage);
        setPages(pages);
        setIssueInThousands(issueInThousands);
        setName(name);
    }
    /**
     * Copy constructor for class PrintEdition.
     * @param printEdition Object of class PrintEdition.
     */
    public PrintEdition(PrintEdition printEdition){
        setPricePerPage(printEdition.pricePerPage);
        setPages(printEdition.pages);
        setIssueInThousands(printEdition.issueInThousands);
        setName(printEdition.name);
    }

    /**
     * This method sets pricePerPage of class PrintEdition.
     * @param pricePerPage This is the pricePerPage of the PrintEdition.
     */
    public final void setPricePerPage(double pricePerPage) {
        this.pricePerPage = pricePerPage < 0 ? DEFAULT_PRICE_PER_PAGE : pricePerPage;
    }
    /**
     * This method sets pages of class PrintEdition.
     * @param pages This is the amount of pages of the PrintEdition.
     */
    public final void setPages(int pages) {
        this.pages = pages < 0 ? MIN_PAGES : pages;
    }
    /**
     * This method sets issueInThousands of class PrintEdition.
     * @param issueInThousands This is the issue in thousands of the PrintEdition.
     */
    public final void setIssueInThousands(int issueInThousands) {
        this.issueInThousands = issueInThousands < 0 ? MIN_ISSUE : issueInThousands;
    }
    /**
     * This method sets name of class PrintEdition.
     * @param name This is the name of the PrintEdition.
     */
    public final void setName(String name) {
        this.name = name == null ? "DEFAULT PRINT EDITION NAME" : name;
    }

    /**
     * This method gets pricePerPage of class PrintEdition.
     * @return double This is the pricePerPage of the PrintEdition.
     */
    public final double getPricePerPage() {
        return pricePerPage;
    }
    /**
     * This method gets pages of class PrintEdition.
     * @return int This is the amount of pages of the PrintEdition.
     */
    public final int getPages() {
        return pages;
    }
    /**
     * This method gets issueInThousands of class PrintEdition.
     * @return int This is the issue in thousands of the PrintEdition.
     */
    public final int getIssueInThousands() {
        return issueInThousands;
    }
    /**
     * This method gets name of class PrintEdition.
     * @return String This is the name of the PrintEdition.
     */
    public String getName() {
        return name;
    }

    /**
     * This method calculates the total price of the PrintEdition.
     * @return double This is the calculated price.
     */
    public double calculatePrintPrice() {
        return pricePerPage*pages;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class PrintEditionPrice implements PricePerPrintEdition {

        /**
         * This method calculates the price per PrintEdition.
         * @return double This is the total price of the PrintEdition.
         */
        @Override
        public double calculatePricePerEdition() {
            return calculatePrintPrice();
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class PrintInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the Print edition.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    pricePerPage, pages, issueInThousands, name);
        }
    }

    /**
     * This method gets an instance of the private inner class PrintEditionPrice.
     * @return new object of PrintEditionPrice class
     */
   public PricePerPrintEdition getPrintEditionPrice(){
        return new PrintEditionPrice();
    }
    /**
     * This method gets an instance of the private inner class PrintInformation.
     * @return new object of PrintInformation class
     */
    public PrintEditionInformation getPrintInformation(){
        return new PrintInformation();
    }
}

