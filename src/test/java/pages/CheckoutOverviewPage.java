package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {
    private final static String endpoint = "checkout-step-two.html";

    private final static By checkout_Overview_Title_By = By.xpath("//span[@class ='title']");
    private final static By checkout_Finish_By = By.id("finish");

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getOverviewMessage().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public CheckoutOverviewPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    //Атомарные методы
    public WebElement getOverviewMessage() {
        return browsersService.getDriver().findElement(checkout_Overview_Title_By);
    }

    public WebElement getFinishButton() {
        return browsersService.getDriver().findElement(checkout_Finish_By);
    }

    public String displayOverviewMessage() {
        return getOverviewMessage().getText().toUpperCase();
    }

    public CheckoutCompletionPage finishButtonClick() {
        getFinishButton().click();
        return new CheckoutCompletionPage(browsersService, false);
    }
}
