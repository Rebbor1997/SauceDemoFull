package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;

import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Input;
import wrappers.UIElement;

public class LoginPage extends BasePage {
    private final static String endpoint = "/";

    private final static By usernameSelector = By.id("user-name");
    private final static By passwordSelector = By.id("password");
    private final static By loginBtnSelector = By.id("login-button");
    private final static By errorMessageSelector = By.cssSelector(".error-message-container.error h3");

    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        return new UIElement(browsersService, loginBtnSelector).isDisplayed();
    }

    public Input getUsernameField() {
        return new Input(browsersService, usernameSelector);
    }

    public Input getPasswordField() {
        return new Input(browsersService, passwordSelector);
    }

    public Button getLoginButton() {
        return new Button(browsersService, loginBtnSelector);
    }

    public UIElement getErrorMessage() {
        return new UIElement(browsersService, errorMessageSelector);
    }

    // Атомарные методы
    public LoginPage setUserName (String userName){
        getUsernameField().sendKeys(userName);
        return this;
    }

    public LoginPage setPassword (String password){
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage loginButtonClick(){
        getLoginButton().click();
        return this;
    }

    public ProductsPage successLoginButtonClick(){
        loginButtonClick();
        return new ProductsPage(browsersService, false);
    }
}
