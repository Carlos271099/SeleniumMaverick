package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.pages.AddCandidatePage;
import org.example.pages.DashboardMainPage;
import org.example.pages.LoginPage;
import org.example.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class AppTest
{

    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;

    @BeforeTest
    public void setUp(){
        extent = new ExtentReports();
        //Reporte se generara en el disco local c y creara una carpeta llamada pruebas dentro el archivo html
        spark = new ExtentSparkReporter("C://Pruebas//test.html");
        extent.attachReporter(spark);


    }


    @Test
    public void AppTest() throws InterruptedException {
        test = extent.createTest("Test de Agregar Candidato");
        test.info("Agregar nuevo candidato al modulo de reclutamiento");
        test.assignAuthor("Carlos Hexaware");


        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        test.log(Status.INFO, "Accedio Correctamente a la url");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginPage loginPage = new LoginPage(driver);
        DashboardMainPage mainPage = new DashboardMainPage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        AddCandidatePage addCandidatePage = new AddCandidatePage(driver);

        loginPage.logIn("Admin", "admin123");
        test.log(Status.INFO, "Login Exitoso.");


        mainPage.accessRecruitmentModule();
        test.log(Status.INFO, "Acceso a Modulo de Reclutamiento Exitoso");
        recruitmentPage.accessToAddCandidate();
        test.log(Status.INFO, "Acceso a Modulo de Agregar Candidato Exitoso");
        addCandidatePage.addCandidate("Carlos","Alexis","Muniz",
                "re2710@hotmail.com","8441138397","Software Engineer");
        test.log(Status.INFO, "Candidato Agregado.");



    Thread.sleep(3000);
        driver.quit();
    }

    @AfterTest
    public void tearDown(){
        test.log(Status.INFO, "Test Terminado :D");
        extent.flush();
    }

}
