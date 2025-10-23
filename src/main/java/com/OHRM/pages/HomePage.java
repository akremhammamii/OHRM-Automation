package com.OHRM.pages;

import com.OHRM.base.AbstractPage;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {
    private static final By DASHBOARD_HEADER = By.xpath("//h6[contains(text(),'Dashboard')]");
    private static final By WELCOME_MESSAGE = By.xpath("//p[@class='oxd-userdropdown-name']");

    public boolean isDashboardDisplayed() {
        return isDisplayed(DASHBOARD_HEADER);
    }

    public String getWelcomeMessage() {
        return getText(WELCOME_MESSAGE);
    }

    public String getDashboardHeaderText() {
        return getText(DASHBOARD_HEADER);
    }
}
