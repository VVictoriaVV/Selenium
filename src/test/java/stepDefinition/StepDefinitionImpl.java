package stepDefinition;

import com.markeplace.LandingPage;
import com.marketplace.tests.AuthorisationTest;
import com.rahulshettyacademy.tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepDefinitionImpl extends BaseTest {
    public LandingPage landingPage;


    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() {
        AuthorisationTest authorisationTest = new AuthorisationTest();
        authorisationTest.launchApplication();
    }

    @Given("^Logged with  name  (.+)  and password password  (.+)$")
    public void logged_in_name_and_password(String name, String password) {
       landingPage.Login(name, password);
    }



    @When("^I add the product (.+) to Cart$")
    public void i_add_the_product_to_cart() {
        List<WebElement> boxOfThing = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
        WebElement product = boxOfThing.stream().filter(s ->
                s.findElement(By.xpath("//h5/b[text()='ADIDAS ORIGINAL']")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
        WebElement addToCart = product.findElement(By.xpath("//div[@class='card-body']/button[@class='btn w-10 rounded']"));
        System.out.println(addToCart);
        addToCart.click();
    }
    //@Then("")

}
