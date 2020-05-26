package bookStore;

public class PrintEdition {

    public static final double DEFAULT_PRICE_PER_PAGE = 0.01;
    public static final int MIN_PAGES = 1;
    public static final int MIN_ISSUE = 1;

    private double pricePerPage;
    private int pages;
    private int issueInThousands;
    private String name;

    public PrintEdition(){
        setPricePerPage(DEFAULT_PRICE_PER_PAGE);
        setPages(MIN_PAGES);
        setIssueInThousands(MIN_ISSUE);
        setName(null);
    }
    public PrintEdition(double pricePerPage, int pages, int issueInThousands, String name){
        setPricePerPage(pricePerPage);
        setPages(pages);
        setIssueInThousands(issueInThousands);
        setName(name);
    }
    public PrintEdition(PrintEdition printEdition){
        setPricePerPage(printEdition.pricePerPage);
        setPages(printEdition.pages);
        setIssueInThousands(printEdition.issueInThousands);
        setName(printEdition.name);
    }

    public final void setPricePerPage(double pricePerPage) {
        this.pricePerPage = pricePerPage < 0 ? DEFAULT_PRICE_PER_PAGE : pricePerPage;
    }
    public final void setPages(int pages) {
        this.pages = pages < 0 ? MIN_PAGES : pages;
    }
    public final void setIssueInThousands(int issueInThousands) {
        this.issueInThousands = issueInThousands < 0 ? MIN_ISSUE : issueInThousands;
    }
    public final void setName(String name) {
        this.name = name == null ? "DEFAULT PRINT EDITION NAME" : name;
    }

    public final double getPricePerPage() {
        return pricePerPage;
    }
    public final int getPages() {
        return pages;
    }
    public final int getIssueInThousands() {
        return issueInThousands;
    }
    public String getName() {
        return name;
    }

    public double calculatePrintPrice() {
        return pricePerPage*pages;
    }
}

