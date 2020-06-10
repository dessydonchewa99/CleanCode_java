package templates;
/**
 * Represents a SortList.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList<T extends Comparable<T>> {

    List<T> objects;

    /**
     * Default constructor for class SortList.
     */
    public SortList(){
        objects = new ArrayList<>();
    }
    /**
     * Constructor with parameters for class SortList.
     * @param objects This is an input Template List.
     */
    public SortList(List<T> objects){
        this.objects = new ArrayList<>(objects.size());
        this.objects.addAll(objects);
    }

    /**
     * This method sorts all Template type objects.
     * @return objects This is the sorted list.
     */
    public List<T> sort() {
        Collections.sort(objects);
        return objects;
    }
}
