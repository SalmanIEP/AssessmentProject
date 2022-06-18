package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class VehicleDetailsPage {
    WebDriver driver;
    public VehicleDetailsPage(WebDriver driver){

        this.driver = driver;

    }

    By RegistrationNumber = By.xpath("//dt[contains(text(),'Registration')]/following-sibling::dd[1]");
    By Make = By.xpath("//dt[contains(text(),'Make')]/following-sibling::dd[1]");
    By Model = By.xpath("//dt[contains(text(),'Model')]/following-sibling::dd[1]");
    By Colour = By.xpath("//dt[contains(text(),'Colour')]/following-sibling::dd[1]");
    By Year = By.xpath("//dt[contains(text(),'Year')]/following-sibling::dd[1]");


    public Map<String,String> getDisplayedVehicleRecords(){

        Map<String,String> displayedRecords = new HashMap<>();
        displayedRecords.put("REGISTRATION", driver.findElement(RegistrationNumber).getText());
        displayedRecords.put("MAKE", driver.findElement(Make).getText());
        displayedRecords.put("MODEL", driver.findElement(Model).getText());
        displayedRecords.put("COLOUR", driver.findElement(Colour).getText());
        displayedRecords.put("YEAR", driver.findElement(Year).getText());

        return displayedRecords;
    }

}
