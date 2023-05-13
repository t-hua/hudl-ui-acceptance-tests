package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


import java.io.File;
import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesManager;


public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    Scenario scenario;

    @Before
    public void logScenarioName(Scenario scenario) {
        this.scenario = scenario;
        log.info("-------" + scenario.getName() + "-------");
    }

    @Before
    public void setUp() {
        setUpDriver();
        open(PropertiesManager.getProperty("base.url"));
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        embedScreenshotIfFail(scenario);
        closeWebDriver();
    }

    private void setUpDriver() {
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;

    }

    private void embedScreenshotIfFail(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshotFile = Screenshots.takeScreenShotAsFile();

            byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
    }

}
