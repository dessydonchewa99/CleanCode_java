package templates;
/**
 * Represents a PrintList.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import bookStore.PrintEdition;
import bookStore.PrintEditionInformation;

import java.util.ArrayList;
import java.util.List;

public class PrintList<T extends PrintEdition> {
    private List<T> objects;

    /**
     * Default constructor for class PrintList.
     */
    public PrintList(){
        objects = new ArrayList<>();
    }
    /**
     * Constructor with parameters for class PrintList.
     * @param objects This is an input Template List.
     */
    public PrintList(List<T> objects) {
        this.objects = new ArrayList<>(objects.size());
        this.objects.addAll(objects);
    }

    /**
     * This method prints all Template type objects.
     */
    public void printObjects() {
        for(T object : objects){
            PrintEditionInformation printEditionInformation = object.getPrintInformation();
            printEditionInformation.printEditionInformation();

            System.out.println();
        }
    }
}
