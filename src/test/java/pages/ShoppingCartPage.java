package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import wrappers.Button;
import wrappers.UIElement;



public class ShoppingCartPage extends BasePage {
    private final static String endpoint = "/cart.html";

    private final static By cart_Quantity_Identifier_By = By.className("cart_quantity");
    private final static By cart_Added_Item_Price_By = By.className("inventory_item_price");
    private final static String cart_item_Remove_Button = "//div[.='replace']/following::div[@class='item_pricebar']//button";
    private final static By cart_Continue_Shopping_Button_By = By.id("continue-shopping");
    private final static By cart_Removed_Item_Identifier_By = By.className("removed_cart_item");
    private final static By cart_Checkout_Button_By = By.id("checkout");
    private final static By items_Count_By = By.className("cart_item");

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getCartQuantityIdentifier().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public ShoppingCartPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    public UIElement getCartQuantityIdentifier() {
        return new UIElement(browsersService, cart_Quantity_Identifier_By);
    }

    public UIElement getPriceOfAddedItem() {
        return new UIElement(browsersService, cart_Added_Item_Price_By);
    }

    public Button getRemoveItemButton(String productName) {
        return new Button(browsersService, By.xpath(cart_item_Remove_Button.replace("replace", productName)));
    }

    public UIElement getContinueShoppingButton() {
        return new UIElement(browsersService, cart_Continue_Shopping_Button_By);
    }

    public UIElement getRemovedCartItemIdentifier() {
        return new UIElement(browsersService, cart_Removed_Item_Identifier_By);
    }

    public UIElement getCheckoutButton() {
        return new UIElement(browsersService, cart_Checkout_Button_By);
    }

    public int getItemsCount() {
        return browsersService.getDriver().findElements(items_Count_By).size();
    }


    //atomic methods
    public String displayQuantityText() {
        return getCartQuantityIdentifier().getText();
    }

    public String displayTextPriceOfAddedItemInCart() {
        return getPriceOfAddedItem().getText();
    }

    public ShoppingCartPage removeButtonClick(String productName) {
        getRemoveItemButton(productName).click();
        return this;
    }

    public void clickContinueShoppingButton() {
        getContinueShoppingButton().click();
    }

    public CheckoutInfoPage checkoutButtonClick() {
        getCheckoutButton().click();
        return new CheckoutInfoPage(browsersService, false);
    }
}