package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CarPage extends PageObject {
    public static Target DELETE_FROM_CART_BUTTON(String productName) {
        return Target.the("Remove from cart button")
                .locatedBy(String.format(
                        "//div[@class='cart_item_label']//div[@class='inventory_item_name'][text()='%s']/ancestor::div[@class='cart_item']//button[contains(@class, 'cart_button')]",
                        productName
                ));
    }


}
