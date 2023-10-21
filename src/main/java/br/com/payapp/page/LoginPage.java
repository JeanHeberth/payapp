package br.com.payapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "cpf")
    private WebElement txtCpf;
    @FindBy(id = "botaocadastro")
    private WebElement btnEntrar;
    @FindBy(xpath = "//div[@class=\"titulo\"]")
    private WebElement mensagemDeCpfNaoCadastrado;

    @FindBy(xpath = "//button[@class=\"nota-button not5\"]")
    private WebElement btnCinco;
    public void realizarLogin(String usuario) {
        txtCpf.sendKeys(usuario);
        btnEntrar.click();
    }

    public boolean validarURL() {
        var URL = "https://payapp.space/avaliadordemarcas/php/logar.php";
        return true;
    }

    public String validarCpfNaoEncontrado() {
        mensagemDeCpfNaoCadastrado.getText();
        return "CPF NÃO CADASTRADO";
    }

    public void clicarNumeroCinco(){
        for (int i = 0; i < 100; i++){
            btnCinco.click();
            esperaCarregar();
        }
    }

    public void esperaCarregar() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"nota-button not5\"]")));

    }
}
