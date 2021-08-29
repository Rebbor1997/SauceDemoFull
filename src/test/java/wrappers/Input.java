package wrappers;

import core.BrowsersService;
import org.openqa.selenium.By;

public class Input {
    private final UIElement uiElement;

    public Input(BrowsersService browsersService, By by) {
        this.uiElement = new UIElement(browsersService, by);
    }

    public void sendKeys(CharSequence... charSequences){
        uiElement.sendKeys(charSequences);
    }

    public boolean isDisplayed(){
        return uiElement.isDisplayed();
    }
}
