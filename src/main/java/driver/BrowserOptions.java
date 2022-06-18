package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class BrowserOptions {

    public static FirefoxOptions firefoxOptions(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\driver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("permissions.default.microphone", 1);
        options.addPreference("permissions.default.camera", 1);

        return options;

    }

    public static ChromeOptions chromeOptions(){

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_setting_values.media_stream_mics", 1);
        chromePrefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        chromePrefs.put("profile.default_content_setting_values.geolocation", 1);
        chromePrefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs",chromePrefs);
        options.addArguments("use-fake-ui-for-media-stream");
        options.addArguments("window-size=1551,839");
        return options;

    }
}
