package bookStore;
/**
 * Represents a Book.
 * @author Desislava Dontcheva
 * @version 1.0
 */

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

    /**
     * Default constructor for class Book.
     */
    public Book(){
        super(DEFAULT_PRICE_PER_PAGE, MIN_PAGES, MIN_ISSUE, null);
        setAuthorName(null);
        setYear(DEFAULT_YEAR);
        setHasHardCovers(false);
    }
    /**
     * Constructor with parameters for class Book.
     * @param pricePerPage This is the price per page of the Book.
     * @param pages This is the amount of pages of the Book.
     * @param issueInThousands This is the issue count in thousands of the Book.
     * @param name This is the name of the Book.
     * @param authorName This is the author name of the Book.
     * @param year This is the release year of the Book.
     * @param hasHardCovers Shows if the Book has hard covers or not.
     */
    public Book(double pricePerPage, int pages, int issueInThousands, String name, String authorName, int year, boolean hasHardCovers){
        super(pricePerPage, pages, issueInThousands, name);
        setAuthorName(authorName);
        setYear(year);
        setHasHardCovers(hasHardCovers);
    }
    /**
     * Copy constructor for class Book.
     * @param book Object of class Book.
     */
    public Book(Book book){
        super(book.getPricePerPage(), book.getPages(), book.getIssueInThousands(), book.getName());
        setAuthorName(book.authorName);
        setYear(book.year);
        setHasHardCovers(book.hasHardCovers);
    }

    /**
     * This method sets authorName of class Book.
     * @param authorName This is the author name of the Book.
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? "DEFAULT AUTHOR" : authorName;
    }
    /**
     * This method sets year of class Book.
     * @param year This is the release year of the Book.
     */
    public void setYear(int year) {
        if(year > 0 && year <  Calendar.getInstance().get(Calendar.YEAR)) {
            this.year = year;
        }else {
            this.year = DEFAULT_YEAR;
        }
    }
    /**
     * This method sets hasHardCovers of class Book.
     * @param hasHardCovers Shows if the Book has hard covers or not.
     */
    public void setHasHardCovers(boolean hasHardCovers) {
        this.hasHardCovers = hasHardCovers;
    }

    /**
     * This method gets authorName of class Book.
     * @return String This is the author name of the Book.
     */
    public String getAuthorName() {
        return authorName;
    }
    /**
     * This method gets year of class Book.
     * @return int This is the release year of the Book.
     */
    public int getYear() {
        return year;
    }
    /**
     * This method gets hasHardCovers of class Book.
     * @return boolean Shows if the Book has hard covers or not.
     */
    public boolean getHasHardcovers() {
        return hasHardCovers;
    }

    /**
     * This method shows if release year is leap or not of the Book.
     * @return boolean Shows if the book year is leap or not.
     */
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

    /**
     * This method gets a Book list and an author name
     * and search for this author name in the list.
     * @param bookList This is a Book list.
     * @param authorName This is the author name of the Book.
     * @return boolean If the author name is equal to any of the list, returns true.
     */
    public static boolean checkAuthor(List<Book> bookList, String authorName){
        for(Book book : bookList){
            if(book.authorName.equals(authorName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method searches for the Books with hard covers
     * and returns a new list full of Books only with hard covers.
     * @param bookList This is the input parameter Book list.
     * @return Book list This is the output hard covers Book list.
     */
    public static List<Book> lookAllHardCovers(List<Book> bookList){
        List<Book> result = new ArrayList<>();

        for(Book book : bookList){
            if(book.getHasHardcovers()) {
                result.add(book);
            }
        }

        return result;
    }

    /**
     * This is a private inner class that implements PricePerPrintEdition interface.
     */
    private class BookPrice implements PricePerPrintEdition {

        /**
         * This method calculates the price per Book.
         * @return double This is the total price of the Book.
         */
        @Override
        public double calculatePricePerEdition() {
            if(hasHardCovers) {
                return calculatePrintPrice() + RAISE_PRICE_HARD_COVERS;
            }else {
                return calculatePrintPrice() + RAISE_PRICE_SOFT_COVERS;
            }
        }
    }
    /**
     * This is a private inner class that implements PrintEditionInformation interface.
     */
    private class BookInformation implements PrintEditionInformation {

        /**
         * This method prints formatted information of the Book.
         */
        @Override
        public void printEditionInformation() {
            System.out.printf("Price per page: %.2f%nPages: %d%nIssue in thousands: %d%nName: %s%n",
                    getPricePerPage(), getPages(), getIssueInThousands(), getName());
            System.out.printf("Author name: %s%nRelease year: %d%nHard covers: %b%n",
                    authorName, year, hasHardCovers);
        }
    }

    /**
     * This method gets an instance of the private inner class BookPrice.
     * @return new object of BookPrice class
     */
    public PricePerPrintEdition getPrintEditionPrice(){
        return new BookPrice();
    }
    /**
     * This method gets an instance of the private inner class BookInformation.
     * @return new object of BookInformation class
     */
    public PrintEditionInformation getPrintInformation(){
        return new BookInformation();
    }
}

