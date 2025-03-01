package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    public static final Target PRODUCTS_ORDER = Target.the("Products button").locatedBy("//select[@class='product_sort_container']");

    public static Target ADD_TO_CART_BUTTON(String productName) {
        return Target.the("Add to cart button")
                .locatedBy(String.format("//div[@class='inventory_item']//div[@class='inventory_item_name'][text()='%s']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]", productName));
    }

}
