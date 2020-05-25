package templates;

import java.util.Collections;
import java.util.List;

public class SortList<T extends Comparable<T>> {
    List<T> objects;

    public List<T> sort() {
        Collections.sort(objects);
        return objects;
    }
}
