package bookStore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Newspaper extends PrintEdition{

    public static final double DECREASE_PRICE_WITH_ADS = -0.05;

    private Date printDate;
    private int adsNumber;

    public Newspaper(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setPrintDate(new Date());
        setAdsNumber(0);
    }
    public Newspaper(double pricePerPage, int pages, int issueInThousands, String name, Date printDate, int adsNumber){
        super(pricePerPage, pages, issueInThousands, name);
        setPrintDate(printDate);
        setAdsNumber(adsNumber);
    }
    public Newspaper(Newspaper newspaper){
        super(newspaper.getPricePerPage(), newspaper.getPages(), newspaper.getIssueInThousands(), newspaper.getName());
        setPrintDate(newspaper.printDate);
        setAdsNumber(newspaper.adsNumber);
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }
    public void setAdsNumber(int adsNumber) {
        this.adsNumber = (adsNumber < 0) ? 0 : adsNumber;
    }

    public Date getPrintDate() {
        return printDate;
    }
    public int getAdsNumber() {
        return adsNumber;
    }

    public int totalAds(List<Newspaper> newspapers){
        int ads = 0;
        for(Newspaper newspaper : newspapers){
            ads += newspaper.adsNumber;
        }
        return ads;
    }
    public List<Date> afterDate(List<Newspaper> newspapers, Date date){
        List<Date> dates = null;
        int count = 0;

        for(Newspaper newspaper : newspapers){
            if(newspaper.printDate.compareTo(date) > 0){
                assert dates != null;
                dates.set(count, newspaper.printDate);
            }
        }

        return dates;
    }

    private class NewspaperPrice implements PricePerPrintEdition{

        @Override
        public double calculatePricePerEdition(){
            return calculatePrintPrice() + (getAdsNumber()*(DECREASE_PRICE_WITH_ADS));
        }
    }

    private class NewspaperInformation implements PrintEditionInformation{

        @Override
        public void printEditionInformation() {
            System.out.print("Date: ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println(formatter.format(printDate));
            System.out.printf("Ads number: %d%n", adsNumber);
        }
    }
}

