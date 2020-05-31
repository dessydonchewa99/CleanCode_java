package bookStore;

import exceptions.*;

import java.util.Arrays;
import java.util.List;

public class FashionMagazine extends Magazine {

    public static final String[] AVAILABLE_DESTINATIONS = {"ITALY", "GERMANY", "FRANCE", "UK", "USA"};
    public static final double PRICE_TOMBOLA = 3.15;

    private boolean tombolaTicket; // not every edition should have tombola tickets
    private String tombolaTicketDestination;

    public FashionMagazine(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false, 0);
        setTombolaTicket(false);
        setTombolaTicketDestination(null);
    }
    public FashionMagazine(double pricePerPage, int pages, int issueInThousands, String name, boolean hasPosters,
                           int numberOfInterviews, boolean tombolaTicket, String tombolaTicketDestination){
        super(pricePerPage, pages, issueInThousands, name, hasPosters, numberOfInterviews);
        setTombolaTicket(tombolaTicket);
        if(tombolaTicket) setTombolaTicketDestination(tombolaTicketDestination);
        else setTombolaTicketDestination(null);
    }
    public FashionMagazine(FashionMagazine fashionMagazine){
        super(fashionMagazine.getPricePerPage(), fashionMagazine.getPages(), fashionMagazine.getIssueInThousands(),
                fashionMagazine.getName(), fashionMagazine.getHasPosters(), fashionMagazine.getNumberOfInterviews());
        setTombolaTicket(tombolaTicket);
        if(tombolaTicket) setTombolaTicketDestination(tombolaTicketDestination);
        else setTombolaTicketDestination(null);
    }

    public void setTombolaTicket(boolean tombolaTicket) {
        this.tombolaTicket = tombolaTicket;
    }
    public void setTombolaTicketDestination(String tombolaTicketDestination) {
        this.tombolaTicketDestination = tombolaTicketDestination == null ? AVAILABLE_DESTINATIONS[0] : tombolaTicketDestination;
    }

    public boolean getTombolaTicket() {
        return tombolaTicket;
    }
    public String getTombolaTicketDestination() {
        return tombolaTicketDestination;
    }

    public void searchTombolaTicket(){
        Magazine magazine = new Magazine();

        magazine.setPricePerPage(getPricePerPage());
        magazine.setPricePerPage(getPages());
        magazine.setIssueInThousands(getIssueInThousands());
        magazine.setName(getName());
        magazine.setHasPosters(getHasPosters());
        magazine.setNumberOfInterviews(getNumberOfInterviews());

        PricePerPrintEdition pricePerPrintEdition = magazine.getPrintEditionPrice();

        boolean flag = false;
        if((tombolaTicket && tombolaTicketDestination != null) || (tombolaTicket && tombolaTicketDestination != "")) {
            for (int i = 0; i < AVAILABLE_DESTINATIONS.length; i++) {
                assert tombolaTicketDestination != null;
                if (tombolaTicketDestination.equals(AVAILABLE_DESTINATIONS[i])) {
                    flag = true;
                    break;
                }
            }

            if(!flag){
                FashionMagazine fashionMagazine = new FashionMagazine
                        (getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews(),
                                tombolaTicket, tombolaTicketDestination);
                MagazineParameterException exception = new MagazineParameterException();
                exception.tombolaTicketValidation(fashionMagazine, "WRONG DESTINATION");
            }
        }
    }

    public static double[] ratioDestinations(List<FashionMagazine> fashionMagazines){
        int[] countDestinations = new int[AVAILABLE_DESTINATIONS.length];

        for(FashionMagazine fashionMagazine : fashionMagazines){
            if(fashionMagazine.tombolaTicket){
                for (int j = 0; j < AVAILABLE_DESTINATIONS.length; j++) {
                    if(fashionMagazine.tombolaTicketDestination.equals(AVAILABLE_DESTINATIONS[j])){
                        int count = countDestinations[j];
                        countDestinations[j] = count + 1;
                    }

                }
            }
        }

        int all = 0;
        for(int i = 0; i < countDestinations.length; i++){
            all = all + countDestinations[i];
        }

        double[] ratio = new double[countDestinations.length];
        for (int i = 0; i < countDestinations.length; i++){
            ratio[i] = countDestinations[i]/(double)all * 100;
        }

        return ratio;
    }

    private class FashionMagazinePrice implements PricePerPrintEdition {
        Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews());
        PricePerPrintEdition printPrice = magazine.getPrintEditionPrice();
        double result = printPrice.calculatePricePerEdition();

        @Override
        public double calculatePricePerEdition() {
            if (tombolaTicket) {
                return (result + PRICE_TOMBOLA);
            }else {
                return result;
            }
        }
    }

    private class FashionMagazineInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Has posters: %b\nNumber of interviews: %d\nTombola ticket: %b\nTicket destination: %s\n",
                    getHasPosters(), getNumberOfInterviews(), tombolaTicket, tombolaTicketDestination);
        }
    }

    public PricePerPrintEdition getPrintEditionPrice() {
        return new FashionMagazinePrice();
    }

    public PrintEditionInformation getPrintInformation() {
        return new FashionMagazineInformation();
    }
}
