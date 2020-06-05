package bookStore;

import exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportMagazine extends Magazine {
    private static final double FOOTBALL_HAT_PRICE = 9.0;
    private static final double VOLLEYBALL_HAT_PRICE = 7.0;
    private final char[] CODES = {'F', 'V'}; // Code should starts with F(Football) or V(Volleyball) fan hat

    private boolean bonusHat; // not every edition should make bonus hats with Magazine
    private String codeOfHat;
    private double priceForHat;

    public SportMagazine(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false, 0);
        setBonusHat(false);
        setCodeOfHat(null);
        priceForHat = 0;
    }
    public SportMagazine(double pricePerPage, int pages, int issueInThousands, String name, boolean hasPosters,
                         int numberOfInterviews, boolean bonusHat, String codeOfHat){
        super(pricePerPage, pages, issueInThousands, name, hasPosters, numberOfInterviews);
        setBonusHat(bonusHat);
        setCodeOfHat(codeOfHat);
        if(bonusHat) priceForHat = calculatePriceWithHat();
        else priceForHat = 0;
    }
    public SportMagazine(SportMagazine sportMagazine){
        super(sportMagazine.getPricePerPage(), sportMagazine.getPages(), sportMagazine.getIssueInThousands(),
                sportMagazine.getName(), sportMagazine.getHasPosters(), sportMagazine.getNumberOfInterviews());
        setBonusHat(sportMagazine.bonusHat);
        setCodeOfHat(sportMagazine.codeOfHat);
        if(sportMagazine.bonusHat) priceForHat = calculatePriceWithHat();
        else priceForHat = 0;
    }

    public boolean getBonusHat(){
        return bonusHat;
    }
    public String getCodeOfHat() {
        return codeOfHat;
    }

    public double getPriceForHat() {
        return calculatePriceWithHat();
    }

    public void setCodeOfHat(String codeOfHat) {
        this.codeOfHat = codeOfHat;
    }
    public void setBonusHat(boolean bonusHat) {
        this.bonusHat = bonusHat;
    }

    public static void showAllBonusHat(List<SportMagazine> sportMagazines){
        for(SportMagazine sportMagazine : sportMagazines){
            if(sportMagazine.bonusHat)
                sportMagazine.getPrintInformation().printEditionInformation();
        }
    }

    public static void printSortedCodes(List<SportMagazine> sportMagazines){
        List<String> codes = new ArrayList<>();
        for (SportMagazine sportMagazine : sportMagazines){
            if(sportMagazine.bonusHat) {
                codes.add(sportMagazine.codeOfHat);
            }
        }

        java.util.Collections.sort(codes);

        for(int i = 0; i < codes.size(); i++){
            System.out.println(codes.get(i));
        }
    }

    public double calculatePriceWithHat(){
        Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(),
                getHasPosters(), getNumberOfInterviews());
        PricePerPrintEdition pricePerPrintEdition = magazine.getPrintEditionPrice();

        if((bonusHat && codeOfHat!=null) || (bonusHat && codeOfHat!="")){
            char[] typeHat = new char[1];
            typeHat[0] = codeOfHat.charAt(0);

            if(typeHat[0] == CODES[0]){
                priceForHat = FOOTBALL_HAT_PRICE;
                return pricePerPrintEdition.calculatePricePerEdition() + priceForHat;
            }else if(typeHat[0] == CODES[1]){
                priceForHat = VOLLEYBALL_HAT_PRICE;
                return pricePerPrintEdition.calculatePricePerEdition() + priceForHat;
            }else {
                SportMagazine sportMagazine =
                        new SportMagazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews(),
                                bonusHat, codeOfHat);

                MagazineParameterException exception = new MagazineParameterException();
                exception.hatCodeValidation(sportMagazine, "WRONG CODE");
            }
        }else if((bonusHat && codeOfHat == null) || (bonusHat && codeOfHat == "")){
            SportMagazine sportMagazine =
                    new SportMagazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews(),
                            bonusHat, codeOfHat);

            MagazineParameterException exception = new MagazineParameterException();
            exception.hatCodeValidation(sportMagazine, "MISSING CODE");
        }
        priceForHat = 0;
        return pricePerPrintEdition.calculatePricePerEdition() + priceForHat;
    }

    private class SportMagazinePrice implements PricePerPrintEdition{
        @Override
        public double calculatePricePerEdition() {
            if(bonusHat) {
                return calculatePriceWithHat();
            } else{
                Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(), getHasPosters(), getNumberOfInterviews());
                PricePerPrintEdition printPrice = magazine.getPrintEditionPrice();
                return printPrice.calculatePricePerEdition();
            }
        }
    }
    private class SportMagazineInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Has posters: %b%nNumber of interviews: %d%nBonusHat: %b%nCode of hat: %s%n",
                    getHasPosters(), getNumberOfInterviews(), bonusHat, codeOfHat);
        }
    }

    public PricePerPrintEdition getPrintEditionPrice() {
        return new SportMagazinePrice();
    }

    public PrintEditionInformation getPrintInformation() {
        return new SportMagazineInformation();
    }

    public char getCodes(int index) {
        return CODES[index];
    }
}
