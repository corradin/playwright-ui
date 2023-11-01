package org.tests;

import com.microsoft.playwright.*;

import org.testng.Assert;
import org.testng.annotations.*;
import java.nio.file.Paths;

public class ExampleTest {
    @Test
    void exampleTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("http://playwright.dev");

            page.getByText("GET STARTED").click();

            Assert.assertEquals(page.url(), "https://playwright.dev/docs/intro");

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}