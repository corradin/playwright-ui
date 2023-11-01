import { test, expect } from '@playwright/test';

test('Should navigate to Playwright homepage', async ({ page }) => {
  await page.goto('https://playwright.dev/');

  await page.getByRole('link', {name: 'GET STARTED'}).click();

  await expect(page).toHaveURL('https://playwright.dev/docs/intro');
});