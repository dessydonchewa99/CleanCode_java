package bookStore;

import java.util.ArrayList;
import java.util.List;

public class Magazine extends PrintEdition {

    public static final double RAISE_PRICE_WITH_POSTERS = 1.50;

    private boolean hasPosters;
    private int numberOfInterviews;

    public Magazine() {
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setHasPosters(false);
        setNumberOfInterviews(0);
    }
    public Magazine(double pricePerPage, int pages, int issueInThousands, String name, boolean hasPosters, int numberOfInterviews) {
        super(pricePerPage, pages, issueInThousands, name);
        setHasPosters(hasPosters);
        setNumberOfInterviews(numberOfInterviews);
    }
    public Magazine(Magazine magazine) {
        super(magazine.getPricePerPage(), magazine.getPages(), magazine.getIssueInThousands(), magazine.getName());
        setHasPosters(magazine.hasPosters);
        setNumberOfInterviews(magazine.numberOfInterviews);
    }

    public final void setHasPosters(boolean hasPosters) {
        this.hasPosters = hasPosters;
    }
    public final void setNumberOfInterviews(int numberOfInterviews) {
        this.numberOfInterviews = numberOfInterviews < 0 ? 0 : numberOfInterviews;
    }

    public final boolean getHasPosters(){
        return hasPosters;
    }
    public final int getNumberOfInterviews() {
        return numberOfInterviews;
    }
    
    public static List<Magazine> intervalOfInterviews(List<Magazine> magazines, int leftBound, int rightBound){
        List<Magazine> result = new ArrayList<>();
        
        for(Magazine magazine : magazines){
            if(magazine.numberOfInterviews >= leftBound && magazine.numberOfInterviews <= rightBound) {
                result.add(magazine);
            }
        }
        return result;
    }

    public static Magazine findSpecialMagazine(List<Magazine> magazines, boolean hasPosters, int numberOfInterviews){
        for(Magazine magazine : magazines){
            if(magazine.hasPosters == hasPosters && magazine.numberOfInterviews == numberOfInterviews) {
                return magazine;
            }
        }
        return null;
    }

    private class MagazinePrice implements PricePerPrintEdition {

        @Override
        public double calculatePricePerEdition() {
            if (hasPosters) {
                return (calculatePrintPrice() + numberOfInterviews + RAISE_PRICE_WITH_POSTERS);
            }else {
                return (calculatePrintPrice() + numberOfInterviews);
            }
        }
    }

    private class MagazineInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Has posters: %b%nNumber of interviews: %d%n",
                    hasPosters, numberOfInterviews);
        }
    }

    public PricePerPrintEdition getPrintEditionPrice() {
        return new MagazinePrice();
    }

    public PrintEditionInformation getPrintInformation() {
        return new MagazineInformation();
    }
}

