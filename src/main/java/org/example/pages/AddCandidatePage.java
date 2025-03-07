package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCandidatePage {
    WebDriver driver;
    public static final By firstNameBox = By.name("firstName");
    public static final By middleNameBox = By.name("middleName");
    public static final By lastNameBox = By.name("lastName");
    public static final By emailBox = By.xpath("(//input[@placeholder='Type here'])[1]");
    public static final By phoneNumber = By.xpath("(//input[@placeholder='Type here'])[2]");

    public static final By selects = By.xpath("//div[@class='oxd-select-text-input']");
    public static final By keepData = By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
    //public static final By dateBox = By.xpath("//input[@placeholder='yyyy-dd-mm']");
    public static final By okButton = By.xpath("//button[@type='submit']");

    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCandidate(String firstName,String middleName,String lastName,
                             String email,String contactNumber,String vacancy) {
        driver.findElement(firstNameBox).sendKeys(firstName);
        driver.findElement(middleNameBox).sendKeys(middleName);
        driver.findElement(lastNameBox).sendKeys(lastName);
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(phoneNumber).sendKeys(contactNumber);
        WebElement vac = this.driver.findElement(selects);
        vac.click();

        By vacancies = By.xpath("//*[normalize-space()=" + "'" + vacancy + "']");
        driver.findElement(vacancies).click();

        driver.findElement(keepData).click();
        //driver.findElement(dateBox).sendKeys(date);

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } ;

        driver.findElement(okButton).click();


    }

}
