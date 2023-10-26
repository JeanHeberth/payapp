package br.com.payapp;

import br.com.payapp.core.DriveFactory;
import br.com.payapp.page.LoginPage;
import br.com.payapp.utils.SecretKey;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class RealizarLoginTest {

    private DriveFactory driveFactory = new DriveFactory();
    SecretKey secretKey = new SecretKey();

    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeMethod
    void beforeMethod(){
        driver = driveFactory.setUp();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    void afterMethod(){
        driveFactory.tearDown(driver);
    }

    @Test
    public void A_realizarLoginComDadosValidos(){
        loginPage.realizarLogin(secretKey.insereCPF());
        assertTrue(loginPage.validarURL());
        loginPage.clicarNumeroCinco();
    }
    @Test(invocationCount = 2)
    public void B_realizarLoginComDadosInvalidos(){
        loginPage.realizarLogin("222222222");
        assertEquals("CPF NÃO CADASTRADO", loginPage.validarCpfNaoEncontrado());
    }
}
