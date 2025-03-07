package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.example.pages.AddCandidatePage;
import org.example.pages.DashboardMainPage;
import org.example.pages.LoginPage;
import org.example.pages.RecruitmentPage;
import org.example.utils.CreateObjectsFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class AppTest
{

    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;
    List<Candidate> candidates;

    @BeforeTest
    public void setUp(){
        extent = new ExtentReports();
        //Reporte se generara en el disco local c y creara una carpeta llamada pruebas dentro el archivo html
        spark = new ExtentSparkReporter("C://Pruebas//test.html");
        extent.attachReporter(spark);
        candidates = CreateObjectsFromExcel.createCandidates();

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-layout-context']")));

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/s.jpg");
        try{
            FileUtils.copyFile(srcFile, destFile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        test.log(Status.INFO, "Acceso a Modulo de Reclutamiento Exitoso",MediaEntityBuilder.createScreenCaptureFromPath(destFile.getAbsolutePath()).build());



        recruitmentPage.accessToAddCandidate();

        test.log(Status.INFO, "Acceso a Modulo de Agregar Candidato Exitoso");


        //Mandar objeto en vez de cada cosa
        addCandidatePage.addCandidate(candidates.get(0).getFirstName(),candidates.get(0).getMiddleName()
        ,candidates.get(0).getLastName(),candidates.get(0).getEmail(),candidates.get(0).getPhone(),candidates.get(0).getVacancy());

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
