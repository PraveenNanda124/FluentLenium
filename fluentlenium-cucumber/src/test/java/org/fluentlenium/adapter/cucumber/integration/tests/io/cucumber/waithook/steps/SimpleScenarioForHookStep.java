package org.fluentlenium.adapter.cucumber.integration.tests.io.cucumber.waithook.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.adapter.cucumber.integration.tests.io.cucumber.waithook.page.LocalWithHookPage;
import org.fluentlenium.adapter.cucumber.integration.tests.io.cucumber.waithook.page.LocalWithHookPage2;
import org.fluentlenium.core.annotation.Page;

public class SimpleScenarioForHookStep extends FluentCucumberTest {

    @Page
    private LocalWithHookPage page;

    @Page
    private LocalWithHookPage2 page2;

    @Given(value = "scenario I am on the first Wait hook page")
    public void step1() {
        page.go();
    }

    @When(value = "scenario I click on next page")
    public void step2() {
        page.clickLink();
    }

    @Then(value = "scenario I am on the second Wait hook page")
    public void step3() {
        page2.isAt();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        before(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
        after(scenario);
    }
}
