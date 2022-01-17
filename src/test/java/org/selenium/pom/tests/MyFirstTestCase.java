package org.selenium.pom.tests;

import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MyFirstTestCase extends BaseTest {

    @Test public void guestCheckoutUsingDirectBankTransfer()
        throws IOException, InterruptedException {
//        BillingAddress billingAddress =
//            new BillingAddress().setFirstName("demo").setLastName("user")
//                .setAddressLineOne("7th Street").setCity("San Francisco").setPostalCode(94188)
//                .setEmail("askomdch@gmail.com");
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("MyBillingAddress.json",BillingAddress.class);
        Product product = new Product(1215);
//        BillingAddress billingAddress =
//            new BillingAddress("demo", "user", "7th street", "San Francisco", 94188,
//                "askomdch@gmail.com");
        StorePage storePage =
            new HomePage(getDriver()).load().navigateToStoreUsingMenu();
        storePage.isLoaded();
                storePage.enterTextInSearchFld(searchFor)
                .clickSearchBtn();
        Thread.sleep(5000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+ searchFor + "”");
//        assertEquals(storePage.getTitle(), "Search results: “"+ searchFor + "”");
        CartPage cartPage = storePage.clickAddToCartBtn(product.getName()).clickViewCart();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
//        assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.setBillingAddress(billingAddress)
                    .selectDirectBankTransfer()
                    .placeOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
//        assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test public void loginAndCheckoutUsingDirectBankTransfer()
        throws IOException, InterruptedException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("MyBillingAddress.json",BillingAddress.class);
        Product product = new Product(1215);
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance()
            .getPassword());
        StorePage storePage =
            new HomePage(getDriver())
                .load()
                .navigateToStoreUsingMenu();
        storePage.isLoaded();
                storePage.enterTextInSearchFld(searchFor)
                .clickSearchBtn();
        Thread.sleep(5000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+ searchFor + "”");
//        assertEquals("Search results: “"+ searchFor + "”",storePage.getTitle());

        CartPage cartPage = storePage.clickAddToCartBtn(product.getName()).clickViewCart();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
//        assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.
            clickHereToLoginLink().
            enterUserName(user.getUsername()).
            enterPassword(user.getPassword()).
            setBillingAddress(billingAddress).
            selectDirectBankTransfer().
            placeOrder();
//        checkoutPage.clickHereToLoginLink().login("Karthi", "Ganesh@24").enterFirstName("demo")
//            .enterLastName("user").enterAddress1("7th Street").enterCity("San Franciso")
//            .enterPostalCode(54231).enterEmail("askomdch@gmail.com").clickPlaceOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
//        assertEquals("Thank you. Your order has been received.",checkoutPage.getNotice());
    }
}
