package templates;

import bookStore.PricePerPrintEdition;
import bookStore.PrintEdition;
import bookStore.PrintEditionInformation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrintList<T extends PrintEdition> {
    private List<T> objects;

    public PrintList(){
        objects = new ArrayList<>();
    }

    public PrintList(List<T> objects) {
        this.objects = new ArrayList<>(objects.size());
        this.objects.addAll(objects);
    }

    public void printObjects() {
        for(T object : objects){
            PrintEditionInformation printEditionInformation = object.getPrintInformation();
            printEditionInformation.printEditionInformation();

            System.out.println();
        }
    }
}
