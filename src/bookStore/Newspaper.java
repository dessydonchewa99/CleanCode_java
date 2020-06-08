package bookStore;
/**
 * Represents a Newspaper.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Newspaper extends PrintEdition{

    public static final double DECREASE_PRICE_WITH_ADS = -0.05;

    private Date printDate;
    private int adsNumber;

    /**
     * Default constructor for class Newspaper.
     */
    public Newspaper(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setPrintDate(new Date());
        setAdsNumber(0);
    }
    /**
     * Constructor with parameters for class Newspaper.
     * @param pricePerPage This is the price per page of the Newspaper.
     * @param pages This is the amount of pages of the Newspaper.
     * @param issueInThousands This is the issue count in thousands of the Newspaper.
     * @param name This is the name of the Newspaper.
     * @param printDate This is the print day of the Newspaper.
     * @param adsNumber This is the number of ads of the Newspaper.
     */
    public Newspaper(double pricePerPage, int pages, int issueInThousands, String name, Date printDate, int adsNumber){
        super(pricePerPage, pages, issueInThousands, name);
        setPrintDate(printDate);
        setAdsNumber(adsNumber);
    }
    /**
     * Copy constructor for class Newspaper.
     * @param newspaper Object of class Newspaper.
     */
    public Newspaper(Newspaper newspaper){
        super(newspaper.getPricePerPage(), newspaper.getPages(), newspaper.getIssueInThousands(), newspaper.getName());
        setPrintDate(newspaper.printDate);
        setAdsNumber(newspaper.adsNumber);
    }

    /**
     * This method sets printDate of Newspaper class.
     * @param printDate This is the print day of the Newspaper.
     */
    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }
    /**
     * This method sets adsNumber of Newspaper class.
     * @param adsNumber This is the number of ads of the Newspaper.
     */
    public void setAdsNumber(int adsNumber) {
        this.adsNumber = (adsNumber < 0) ? 0 : adsNumber;
    }

    /**
     * This method gets printDate of class Newspaper.
     * @return Date This is the print day of the Newspaper.
     */
    public Date getPrintDate() {
        return printDate;
    }
    /**
     * This method gets adsNumber of class Newspaper.
     * @return int This is the number of ads of the Newspaper.
     */
    public int getAdsNumber() {
        return adsNumber;
    }

    /**
     * This method calculates and returns the total amount
     * of ads in a Newspaper list.
     * @param newspapers This is the input parameter Newspaper list.
     * @return int This is the calculated amount of ads.
     */
    public static int totalAds(List<Newspaper> newspapers){
        int ads = 0;
        for(Newspaper newspaper : newspapers){
            ads += newspaper.adsNumber;
        }
        return ads;
    }

    /**
     * This method searches for Newspaper after exact Date.
     * The method returns a Newspaper list with Date after the given one.
     * @param newspapers This is the input parameter Newspaper list.
     * @param date This is the starting point Date.
     * @return Date list This is the output Newspaper list.
     */
    public static List<Date> afterDate(List<Newspaper> newspapers, Date date){
        List<Date> dates = new ArrayList<>();

        for(Newspaper newspaper : newspapers){
            if(newspaper.printDate.compareTo(date) > 0){
                dates.add(newspaper.printDate);
            }
        }

        return dates;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class NewspaperPrice implements PricePerPrintEdition{

        /**
         * This method calculates the price per Newspaper.
         * @return double This is the total price of the Newspaper.
         */
        @Override
        public double calculatePricePerEdition(){
            double totalPrice = calculatePrintPrice() + (getAdsNumber()*(DECREASE_PRICE_WITH_ADS));
            return totalPrice < 0.0 ? 0.0 : totalPrice; // if the price reaches below zero, it means it's free
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class NewspaperInformation implements PrintEditionInformation{

        /**
         * This method prints formatted information of the Newspaper.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.print("Date: ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println(formatter.format(printDate));
            System.out.printf("Ads number: %d%n", adsNumber);
        }
    }

    /**
     * This method gets an instance of the private inner class NewspaperPrice.
     * @return new object of NewspaperPrice class
     */
    public PricePerPrintEdition getPrintEditionPrice() {
        return new NewspaperPrice();
    }
    /**
     * This method gets an instance of the private inner class NewspaperInformation.
     * @return new object of NewspaperInformation class
     */
    public PrintEditionInformation getPrintInformation() {
        return new NewspaperInformation();
    }
}

