package templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList<T extends Comparable<T>> {
    List<T> objects;

    public SortList(){
        objects = new ArrayList<>();
    }
    public SortList(List<T> objects){
        this.objects = new ArrayList<>(objects.size());
        for(T object: objects){
            this.objects.add(object);
        }
    }

    public List<T> sort() {
        Collections.sort(objects);
        return objects;
    }
}
