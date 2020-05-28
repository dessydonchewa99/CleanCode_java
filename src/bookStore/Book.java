package bookStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Book extends PrintEdition {

    public static final int DEFAULT_YEAR = 2000;
    public static final double RAISE_PRICE_HARD_COVERS = 5.0;
    public static final double RAISE_PRICE_SOFT_COVERS = 2.5;

    private String authorName;
    private int year;
    private boolean hasHardCovers;

    public Book(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setAuthorName(null);
        setYear(DEFAULT_YEAR);
        setHasHardCovers(false);
    }
    public Book(double pricePerPage, int pages, int issueInThousands, String name, String authorName, int year, boolean hasHardCovers){
        super(pricePerPage, pages, issueInThousands, name);
        setAuthorName(authorName);
        setYear(year);
        setHasHardCovers(hasHardCovers);
    }
    public Book(Book book){
        super(book.getPricePerPage(), book.getPages(), book.getIssueInThousands(), book.getName());
        setAuthorName(book.authorName);
        setYear(book.year);
        setHasHardCovers(book.hasHardCovers);
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? "DEFAULT AUTHOR" : authorName;
    }
    public void setYear(int year) {
        if(year > 0 && year <  Calendar.getInstance().get(Calendar.YEAR)) {
            this.year = year;
        }else {
            this.year = DEFAULT_YEAR;
        }
    }
    public void setHasHardCovers(boolean hasHardCovers) {
        this.hasHardCovers = hasHardCovers;
    }

    public String getAuthorName() {
        return authorName;
    }
    public int getYear() {
        return year;
    }
    public boolean getHasHardcovers() {
        return hasHardCovers;
    }

    public boolean checkLeapYear(){
        boolean leap = false;
        if(year % 4 == 0)
        {
            if(year % 100 == 0)
            {
                if (year % 400 == 0) {
                    leap = true;
                }
                else {
                    leap = false;
                }
            }
            else {
                leap = true;
            }
        }
        else {
            leap = false;
        }

        if(leap) {
            System.out.println(year + " is a leap year.");
            return true;
        }
        else{
            System.out.println(year + " is not a leap year.");
            return false;
        }
    }
    public static boolean checkAuthor(List<Book> bookList, String authorName){
        int i = 0;
        for(Book book : bookList){
            if(book.authorName.equals(authorName)) {
                return true;
            }
        }
        return false;
    }
    public static List<Book> lookAllHardCovers(List<Book> bookList){
        List<Book> result = new ArrayList<>();
        for(Book book : bookList){
            if(book.getHasHardcovers()) {
                result.add(book);
            }
        }

        return result;
    }

    private class BookPrice implements PricePerPrintEdition {

        @Override
        public double calculatePricePerEdition() {
            if(hasHardCovers) {
                return calculatePrintPrice() + RAISE_PRICE_HARD_COVERS;
            }else {
                return calculatePrintPrice() + RAISE_PRICE_SOFT_COVERS;
            }
        }
    }

    private class BookInformation implements PrintEditionInformation {

        @Override
        public void printEditionInformation() {
            System.out.printf("Author name: %s%nRelease year: %d%nHard covers: %b%n",
                    authorName, year, hasHardCovers);
        }
    }
}

