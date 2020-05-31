package tests;

import bookStore.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import templates.PrintList;
import templates.TotalPriceList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemplateTest{

    @Test
    public void testBookPrint(){
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(0.50, 40, 2, "Little Red Riding Hood", "Charles Perrault", 2008, true);
        Book book2 = new Book(0.34, 100, 4, "Little Fires Everywhere: A Novel", "Celeste Ng", 2019, false);
        Book book3 = new Book(0.17, 50, 5, "Brown Bear, Brown Bear, What Do You See?", "Bill Martin Jr.", 1996, false);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        PrintList<Book> bookPrintList = new PrintList<Book>(bookList);
        bookPrintList.printObjects();

        Assertions.assertNotNull(bookPrintList);
    }
    @Test
    public void testColorfulPosterPrint(){
        List<ColorfulPoster> posterList = new ArrayList<>();
        ColorfulPoster poster1 = new ColorfulPoster(0.05, 20, 20, "Earth nowadays poster", true, false);
        ColorfulPoster poster2 = new ColorfulPoster(0.15, 100, 10, "How to increase your money?", true, true);
        ColorfulPoster poster3 = new ColorfulPoster(0.03, 200, 10, "Looking for job?", false, false);

        posterList.add(poster1);
        posterList.add(poster2);
        posterList.add(poster3);

        PrintList<ColorfulPoster> posterPrintList = new PrintList<ColorfulPoster>(posterList);
        posterPrintList.printObjects();

        Assertions.assertNotNull(posterPrintList);
    }
    @Test
    public void testComicPrint(){
        List<Comic> comicList = new ArrayList<>();
        Comic comic1 = new Comic(0.25, 10, 7, "Heroes", true, true);
        Comic comic2 = new Comic(0.15, 15, 17, "Animals", false, true);
        Comic comic3 = new Comic(0.29, 17, 27, "Stars", true, false);

        comicList.add(comic1);
        comicList.add(comic2);
        comicList.add(comic3);

        PrintList<Comic> comicPrintList = new PrintList<Comic>(comicList);
        comicPrintList.printObjects();

        Assertions.assertNotNull(comicPrintList);
    }
    @Test
    public void testFashionMagazinePrint(){
        List<FashionMagazine> magazineList = new ArrayList<>();
        FashionMagazine fashionMagazine1 = new FashionMagazine(0.06, 48, 4, "WOMEN", true, 5, true, "UK");
        FashionMagazine fashionMagazine2 = new FashionMagazine(0.16, 55, 3, "Hello women", true, 15, true, "UK");
        FashionMagazine fashionMagazine3 = new FashionMagazine(0.12, 32, 2, "Successful women", true, 7, true, "FRANCE");

        magazineList.add(fashionMagazine1);
        magazineList.add(fashionMagazine2);
        magazineList.add(fashionMagazine3);

        PrintList<FashionMagazine> magazinePrintList = new PrintList<FashionMagazine>(magazineList);
        magazinePrintList.printObjects();

        Assertions.assertNotNull(magazinePrintList);
    }
    @Test
    public void testMagazinePrint(){
        List<Magazine> magazineList = new ArrayList<>();
        Magazine magazine1 = new Magazine(0.06, 48, 4, "WOMEN", true, 5);
        Magazine magazine2 = new Magazine(0.16, 55, 3, "NatGeo", true, 15);
        Magazine magazine3 = new Magazine(0.12, 32, 2, "Every day", false, 7);

        magazineList.add(magazine1);
        magazineList.add(magazine2);
        magazineList.add(magazine3);

        PrintList<Magazine> magazinePrintList = new PrintList<Magazine>(magazineList);
        magazinePrintList.printObjects();

        Assertions.assertNotNull(magazinePrintList);
    }
    @Test
    public void testNewspaperPrint(){
        List<Newspaper> newspaperList = new ArrayList<>();
        Newspaper newspaper1 = new Newspaper(0.12, 20, 2, "Weekend", new Date(), 2);
        Newspaper newspaper2 = new Newspaper(0.16, 23, 5, "TODAY", new Date(), 4);
        Newspaper newspaper3 = new Newspaper(0.02, 40, 23, "24H", new Date(), 3);

        newspaperList.add(newspaper1);
        newspaperList.add(newspaper2);
        newspaperList.add(newspaper3);

        PrintList<Newspaper> newspaperPrintList = new PrintList<Newspaper>(newspaperList);
        newspaperPrintList.printObjects();

        Assertions.assertNotNull(newspaperPrintList);
    }
    @Test
    public void testPosterPrint(){
        List<Poster> posterList = new ArrayList<>();
        Poster poster1 = new Poster(0.34, 30, 1, "Save our planet!", false);
        Poster poster2 = new Poster(0.50, 100, 1, "Live now", true);
        Poster poster3 = new Poster(0.40, 70, 7, "Start thinking", true);

        posterList.add(poster1);
        posterList.add(poster2);
        posterList.add(poster3);

        PrintList<Poster> newspaperPrintList = new PrintList<Poster>(posterList);
        newspaperPrintList.printObjects();

        Assertions.assertNotNull(newspaperPrintList);
    }
    @Test
    public void testRetroPosterPrint(){
        List<Poster> posterList = new ArrayList<>();
        RetroPoster retroPoster1 = new RetroPoster(0.45, 40, 1, "Green life", true, false);
        RetroPoster retroPoster2 = new RetroPoster(0.25, 15, 1, "VEGAN", true, true);
        RetroPoster retroPoster3 = new RetroPoster(0.17, 6, 1, "Think now", false, false);

        posterList.add(retroPoster1);
        posterList.add(retroPoster2);
        posterList.add(retroPoster3);

        PrintList<Poster> newspaperPrintList = new PrintList<Poster>(posterList);
        newspaperPrintList.printObjects();

        Assertions.assertNotNull(newspaperPrintList);
    }
    @Test
    public void testSportMagazinePrint(){
        List<Magazine> magazineList = new ArrayList<>();
        SportMagazine sportMagazine1 = new SportMagazine(0.75, 24, 2, "SPORT news", true, 5, true, "F845");
        SportMagazine sportMagazine2 = new SportMagazine(0.34, 36, 3, "LIVERPOOL", true, 7, true, "F6712");
        SportMagazine sportMagazine3 = new SportMagazine(0.25, 50, 4, "Sport", false, 1, false, null);

        magazineList.add(sportMagazine1);
        magazineList.add(sportMagazine2);
        magazineList.add(sportMagazine3);

        PrintList<Magazine> magazinePrintList = new PrintList<Magazine>(magazineList);
        magazinePrintList.printObjects();

        Assertions.assertNotNull(magazinePrintList);
    }

    // price tests
    @Test
    public void testBookPrice(){
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(0.50, 40, 2, "Little Red Riding Hood", "Charles Perrault", 2008, true);
        Book book2 = new Book(0.34, 100, 4, "Little Fires Everywhere: A Novel", "Celeste Ng", 2019, false);
        Book book3 = new Book(0.17, 50, 5, "Brown Bear, Brown Bear, What Do You See?", "Bill Martin Jr.", 1996, false);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        TotalPriceList<Book> bookPriceList = new TotalPriceList<Book>(bookList);
        double result = bookPriceList.total();

        Assertions.assertEquals(72.5, result);
    }
    @Test
    public void testColorfulPosterPrice(){
        List<ColorfulPoster> posterList = new ArrayList<>();
        ColorfulPoster poster1 = new ColorfulPoster(0.05, 20, 20, "Earth nowadays poster", true, false);
        ColorfulPoster poster2 = new ColorfulPoster(0.15, 100, 10, "How to increase your money?", true, true);
        ColorfulPoster poster3 = new ColorfulPoster(0.03, 200, 10, "Looking for job?", false, false);

        posterList.add(poster1);
        posterList.add(poster2);
        posterList.add(poster3);

        TotalPriceList<ColorfulPoster> posterPriceList = new TotalPriceList<ColorfulPoster>(posterList);
        double result = posterPriceList.total();

        Assertions.assertEquals(31.05, result);
    }
    @Test
    public void testComicPrice(){
        List<Comic> comicList = new ArrayList<>();
        Comic comic1 = new Comic(0.25, 10, 7, "Heroes", true, true);
        Comic comic2 = new Comic(0.15, 15, 17, "Animals", false, true);
        Comic comic3 = new Comic(0.29, 17, 27, "Stars", true, false);

        comicList.add(comic1);
        comicList.add(comic2);
        comicList.add(comic3);

        TotalPriceList<Comic> comicPriceList = new TotalPriceList<Comic>(comicList);
        double result = comicPriceList.total();

        Assertions.assertEquals(31.45, result);
    }
    @Test
    public void testFashionMagazinePrice(){
        List<FashionMagazine> magazineList = new ArrayList<>();
        FashionMagazine fashionMagazine1 = new FashionMagazine(0.06, 48, 4, "WOMEN", true, 5, true, "UK");
        FashionMagazine fashionMagazine2 = new FashionMagazine(0.16, 55, 3, "Hello women", true, 15, true, "UK");
        FashionMagazine fashionMagazine3 = new FashionMagazine(0.12, 32, 2, "Successful women", true, 7, true, "FRANCE");

        magazineList.add(fashionMagazine1);
        magazineList.add(fashionMagazine2);
        magazineList.add(fashionMagazine3);

        TotalPriceList<FashionMagazine> magazinePriceList = new TotalPriceList<FashionMagazine>(magazineList);
        double result = magazinePriceList.total();

        Assertions.assertEquals(56.47, result);
    }
    @Test
    public void testMagazinePrice(){
        List<Magazine> magazineList = new ArrayList<>();
        Magazine magazine1 = new Magazine(0.36, 48, 4, "WOMEN", true, 5);
        Magazine magazine2 = new Magazine(0.16, 55, 3, "NatGeo", true, 15);
        Magazine magazine3 = new Magazine(0.12, 32, 2, "Every day", false, 7);

        magazineList.add(magazine1);
        magazineList.add(magazine2);
        magazineList.add(magazine3);

        TotalPriceList<Magazine> magazinePriceList = new TotalPriceList<Magazine>(magazineList);
        double result = magazinePriceList.total();

        Assertions.assertEquals(59.92, result);
    }
    @Test
    public void testNewspaperPrice(){
        List<Newspaper> newspaperList = new ArrayList<>();
        Newspaper newspaper1 = new Newspaper(0.12, 20, 2, "Weekend", new Date(), 2);
        Newspaper newspaper2 = new Newspaper(0.16, 23, 5, "TODAY", new Date(), 4);
        Newspaper newspaper3 = new Newspaper(0.02, 40, 23, "24H", new Date(), 3);

        newspaperList.add(newspaper1);
        newspaperList.add(newspaper2);
        newspaperList.add(newspaper3);

        TotalPriceList<Newspaper> newspaperPriceList = new TotalPriceList<Newspaper>(newspaperList);
        double result = newspaperPriceList.total();

        Assertions.assertEquals(6.43, result);
    }
    @Test
    public void testPosterPrice(){
        List<Poster> posterList = new ArrayList<>();
        Poster poster1 = new Poster(0.34, 30, 1, "Save our planet!", false);
        Poster poster2 = new Poster(0.50, 100, 1, "Live now", true);
        Poster poster3 = new Poster(0.40, 70, 7, "Start thinking", true);

        posterList.add(poster1);
        posterList.add(poster2);
        posterList.add(poster3);

        TotalPriceList<Poster> posterPriceList = new TotalPriceList<Poster>(posterList);
        double result = posterPriceList.total();

        Assertions.assertEquals(91.70, result);
    }
    @Test
    public void testRetroPosterPrice(){
        List<RetroPoster> posterList = new ArrayList<>();
        RetroPoster retroPoster1 = new RetroPoster(0.45, 40, 1, "Green life", true, false);
        RetroPoster retroPoster2 = new RetroPoster(0.25, 15, 1, "VEGAN", true, true);
        RetroPoster retroPoster3 = new RetroPoster(0.17, 6, 1, "Think now", false, false);

        posterList.add(retroPoster1);
        posterList.add(retroPoster2);
        posterList.add(retroPoster3);

        TotalPriceList<RetroPoster> posterPriceList = new TotalPriceList<RetroPoster>(posterList);
        double result = posterPriceList.total();

        Assertions.assertEquals(29.62, result);
    }
    @Test
    public void testSportMagazinePrice(){
        List<Magazine> magazineList = new ArrayList<>();
        SportMagazine sportMagazine1 = new SportMagazine(0.75, 24, 2, "SPORT news", true, 5, true, "F845");
        SportMagazine sportMagazine2 = new SportMagazine(0.35, 36, 3, "LIVERPOOL", true, 7, true, "F6712");
        SportMagazine sportMagazine3 = new SportMagazine(0.20, 50, 4, "Sport", false, 1, false, null);

        magazineList.add(sportMagazine1);
        magazineList.add(sportMagazine2);
        magazineList.add(sportMagazine3);

        TotalPriceList<Magazine> magazinePriceList = new TotalPriceList<Magazine>(magazineList);
        double result = magazinePriceList.total();

        Assertions.assertEquals(74.60, result);
    }
}
