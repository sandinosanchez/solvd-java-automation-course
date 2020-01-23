package webtesting.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import webtesting.AbstractUiTest;
import webtesting.pages.HomePage;
import webtesting.pages.BrowseProductsPage;
import webtesting.pages.LoginPage;

public class AutomationPracticeLoginTest extends AbstractUiTest {

    @Override
    protected String getBaseUrl() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

    @Test
    public void login() {
        HomePage homePage = new LoginPage(getDriver()).login("jokokoj@gmail.com", "12345");
        assertEquals(homePage.getSubTitle(), "MY ACCOUNT");
    }

    @Test
    public void loginAndAddToCart() {
        BrowseProductsPage browserProductsPage = new LoginPage(getDriver())
                .login("jokokoj@gmail.com", "12345")
                .tShirtSearch();

        browserProductsPage.addTshirtToCart();
        assertEquals(browserProductsPage
                        .getConfirmationText(),
                "Product successfully added to your shopping cart");
    }
}
