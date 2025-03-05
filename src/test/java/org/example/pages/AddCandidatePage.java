package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCandidatePage {
    WebDriver driver;
    public static final By firstNameBox = By.name("firstName");
    public static final By middleNameBox = By.name("middleName");
    public static final By lastNameBox = By.name("lastName");
    public static final By emailBox = By.xpath("(//input[@placeholder='Type here'])[1]");
    public static final By phoneNumber = By.xpath("(//input[@placeholder='Type here'])[2]");
    public static final By selects = By.className("oxd-select-text-input");

    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCandidate(String firstName,String middleName,String lastName,
                             String email,String contactNumber) {
        driver.findElement(firstNameBox).sendKeys(firstName);
        driver.findElement(middleNameBox).sendKeys(middleName);
        driver.findElement(lastNameBox).sendKeys(lastName);
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(phoneNumber).sendKeys(contactNumber);
        //String select = new SelectElement(driver.findElement(selects));


    }

}
