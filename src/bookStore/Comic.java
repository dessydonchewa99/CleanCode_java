package bookStore;

import java.util.ArrayList;
import java.util.List;

public class Comic extends PrintEdition {

    public static final double RAISE_PICTURESONLY_SPECIALFONT = 4.50;
    public static final double RAISE_HASSPECIALFONT = 3.50;
    public static final double RAISE_PICTURESONLY = 2.50;

    private boolean picturesOnly = false;
    private boolean hasSpecialFont = false;

    public Comic(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setPicturesOnly(false);
        setHasSpecialFont(false);
    }
    public Comic(double pricePerPage, int pages, int issueInThousands, String name, boolean picturesOnly, boolean hasSpecialFont){
        super(pricePerPage, pages, issueInThousands, name);
        setPicturesOnly(picturesOnly);
        setHasSpecialFont(hasSpecialFont);
    }
    public Comic(Comic comic){
        super(comic.getPricePerPage(), comic.getPages(), comic.getIssueInThousands(), comic.getName());
        setPicturesOnly(picturesOnly);
        setHasSpecialFont(hasSpecialFont);
    }

    public void setPicturesOnly(boolean picturesOnly) {
        this.picturesOnly = picturesOnly;
    }
    public void setHasSpecialFont(boolean hasSpecialFont) {
        this.hasSpecialFont = hasSpecialFont;
    }

    public boolean getPicturesOnly(){
        return picturesOnly;
    }
    public boolean getHasSpecialFont(){
        return hasSpecialFont;
    }

    public static List<Comic> searchByCriteria(List<Comic> comics, boolean picturesOnly, boolean hasSpecialFont){
        List<Comic> result = new ArrayList<>();
        int i = 0;
        for (Comic comic : comics){
            if(comic.hasSpecialFont == hasSpecialFont && comic.picturesOnly == picturesOnly) {
                result.add(comic);
            }
        }
        return result;
    }

    private class ComicsPrice implements PricePerPrintEdition{

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

    private class ComicsInformation implements PrintEditionInformation{

        @Override
        public void printEditionInformation() {
            System.out.printf("Pictures only: %b%nHas special font: %b%n",
                    picturesOnly, hasSpecialFont);
        }
    }
}

