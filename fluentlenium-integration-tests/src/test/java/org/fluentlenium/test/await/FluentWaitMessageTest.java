package org.fluentlenium.test.await;

import org.assertj.core.api.ThrowableAssert;
import org.fluentlenium.core.annotation.Label;
import org.fluentlenium.core.annotation.LabelHint;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.wait.FluentWait;
import org.fluentlenium.test.IntegrationFluentTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FluentWaitMessageTest extends IntegrationFluentTest {
    @FindBy(css = "#disabled")
    private FluentWebElement disabled;

    @FindBy(css = "#disabled")
    private FluentList<FluentWebElement> disabledList;

    @FindBy(css = "#disabled")
    @Label
    private FluentWebElement disabledDefaultLabel;

    @FindBy(css = "#disabled")
    @Label
    private FluentList<FluentWebElement> disabledDefaultLabelList;

    @FindBy(css = "#disabled")
    @Label("custom")
    @LabelHint("hint")
    private FluentWebElement disabledCustomLabel;

    @FindBy(css = "#disabled")
    @Label("custom")
    @LabelHint("hint")
    private FluentList<FluentWebElement> disabledCustomLabelList;

    @Override
    public FluentWait await() {
        return super.await().atMost(100).pollingEvery(10);
    }

    @Test
    void testDisabled() {
        goTo(DEFAULT_URL);
        FluentWebElement first = $("#disabled").first();
        assertThat(first).hasToString("By.cssSelector: #disabled (first) (Lazy Element)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> first.await().until().enabled();
        assertThatThrownBy(throwingCallable).hasMessageStartingWith(
                "Expected condition failed: Element By.cssSelector: #disabled (first) (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();

        assertThatThrownBy(throwingCallable).hasMessageContaining(
                "is not enabled").isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testDisabledInjection() {
        goTo(DEFAULT_URL);
        FluentWebElement first = disabled;
        assertThat(first).hasToString("By.cssSelector: #disabled (first) (Lazy Element)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> first.await().until().enabled();
        assertThatThrownBy(throwingCallable).hasMessageStartingWith(
                "Expected condition failed: Element By.cssSelector: #disabled (first) (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();
        assertThatThrownBy(throwingCallable).hasMessageContaining("is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testDisabledDefaultLabelInjection() {
        goTo(DEFAULT_URL);
        FluentWebElement first = disabledDefaultLabel;
        assertThat(first).hasToString("FluentWaitMessageTest.disabledDefaultLabel (Lazy Element)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> first.await().until().enabled();
        assertThatThrownBy(throwingCallable).hasMessageStartingWith(
                "Expected condition failed: Element FluentWaitMessageTest.disabledDefaultLabel (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();

        assertThatThrownBy(throwingCallable).hasMessageContaining(
                "is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testDisabledCustomLabelInjection() {
        goTo(DEFAULT_URL);
        FluentWebElement first = disabledCustomLabel;
        assertThat(first).hasToString("custom [hint] (Lazy Element)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> first.await().until().enabled();
        assertThatThrownBy(throwingCallable)
                .hasMessageStartingWith("Expected condition failed: Element custom [hint] (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        first.now();

        assertThatThrownBy(throwingCallable).hasMessageContaining(
                "is not enabled").isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testDisabledList() {
        goTo(DEFAULT_URL);
        FluentList<FluentWebElement> list = $("#disabled");
        assertThat(list).hasToString("By.cssSelector: #disabled (Lazy Element List)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> list.await().until().enabled();
        assertThatThrownBy(throwingCallable).hasMessageStartingWith(
                "Expected condition failed: Elements By.cssSelector: #disabled (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();
        assertThatThrownBy(throwingCallable).hasMessageContaining("is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testDisabledListInjection() {
        goTo(DEFAULT_URL);
        FluentList<FluentWebElement> list = disabledList;
        assertThat(list).hasToString("By.cssSelector: #disabled (Lazy Element List)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> list.await().until().enabled();
        assertThatThrownBy(throwingCallable).hasMessageStartingWith(
                "Expected condition failed: Elements By.cssSelector: #disabled (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();

        assertThatThrownBy(throwingCallable).hasMessageContaining(
                "is not enabled").isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    void testDisabledDefaultLabelListInjection() {
        goTo(DEFAULT_URL);
        FluentList<FluentWebElement> list = disabledDefaultLabelList;
        assertThat(list).hasToString("FluentWaitMessageTest.disabledDefaultLabelList (Lazy Element List)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> list.await().until().enabled();
        assertThatThrownBy(throwingCallable).hasMessageStartingWith(
                "Expected condition failed: Elements FluentWaitMessageTest.disabledDefaultLabelList (Lazy Element List) is not "
                        + "enabled").isExactlyInstanceOf(TimeoutException.class);

        list.now();

        assertThatThrownBy(throwingCallable).hasMessageContaining("is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    void testDisabledCustomLabelListInjection() {
        goTo(DEFAULT_URL);
        FluentList<FluentWebElement> list = disabledCustomLabelList;
        assertThat(list).hasToString("custom [hint] (Lazy Element List)");
        ThrowableAssert.ThrowingCallable throwingCallable = () -> list.await().until().enabled();
        assertThatThrownBy(throwingCallable)
                .hasMessageStartingWith("Expected condition failed: Elements custom [hint] (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);

        list.now();
        assertThatThrownBy(throwingCallable).hasMessageContaining(
                "is not enabled").isExactlyInstanceOf(TimeoutException.class);

    }

    @Test
    void testMessageContext() {
        goTo(DEFAULT_URL);
        FluentWebElement select = $("#select").first();

        assertThatThrownBy(() -> select.await().until().rectangle().width().lessThan(0))
                .hasMessageContaining("width is not less than 0 (actual: 65)")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testMessageContextList() {
        goTo(DEFAULT_URL);
        FluentList<FluentWebElement> select = $("#select");

        assertThatThrownBy(() -> select.await().until().rectangle().width().lessThan(0))
                .hasMessageContaining("rectangle width is not less than 0 (actual: [65])")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testMessageContextWithLabel() {
        goTo(DEFAULT_URL);
        FluentWebElement select = $("#select").first().withLabel("My Value Select").withLabelHint("hint1", "hint2");

        assertThatThrownBy(() -> select.await().until().rectangle().width().lessThan(0)).hasMessageStartingWith(
                "Expected condition failed: Element My Value Select [hint1, hint2] rectangle width is not less than 0 (actual: "
                        + "65)").isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testMessageContextWithLabelBefore() {
        goTo(DEFAULT_URL);
        FluentWebElement select = $("#select").withLabel("My Value Select").withLabelHint("hint1", "hint2").first();

        assertThatThrownBy(() -> select.await().until().rectangle().width().lessThan(0))
                .hasMessageContaining("rectangle width is not less than 0 (actual: 65)")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testNotFound() {
        goTo(DEFAULT_URL);
        FluentWebElement first = $("#not-found").first();
        assertThat(first).hasToString("By.cssSelector: #not-found (first) (Lazy Element)");
        assertThatThrownBy(() -> first.await().until().enabled()).hasMessageStartingWith(
                "Expected condition failed: Element By.cssSelector: #not-found (first) (Lazy Element) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }

    @Test
    void testNotFoundList() {
        goTo(DEFAULT_URL);
        FluentList<FluentWebElement> list = $("#not-found");
        assertThat(list).hasToString("By.cssSelector: #not-found (Lazy Element List)");
        assertThatThrownBy(() -> list.await().until().enabled()).hasMessageStartingWith(
                "Expected condition failed: Elements By.cssSelector: #not-found (Lazy Element List) is not enabled")
                .isExactlyInstanceOf(TimeoutException.class);
    }
}
