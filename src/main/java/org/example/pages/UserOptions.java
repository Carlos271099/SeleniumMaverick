package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserOptions {

    WebDriver driver;

    public static final By usersOption = By.className("oxd-userdropdown");
    public static final By logoutOption = By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]");

    public UserOptions(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        this.driver.findElement(usersOption).click();
        this.driver.findElement(logoutOption).click();
        System.out.println("Logged out successfully");
    }

}
