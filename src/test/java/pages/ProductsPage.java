package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import wrappers.UIElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private final static String ENDPOINT = "/inventory.html";

    private final static By shoppingCartBtnSelector = By.id("shopping_cart_container");
    private final static String item_Add_To_Cart_Button = "//div[.='replace']/ancestor::div[@class= 'inventory_item_description']//button";
    private final static By productsTitle_By = By.xpath("//span[. = 'Products']");

    public ProductsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return getProductsTitle().isDisplayed();
    }

    public UIElement getItemAddToCartButton(String productName) {
        return new UIElement(browsersService, By.xpath(item_Add_To_Cart_Button.replace("replace", productName)));
    }

    public UIElement getCartBadge() {
        return new UIElement(browsersService, shoppingCartBtnSelector);
    }

    public UIElement getProductsTitle() {
        return new UIElement(browsersService, productsTitle_By);
    }


    // Atomic Methods
    public ProductsPage addItemToCart(String productName){
        getItemAddToCartButton(productName).click();
        return this;
    }

    public ProductsPage  addItemsToCart (List<String> itemsList) {
        for (String item: itemsList) {
            getItemAddToCartButton(item).click();
        }
        return this;
    }

    public ShoppingCartPage cartBadgeClick(){
        getCartBadge().click();
        return new ShoppingCartPage(browsersService, false);
    }


}
