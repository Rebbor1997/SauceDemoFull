package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.ProductsPage;

import java.util.List;

public class ProductStep extends BaseStep {
    public ProductStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProductStep addItemToCart(String productName){
        new ProductsPage(browsersService, false).getItemAddToCartButton(productName).click();
        return this;
    }

    public ProductStep  addItemsToCart (List<String> itemsList) {
        for (String item: itemsList) {
            addItemToCart(item);
        }
        return this;
    }

    public CheckoutSteps moveToCart(){
        new ProductsPage(browsersService, false).cartBadgeClick();
        return new CheckoutSteps(browsersService);
    }
}
