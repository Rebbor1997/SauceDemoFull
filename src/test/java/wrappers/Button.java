package wrappers;

import core.BrowsersService;
import org.openqa.selenium.By;

public class Button {
    private final UIElement uiElement;

    public Button(BrowsersService browsersService, By by) {
        this.uiElement = new UIElement(browsersService, by);
    }

    public void click() {
        this.uiElement.click();
    }

    public void submit() {
        this.uiElement.submit();
    }

    public boolean isDisplayed() {
        return this.uiElement.isDisplayed();
    }
}
