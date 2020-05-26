package bookStore;

import java.util.List;

public class RetroPoster extends Poster {
    public static final double PRICE_EFFECT_POSTER = 3.35;

    private boolean specialEffect = false; //special retro effect
    private double ratio; //help variable, don't need in constructor

    public RetroPoster(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null, false);
        setSpecialEffect(false);
    }
    public RetroPoster(double pricePerPage, int pages, int issueInThousands, String name, boolean sticky, boolean specialEffect){
        super(pricePerPage, pages, issueInThousands, name, sticky);
        setSpecialEffect(specialEffect);
    }
    public RetroPoster(RetroPoster retroPoster){
        super(retroPoster.getPricePerPage(), retroPoster.getPages(), retroPoster.getIssueInThousands(), retroPoster.getName(), retroPoster.getSticky());
        setSpecialEffect(retroPoster.specialEffect);
    }

    public void setSpecialEffect(boolean retroPoster) {
        this.specialEffect = retroPoster;
    }

    public boolean getSpecialEffect() {
        return specialEffect;
    }

    public double getRatio() {
        return ratio;
    }

    public static int calculateRatio(List<RetroPoster> retroPosters){
        int countSpecial = 0;
        int countNotSpecial = 0;
        int i = 0;
        if(retroPosters != null) {
            while (true) {
                if(retroPosters.isEmpty()) {
                    break;
                }else {
                    if (retroPosters.get(i).specialEffect) {
                        countSpecial++;
                    } else {
                        countNotSpecial++;
                    }
                }

                i++;
            }
        }

        if (countSpecial == 0 || countNotSpecial == 0) {
            System.out.println("Divide by zero");
            return -1;
        }
        else return countSpecial/countNotSpecial;
    }

    private class RetroPosterPrice implements PricePerPrintEdition {

        @Override
        public double calculatePricePerEdition() {
            Poster poster = new Poster();
            PricePerPrintEdition printPrice = poster.getPosterPrice();
            double result = printPrice.calculatePricePerEdition();

            if(specialEffect) {
                return result + PRICE_EFFECT_POSTER;
            }
            else return result;
        }
    }

    private class RetroPosterInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Sticky: %b%n\nRetro poster: %b%n", getSticky(), specialEffect);
        }
    }

}

