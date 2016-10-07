package org.fluentlenium.core.events;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Listener interface for events.
 */
public interface EventListener {

    /**
     * Called before {@link org.openqa.selenium.WebDriver#get get(String url)} respectively
     * {@link org.openqa.selenium.WebDriver.Navigation#to navigate().to(String url)}.
     *
     * @param url    URL
     * @param driver WebDriver
     */
    void beforeNavigateTo(String url, WebDriver driver);

    /**
     * Called after {@link org.openqa.selenium.WebDriver#get get(String url)} respectively
     * {@link org.openqa.selenium.WebDriver.Navigation#to navigate().to(String url)}. Not called, if
     * an
     * exception is thrown.
     *
     * @param url    URL
     * @param driver WebDriver
     */
    void afterNavigateTo(String url, WebDriver driver);

    /**
     * Called before {@link org.openqa.selenium.WebDriver.Navigation#back navigate().back()}.
     *
     * @param driver WebDriver
     */
    void beforeNavigateBack(WebDriver driver);

    /**
     * Called after {@link org.openqa.selenium.WebDriver.Navigation navigate().back()}. Not called,
     * if an
     * exception is thrown.
     *
     * @param driver WebDriver
     */
    void afterNavigateBack(WebDriver driver);

    /**
     * Called before {@link org.openqa.selenium.WebDriver.Navigation#forward navigate().forward()}.
     *
     * @param driver WebDriver
     */
    void beforeNavigateForward(WebDriver driver);

    /**
     * Called after {@link org.openqa.selenium.WebDriver.Navigation#forward navigate().forward()}.
     * Not called,
     * if an exception is thrown.
     *
     * @param driver WebDriver
     */
    void afterNavigateForward(WebDriver driver);

    /**
     * Called before {@link WebDriver#findElement WebDriver.findElement(...)}, or
     * {@link WebDriver#findElements WebDriver.findElements(...)}, or {@link org.openqa.selenium.WebElement#findElement
     * WebElement.findElement(...)}, or {@link org.openqa.selenium.WebElement
     * #findElement WebElement.findElements(...)}.
     *
     * @param element will be <code>null</code>, if a find method of <code>WebDriver</code> is called.
     * @param by      locator being used
     * @param driver  WebDriver
     */
    void beforeFindBy(By by, FluentWebElement element, WebDriver driver);

    /**
     * Called after {@link WebDriver#findElement WebDriver.findElement(...)}, or
     * {@link WebDriver#findElements WebDriver.findElements(...)}, or {@link org.openqa.selenium.WebElement#findElement
     * WebElement.findElement(...)}, or {@link org.openqa.selenium.WebElement#findElement WebElement.findElements(...)}.
     *
     * @param element will be <code>null</code>, if a find method of <code>WebDriver</code> is called.
     * @param by      locator being used
     * @param driver  WebDriver
     */
    void afterFindBy(By by, FluentWebElement element, WebDriver driver);

    /**
     * Called before {@link org.openqa.selenium.WebElement#click WebElement.click()}.
     *
     * @param driver  WebDriver
     * @param element the WebElement being used for the action
     */
    void beforeClickOn(FluentWebElement element, WebDriver driver);

    /**
     * Called after {@link org.openqa.selenium.WebElement#click WebElement.click()}. Not called, if an exception is
     * thrown.
     *
     * @param driver  WebDriver
     * @param element the WebElement being used for the action
     */
    void afterClickOn(FluentWebElement element, WebDriver driver);

    /**
     * Called before {@link org.openqa.selenium.WebElement#clear WebElement.clear()},
     * {@link org.openqa.selenium.WebElement#sendKeys},
     * {@link org.openqa.selenium.WebElement#sendKeys(CharSequence...)}.
     *
     * @param element      the WebElement being used for the action
     * @param driver       WebDriver
     * @param charSequence value of the element
     */
    void beforeChangeValueOf(FluentWebElement element, WebDriver driver, CharSequence[] charSequence);

    /**
     * Called after {@link org.openqa.selenium.WebElement#clear WebElement.clear()},
     * {@link org.openqa.selenium.WebElement#sendKeys},
     * {@link org.openqa.selenium.WebElement#sendKeys(CharSequence...)} . Not called, if an exception is thrown.
     *
     * @param element      the WebElement being used for the action
     * @param driver       WebDriver
     * @param charSequence value of the element
     */
    void afterChangeValueOf(FluentWebElement element, WebDriver driver, CharSequence[] charSequence);

    /**
     * Called before
     * {@link org.openqa.selenium.remote.RemoteWebDriver#executeScript(String, Object[]) }
     *
     * @param driver WebDriver
     * @param script the script to be executed
     */
    // Previously: Called before {@link WebDriver#executeScript(String)}
    // See the same issue below.
    void beforeScript(String script, WebDriver driver);

    /**
     * Called after
     * {@link org.openqa.selenium.remote.RemoteWebDriver#executeScript(String, Object[]) }
     * .
     * Not called if an exception is thrown
     *
     * @param driver WebDriver
     * @param script the script that was executed
     */
    // Previously: Called after {@link WebDriver#executeScript(String)}. Not called if an exception
    // is thrown
    // So someone should check if this is right. There is no executeScript method
    // in WebDriver, but there is in several other places, like this one
    void afterScript(String script, WebDriver driver);

    /**
     * Called whenever an exception would be thrown.
     *
     * @param driver    WebDriver
     * @param throwable the exception that will be thrown
     */
    void onException(Throwable throwable, WebDriver driver);

    /**
     * Called before {@link org.openqa.selenium.WebDriver.Navigation#refresh navigate().refresh()}.
     *
     * @param driver WebDriver
     */
    void beforeNavigateRefresh(WebDriver driver);

    /**
     * Called after {@link org.openqa.selenium.WebDriver.Navigation#refresh navigate().refresh()}. Not called,
     * if an exception is thrown.
     *
     * @param driver WebDriver
     */
    void afterNavigateRefresh(WebDriver driver);
}
