package tests;

import bookStore.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.text.SimpleDateFormat;

public class PrintEditionTest {

    private Book book = new Book();
    @Before
    public void initialize(){
        book = new Book(0.50, 40, 2, "Little Red Riding Hood", "Charles Perrault", 2008, true);
    }
    @Test
    public void testLeapYear(){
        boolean leapYear = book.checkLeapYear();
        Assertions.assertTrue(leapYear);
    }
    @Test
    public void testCheckAuthor(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(0.50, 40, 2, "Little Red Riding Hood", "Charles Perrault", 2008, true));
        books.add(new Book(0.34, 100, 4, "Little Fires Everywhere: A Novel", "Celeste Ng", 2019, false));

        boolean result1 = Book.checkAuthor(books, "Charles Perrault");
        Assertions.assertTrue(result1);

    }
    @Test
    public void testLookHardCovers(){
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(0.50, 40, 2, "Little Red Riding Hood", "Charles Perrault", 2008, true);
        Book book2 = new Book(0.34, 100, 4, "Little Fires Everywhere: A Novel", "Celeste Ng", 2019, false);
        Book book3 = new Book(0.17, 50, 5, "Brown Bear, Brown Bear, What Do You See?", "Bill Martin Jr.", 1996, false);
        Book book4 = new Book(1.23, 100, 2, "Midnight Sun", "Stephenie Meyer", 2010, true);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        List<Book> hardCoversList = Book.lookAllHardCovers(bookList);

        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book4);

        Assertions.assertEquals(expected, hardCoversList);
    }

    @Test
    public void testNumberDiscounts(){
        for(int i = 0; i < 32; i++){
            ColorfulPoster colorfulPoster = new ColorfulPoster();
        }
        Assertions.assertEquals(3, ColorfulPoster.getOrder() / ColorfulPoster.CLIENT_NUMBER_DISCOUNT);
    }

    @Test
    public void testSearchByCriteria(){
        List<Comic> comicList = new ArrayList<>();
        Comic comic1 = new Comic(0.25, 10, 7, "Heroes", true, true);
        Comic comic2 = new Comic(0.15, 15, 17, "Animals", false, true);
        Comic comic3 = new Comic(0.29, 17, 27, "Stars", true, false);
        Comic comic4 = new Comic(0.12, 8, 1, "Where is the hero?", false, true);

        comicList.add(comic1);
        comicList.add(comic2);
        comicList.add(comic3);
        comicList.add(comic4);

        List<Comic> expected = new ArrayList<>();
        expected.add(comic2);
        expected.add(comic4);

        List<Comic> criteriaFounds = Comic.searchByCriteria(comicList, false, true);
        Assertions.assertEquals(expected, criteriaFounds);
    }

    @Test
    public void testRatioDestinations(){
        FashionMagazine fashionMagazine1 = new FashionMagazine(0.06, 48, 4, "WOMEN", true, 5, true, "UK");
        FashionMagazine fashionMagazine2 = new FashionMagazine(0.16, 55, 3, "Hello women", true, 15, true, "UK");
        FashionMagazine fashionMagazine3 = new FashionMagazine(0.12, 32, 2, "Successful women", true, 7, true, "FRANCE");
        FashionMagazine fashionMagazine4 = new FashionMagazine(0.10, 40, 34, "EVA", true, 8, true, "ITALY");

        List<FashionMagazine> magazineList = new ArrayList<FashionMagazine>();
        magazineList.add(fashionMagazine1);
        magazineList.add(fashionMagazine2);
        magazineList.add(fashionMagazine3);
        magazineList.add(fashionMagazine4);

        double[] result = FashionMagazine.ratioDestinations(magazineList);

        double[] expected = {25.0, 0.0, 25.0, 50.0, 0.0};

        Assertions.assertArrayEquals(result, expected);
    }

    @Test
    public void testIntervalOfInterviews(){
        Magazine magazine1 = new Magazine(0.06, 48, 4, "WOMEN", true, 5);
        Magazine magazine2 = new Magazine(0.16, 55, 3, "NatGeo", true, 15);
        Magazine magazine3 = new Magazine(0.12, 32, 2, "Every day", false, 7);
        Magazine magazine4 = new Magazine(0.10, 40, 34, "EVA", true, 8);

        List<Magazine> magazineList = new ArrayList<Magazine>();
        magazineList.add(magazine1);
        magazineList.add(magazine2);
        magazineList.add(magazine3);
        magazineList.add(magazine4);

        List<Magazine> result = Magazine.intervalOfInterviews(magazineList, 6, 20);
        List<Magazine> expected = new ArrayList<>();
        expected.add(magazine2);
        expected.add(magazine3);
        expected.add(magazine4);

        Assertions.assertEquals(expected, result);

    }
    @Test
    public void testSpecialMagazine(){
        Magazine magazine1 = new Magazine(0.06, 48, 4, "WOMEN", true, 5);
        Magazine magazine2 = new Magazine(0.16, 55, 3, "NatGeo", true, 15);
        Magazine magazine3 = new Magazine(0.12, 32, 2, "Every day", false, 7);
        Magazine magazine4 = new Magazine(0.10, 40, 34, "EVA", true, 8);

        List<Magazine> magazineList = new ArrayList<Magazine>();
        magazineList.add(magazine1);
        magazineList.add(magazine2);
        magazineList.add(magazine3);
        magazineList.add(magazine4);

        Magazine result = Magazine.findSpecialMagazine(magazineList, false, 7);
        Magazine expected = new Magazine();
        expected = magazine3;

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testTotalAds(){
        Newspaper newspaper1 = new Newspaper(0.12, 20, 2, "Weekend", new Date(), 2);
        Newspaper newspaper2 = new Newspaper(0.16, 23, 5, "TODAY", new Date(), 4);
        Newspaper newspaper3 = new Newspaper(0.02, 40, 23, "24H", new Date(), 3);

        List<Newspaper> newspaperList = new ArrayList<>();
        newspaperList.add(newspaper1);
        newspaperList.add(newspaper2);
        newspaperList.add(newspaper3);

        int result = Newspaper.totalAds(newspaperList);
        int expected = newspaper1.getAdsNumber() + newspaper2.getAdsNumber() + newspaper3.getAdsNumber();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAfterDate() throws ParseException {
        Newspaper newspaper1 = new Newspaper(0.12, 20, 2, "Weekend", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2012"), 2);
        Newspaper newspaper2 = new Newspaper(0.16, 23, 5, "TODAY", new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2010"), 4);
        Newspaper newspaper3 = new Newspaper(0.02, 40, 23, "24H", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2016"), 3);

        List<Newspaper> newspaperList = new ArrayList<>();
        newspaperList.add(newspaper1);
        newspaperList.add(newspaper2);
        newspaperList.add(newspaper3);

        List<Date> result = new ArrayList<>();
        result = Newspaper.afterDate(newspaperList, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2011"));

        List<Date> expected = new ArrayList<>();
        expected.add(newspaper1.getPrintDate());
        expected.add(newspaper3.getPrintDate());

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalculateRatio(){
        RetroPoster retroPoster1 = new RetroPoster(0.34, 30, 1, "Save our planet!", false, true);
        RetroPoster retroPoster2 = new RetroPoster(0.50, 100, 1, "Live now", true, true);
        RetroPoster retroPoster3 = new RetroPoster(0.45, 40, 1, "Green life", true, false);
        RetroPoster retroPoster4 = new RetroPoster(0.25, 15, 1, "VEGAN", true, true);
        RetroPoster retroPoster5 = new RetroPoster(0.17, 6, 1, "Think now", false, false);

        List<RetroPoster> retroPosters = new ArrayList<>();
        retroPosters.add(retroPoster1);
        retroPosters.add(retroPoster2);
        retroPosters.add(retroPoster3);
        retroPosters.add(retroPoster4);
        retroPosters.add(retroPoster5);

        double result = RetroPoster.calculateRatio(retroPosters);
        double expected = 3.0/2.0;

        Assertions.assertEquals(expected, result);

    }
    @Test
    public void testRatioDivide(){
        RetroPoster retroPoster1 = new RetroPoster(0.34, 30, 1, "Save our planet!", false, true);
        RetroPoster retroPoster2 = new RetroPoster(0.50, 100, 1, "Live now", true, true);
        RetroPoster retroPoster3 = new RetroPoster(0.25, 15, 1, "VEGAN", true, true);

        List<RetroPoster> retroPosters = new ArrayList<>();
        retroPosters.add(retroPoster1);
        retroPosters.add(retroPoster2);
        retroPosters.add(retroPoster3);

        double result = RetroPoster.calculateRatio(retroPosters);

        Assertions.assertEquals(-1, result);
    }
    @Test
    public void testShowBonusHats(){
        SportMagazine sportMagazine1 = new SportMagazine(0.75, 24, 2, "SPORT news", true, 5, true, "F345");
        SportMagazine sportMagazine2 = new SportMagazine(0.34, 36, 3, "LIVERPOOL", true, 7, true, "F6712");
        SportMagazine sportMagazine3 = new SportMagazine(0.25, 50, 4, "Sport", false, 1, false, null);
        SportMagazine sportMagazine4 = new SportMagazine(0.99, 20, 5, "SU Volleyball Team", false, 10, true, "V123");

        List<SportMagazine> result = new ArrayList<>();
        result.add(sportMagazine1);
        result.add(sportMagazine2);
        result.add(sportMagazine3);
        result.add(sportMagazine4);

        SportMagazine.showAllBonusHat(result);

        Assertions.assertNotNull(result);
    }
    @Test
    public void testPrintSortedCodes(){
        SportMagazine sportMagazine1 = new SportMagazine(0.75, 24, 2, "SPORT news", true, 5, true, "F845");
        SportMagazine sportMagazine2 = new SportMagazine(0.34, 36, 3, "LIVERPOOL", true, 7, true, "F6712");
        SportMagazine sportMagazine3 = new SportMagazine(0.25, 50, 4, "Sport", false, 1, false, null);
        SportMagazine sportMagazine4 = new SportMagazine(0.99, 20, 5, "SU Volleyball Team", false, 10, true, "V123");

        List<SportMagazine> result = new ArrayList<>();
        result.add(sportMagazine1);
        result.add(sportMagazine2);
        result.add(sportMagazine3);
        result.add(sportMagazine4);

        SportMagazine.printSortedCodes(result);

        Assertions.assertNotNull(result);

    }

}
