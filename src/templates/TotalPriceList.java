package templates;

import bookStore.PricePerPrintEdition;
import bookStore.PrintEdition;
import bookStore.PrintEditionInformation;

import java.util.ArrayList;
import java.util.List;

public class TotalPriceList<T extends PrintEdition>{
    private List<T> objects;

    public TotalPriceList(){
        objects = new ArrayList<>();
    }

    public TotalPriceList(List<T> objects) {
        this.objects = new ArrayList<>(objects.size());
        for(T object: objects){
            this.objects.add(object);
        }
    }

    public double total() {
        double price = 0.0;
        for(T object : objects){
            PricePerPrintEdition pricePerPrintEdition = object.getPrintEditionPrice();
            price = price + pricePerPrintEdition.calculatePricePerEdition();
        }
        return price;
    }
}
