package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    public static final By userNameBox = By.name("username");
    public static final By passBox = By.name("password");
    public static final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void logIn(String user, String password){
        WebElement userNameInput = this.driver.findElement(LoginPage.userNameBox);
        userNameInput.sendKeys(user);
         WebElement passInput = this.driver.findElement(LoginPage.passBox);
        passInput.sendKeys(password);

        WebElement loginBtn = this.driver.findElement(LoginPage.loginButton);
        loginBtn.click();

    }
}
