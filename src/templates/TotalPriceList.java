package templates;

import bookStore.PricePerPrintEdition;

import java.util.List;

public class TotalPriceList<T extends PricePerPrintEdition>{
    private List<T> objects;
    private double price = 0;

    public TotalPriceList(List<T> objects) {
        this.objects = objects;
    }

    public double total() {
        for(T object : objects){
            price = price + object.calculatePricePerEdition();
        }

        return price;
    }
}
