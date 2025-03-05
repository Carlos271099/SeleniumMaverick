package org.example;

import org.example.pages.AddCandidatePage;
import org.example.pages.DashboardMainPage;
import org.example.pages.LoginPage;
import org.example.pages.RecruitmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;


public class AppTest
{

    @Test
    public void AppTest() {

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        LoginPage loginPage = new LoginPage(driver);
        DashboardMainPage mainPage = new DashboardMainPage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);

        loginPage.logIn("Admin", "admin123");



        mainPage.accessRecruitmentModule();
        recruitmentPage.accessToAddCandidate();
        addCandidatePage.addCandidate("Carlos","Alexis","Muniz",
                "re2710@hotmail.com","8441138397");

         By selects = By.className("oxd-select-text-input");

        //driver.quit();
    }

}
