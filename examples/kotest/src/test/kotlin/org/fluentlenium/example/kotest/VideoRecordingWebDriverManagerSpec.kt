package org.fluentlenium.example.kotest

import io.github.bonigarcia.wdm.WebDriverManager
import io.kotest.core.spec.Spec
import io.kotest.matchers.paths.shouldExist
import io.kotest.matchers.string.shouldContain
import org.fluentlenium.adapter.kotest.FluentFreeSpec
import org.openqa.selenium.WebDriver
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.exists

/**
 * This test demonstrates how to use Fluentlenium in combination
 * with a Docker/Chrome container (managed by WebDriverManager)
 * that hosts the browser.
 *
 * check https://github.com/bonigarcia/webdrivermanager#browsers-in-docker
 */
class VideoRecordingWebDriverManagerSpec : FluentFreeSpec() {

    /**
     * directory to save the videos to
     */
    private val videoDirectory = Path("build/videos")

    private val wdm =
        WebDriverManager.chromedriver()
            .browserInDocker()
            .enableVnc()
            .dockerRecordingOutput(videoDirectory)
            .enableRecording()

    override suspend fun beforeSpec(spec: Spec) {
        if (!videoDirectory.exists()) {
            videoDirectory.createDirectory()
        }
        videoDirectory.shouldExist()
    }

    override fun newWebDriver(): WebDriver =
        wdm.create()

    private val SEARCH_TEXT = "FluentLenium"

    init {
        "Title of duck duck go" {
            goTo("https://duckduckgo.com")

            el("#search_form_input_homepage").fill().with(SEARCH_TEXT)
            el("#search_button_homepage").submit()
            await().untilWindow(SEARCH_TEXT)

            window().title() shouldContain SEARCH_TEXT
        }
    }
}
