package bookStore;

public class ColorfulPoster extends Poster {
    public static final double PRICE_SHARP_COLORS = 5.55;
    public static final int CLIENT_NUMBER_DISCOUNT = 10;
    public static final int DISCOUNT = 2; //it means 50%

    private static int order = 1;

    private boolean sharpColors = false;

    public ColorfulPoster(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false);
        setSharpColors(false);
        order++;
    }
    public ColorfulPoster(double pricePerPage, int pages, int issueInThousands, String name, boolean sticky, boolean sharpColors){
        super(pricePerPage, pages, issueInThousands, name, sticky);
        setSharpColors(sharpColors);
        order++;
    }
    public ColorfulPoster(ColorfulPoster colorfulPoster){
        super(colorfulPoster.getPricePerPage(), colorfulPoster.getPages(), colorfulPoster.getIssueInThousands(),
                colorfulPoster.getName(), colorfulPoster.getSticky());
        setSharpColors(colorfulPoster.sharpColors);
        order++;
    }

    public void setSharpColors(boolean sharpColors) {
        this.sharpColors = sharpColors;
    }
    public boolean getSharpColors(){
        return this.sharpColors;
    }

    public void viewNumberDiscounts(){
        System.out.printf("Discounts made: %d\n", order/CLIENT_NUMBER_DISCOUNT);
    }

    private class ColorfulPosterPrice implements PricePerPrintEdition {

        @Override
        public double calculatePricePerEdition() {
            Poster poster = new Poster();
            PricePerPrintEdition printPrice = poster.getPosterPrice();
            double result = printPrice.calculatePricePerEdition();
            if(sharpColors) {
                if(order % CLIENT_NUMBER_DISCOUNT == 0) {
                    return (result + PRICE_STICKY_POSTER)/DISCOUNT;
                } else {
                    return result + PRICE_STICKY_POSTER;
                }
            }else {
                if(order % CLIENT_NUMBER_DISCOUNT == 0) {
                    return result/DISCOUNT;
                } else {
                    return result;
                }
            }

        }
    }

    private class PosterInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Sticky: %b%n\nSharp colors: %b%n", getSticky(), sharpColors);
        }
    }
}
