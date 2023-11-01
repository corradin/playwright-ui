# Playwright Studio notes

## Topic 1: Getting started with the Playwright UI mode

1. ```bash
   npm init -y
   ```
2. ```bash
   npm i -D @playwright/test
   ```
3. Create a file `/tests/playwright.test.ts` with the following contents:

   ```ts
   import { test, expect } from '@playwright/test';

   test('Should navigate to Playwright homepage', async ({ page }) => {
     await page.goto('https://playwright.dev/');
     await page.locator('text=GET STARTED').click();
     await expect(page).toHaveURL('https://playwright.dev/docs/intro');
   });
   ```

4. ```bash
   npx playwright test --ui
   ```
5. Run test -> Shows error because of missing browsers.
6. Install browsers.
7. Explore the UI further (explain the different tabs).
8. Show what happens when the test generates an error.

More on the UI mode can be found here: https://playwright.dev/docs/test-ui-mode

## Topic 2: Debugging your Playwright tests in the UI with Java

You could do this:

```java
Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
```

But then you miss all the stuff the trace viewer gives you.

1. Run it with maven:
   ```bash
   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
   ```
2. Or drag it to https://trace.playwright.dev (nothing is sent over the line, everything is kept local)
