package steps;

import baseEntities.BaseStep;
import core.BrowsersService;

import pages.CheckoutCompletionPage;
import pages.ShoppingCartPage;

public class CheckoutSteps extends BaseStep {
    public CheckoutSteps(BrowsersService browsersService) {
        super(browsersService);
    }

        public CheckoutCompletionPage completeOrder () {
            return new ShoppingCartPage(browsersService, false)
                    .checkoutButtonClick()
                    .setFirstNameInput("Bob")
                    .setLastNameInput("Fil")
                    .setZipcodeInput("2345")
                    .continueButtonClick()
                    .finishButtonClick();
        }
}

