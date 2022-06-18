import driver.BrowserOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.VehicleDetailsPage;
import utils.CarDetails;
import utils.Log;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class VehicleVerification {


    Map<String,String> expectedVehicleDetails;
    Map<String,String> displayedVehicleDetails;
    List<String> regNumbers;
    WebDriver driver;

    @BeforeTest
    public void Before(){

        driver = new ChromeDriver(BrowserOptions.chromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void vehicleDataVerificationTest() throws IOException {
        Log.info("Getting all Registration numbers from the input file");
        regNumbers= CarDetails.getUKCarsRegistrationNumber("car_input");
        for (String number:regNumbers) {
            Log.info("Fetching vehicle records for the Registration number from the output file "+ number);
            expectedVehicleDetails = CarDetails.getExpectedCarDetails("car_output",number);
            driver.get("https://cartaxcheck.co.uk/free-car-check/?vrm="+number);
            VehicleDetailsPage vd = new VehicleDetailsPage(driver);
            displayedVehicleDetails = vd.getDisplayedVehicleRecords();
            Log.info("verifying Vehicle REGISTRATION");
            Assert.assertEquals(expectedVehicleDetails.get("REGISTRATION"),displayedVehicleDetails.get("REGISTRATION"));
            Log.info("verifying Vehicle Year");
            Assert.assertEquals(expectedVehicleDetails.get("YEAR"),displayedVehicleDetails.get("YEAR"));
            Log.info("verifying Vehicle Colour");
            Assert.assertEquals(expectedVehicleDetails.get("COLOUR"),displayedVehicleDetails.get("COLOUR"));
            Log.info("verifying Vehicle Model");
            Assert.assertEquals(expectedVehicleDetails.get("MODEL"),displayedVehicleDetails.get("MODEL"));
            Log.info("verifying Vehicle Make");
            Assert.assertEquals(expectedVehicleDetails.get("MAKE"),displayedVehicleDetails.get("MAKE"));
        }


    }

}
