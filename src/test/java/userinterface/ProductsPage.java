package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    public static final Target PRODUCTS_ORDER = Target.the("Products button").locatedBy("//select[@class='product_sort_container']");

}
