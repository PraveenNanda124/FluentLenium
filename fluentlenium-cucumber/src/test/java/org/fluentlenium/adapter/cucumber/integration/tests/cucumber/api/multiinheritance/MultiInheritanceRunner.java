package org.fluentlenium.adapter.cucumber.integration.tests.cucumber.api.multiinheritance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:org/fluentlenium/adapter/cucumber/integration/tests/scenario",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MultiInheritanceRunner {
    @BeforeClass
    public static void setUpChrome() {
        WebDriverManager.chromedriver().setup();
    }
}
