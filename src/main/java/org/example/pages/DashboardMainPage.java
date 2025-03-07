package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardMainPage {

    WebDriver driver;

    public DashboardMainPage(WebDriver driver) {
        this.driver = driver;
    }


    public static final By recruitmentModule = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)");

    public void accessRecruitmentModule() {
        WebElement recModule = this.driver.findElement(DashboardMainPage.recruitmentModule);


        recModule.click();

    }



}
