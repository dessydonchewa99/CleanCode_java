package bookStore;

import exceptions.*;

import java.util.Arrays;
import java.util.List;

public class SportMagazine extends Magazine {
    private final double FOOTBALL_HAT_PRICE = 9.0;
    private final double VOLLEYBALL_HAT_PRICE = 7.0;
    private final char[] CODES = {'F', 'V'};

    private boolean bonusHat; // not every edition should make bonus hats with Magazine
    private String codeOfHat; // Code should start with F(Football) or V(Volleyball) fan hat NOW
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
                sportMagazine.getSportMagazineInformation().printEditionInformation();
        }
    }

    public static void printSortedCodes(List<SportMagazine> sportMagazines){
        String[] codes = new String[sportMagazines.size()];
        int i = 0;
        for (SportMagazine sportMagazine : sportMagazines){
            codes[i] = sportMagazine.codeOfHat;
            i++;
        }

        Arrays.sort(codes);

        for(i = 0; i < codes.length; i++){
            System.out.println(codes[i]);
        }
    }

    public double calculatePriceWithHat(){
        Magazine magazine = new Magazine(getPricePerPage(), getPages(), getIssueInThousands(), getName(),
                getHasPosters(), getNumberOfInterviews());
        PricePerPrintEdition pricePerPrintEdition = magazine.getMagazinePrice();

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
                PricePerPrintEdition printPrice = magazine.getMagazinePrice();
                return printPrice.calculatePricePerEdition();
            }
        }
    }
    private class SportMagazineInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Has posters: %b%nNumber of interviews: %d%nBonusHat: %b%nCode of hat: %s%n",
                    getHasPosters(), getNumberOfInterviews(), bonusHat, codeOfHat);
        }
    }

    public PrintEditionInformation getSportMagazineInformation() {
        return new SportMagazineInformation();
    }

    public char getCodes(int index) {
        return CODES[index];
    }
}
