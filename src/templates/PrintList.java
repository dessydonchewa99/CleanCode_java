package templates;

import bookStore.PrintEditionInformation;

import java.util.List;

public class PrintList<T extends PrintEditionInformation> {
    private List<T> objects;

    public PrintList(List<T> objects) {
        this.objects = objects;
    }

    public void printObjects() {
        for(T object:objects){
            object.printEditionInformation();
        }
    }
}
