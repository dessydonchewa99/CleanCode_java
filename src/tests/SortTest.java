package tests;

import bookStore.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import templates.SortList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SortTest {
    @Test
    public void sortByString(){
        FashionMagazine fashionMagazine1 = new FashionMagazine(0.06, 48, 4, "WOMEN", true, 5, true, "UK");
        FashionMagazine fashionMagazine2 = new FashionMagazine(0.16, 55, 3, "Hello women", true, 15, true, "UK");
        FashionMagazine fashionMagazine3 = new FashionMagazine(0.12, 32, 2, "Successful women", true, 7, true, "FRANCE");
        FashionMagazine fashionMagazine4 = new FashionMagazine(0.10, 40, 34, "EVA", true, 8, true, "ITALY");

        List<String> stringList = new ArrayList<>();
        stringList.add(fashionMagazine1.getName());
        stringList.add(fashionMagazine2.getName());
        stringList.add(fashionMagazine3.getName());
        stringList.add(fashionMagazine4.getName());

        SortList<String> sortList = new SortList<>(stringList);

        Assert.assertEquals("[EVA, Hello women, Successful women, WOMEN]", Arrays.toString(sortList.sort().toArray()));
    }
    @Test
    public void sortByBoolean(){
        ColorfulPoster poster1 = new ColorfulPoster(0.05, 20, 20, "Earth nowadays poster", true, false);
        ColorfulPoster poster2 = new ColorfulPoster(0.15, 100, 10, "How to increase your money?", true, true);
        ColorfulPoster poster3 = new ColorfulPoster(0.03, 200, 10, "Looking for job?", false, false);

        List<Boolean> booleanList = new ArrayList<>();
        booleanList.add(poster1.getSharpColors());
        booleanList.add(poster2.getSharpColors());
        booleanList.add(poster3.getSharpColors());

        SortList<Boolean> sortList = new SortList<>(booleanList);

        Assert.assertEquals("[false, false, true]", Arrays.toString(sortList.sort().toArray()));
    }
    @Test
    public void sortByInteger(){
        Comic comic1 = new Comic(0.25, 10, 37, "Heroes", true, true);
        Comic comic2 = new Comic(0.15, 15, 17, "Animals", false, true);
        Comic comic3 = new Comic(0.29, 17, 27, "Stars", true, false);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(comic1.getIssueInThousands());
        integerList.add(comic2.getIssueInThousands());
        integerList.add(comic3.getIssueInThousands());

        SortList<Integer> sortList = new SortList<>(integerList);

        Assert.assertEquals("[17, 27, 37]", Arrays.toString(sortList.sort().toArray()));
    }
    @Test
    public void sortByDecimal(){
        Book book1 = new Book(0.50, 40, 2, "Little Red Riding Hood", "Charles Perrault", 2008, true);
        Book book2 = new Book(0.34, 100, 4, "Little Fires Everywhere: A Novel", "Celeste Ng", 2019, false);
        Book book3 = new Book(0.17, 50, 5, "Brown Bear, Brown Bear, What Do You See?", "Bill Martin Jr.", 1996, false);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(book1.calculatePrintPrice());
        doubleList.add(book2.calculatePrintPrice());
        doubleList.add(book3.calculatePrintPrice());

        SortList<Double> sortList = new SortList<>(doubleList);

        Assert.assertEquals("[8.5, 20.0, 34.0]", Arrays.toString(sortList.sort().toArray()));
    }
    @Test
    public void sortByDate(){
        Newspaper newspaper1 = new Newspaper(0.12, 20, 2, "Weekend", new Date("June 13, 2020 11:30:00"), 2);
        Newspaper newspaper2 = new Newspaper(0.16, 23, 5, "TODAY", new Date("May 21, 2020 10:00:00"), 4);
        Newspaper newspaper3 = new Newspaper(0.02, 40, 23, "24H", new Date("June 01, 2020 12:00:00"), 3);

        List<Date> dateList = new ArrayList<>();
        dateList.add(newspaper1.getPrintDate());
        dateList.add(newspaper2.getPrintDate());
        dateList.add(newspaper3.getPrintDate());

        SortList<Date> sortList = new SortList<>(dateList);

        Assert.assertEquals("[Thu May 21 10:00:00 EEST 2020, Mon Jun 01 12:00:00 EEST 2020, Sat Jun 13 11:30:00 EEST 2020]", Arrays.toString(sortList.sort().toArray()));
    }
}
