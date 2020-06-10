package templates;
/**
 * Represents a TotalPriceList.
 * @author Desislava Dontcheva
 * @version 1.0
 */
import bookStore.PricePerPrintEdition;
import bookStore.PrintEdition;
import bookStore.PrintEditionInformation;

import java.util.ArrayList;
import java.util.List;

public class TotalPriceList<T extends PrintEdition>{
    private List<T> objects;

    /**
     * Default constructor for class TotalPriceList.
     */
    public TotalPriceList(){
        objects = new ArrayList<>();
    }
    /**
     * Constructor with parameters for class TotalPriceList.
     * @param objects This is an input Template List.
     */
    public TotalPriceList(List<T> objects) {
        this.objects = new ArrayList<>(objects.size());
        this.objects.addAll(objects);
    }

    /**
     * This method calculates the price of all Template type objects.
     * @return double This is the total price.
     */
    public double total() {
        double price = 0.0;
        for(T object : objects){
            PricePerPrintEdition pricePerPrintEdition = object.getPrintEditionPrice();
            price = price + pricePerPrintEdition.calculatePricePerEdition();
        }
        return price;
    }
}
