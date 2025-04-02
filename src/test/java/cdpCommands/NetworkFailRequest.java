package cdpCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.fetch.Fetch;
import org.openqa.selenium.devtools.v129.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v129.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkFailRequest {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();



        Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(),Optional.empty())));

        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request->
        {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));

        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");


        WebElement button_library = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button_library.click();

    }
}
