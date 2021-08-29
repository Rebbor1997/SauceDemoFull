package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginStep extends BaseStep {

    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProductStep successLogin(User user){
         new LoginPage(browsersService, true)
                .setUserName(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginButtonClick();
        return new ProductStep (browsersService);
    }

    public LoginStep incorrectLogin(User user){
      new LoginPage(browsersService, true)
                .setUserName(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginButtonClick();
        return this;
    }
}
