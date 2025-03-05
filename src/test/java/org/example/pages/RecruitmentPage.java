package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecruitmentPage {


    public static final By addCandidateButton = By.xpath("(//button[normalize-space()='Add'])[1]");

    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void accessToAddCandidate(){
        WebElement addButton = driver.findElement(addCandidateButton);
        addButton.click();
    }

}
