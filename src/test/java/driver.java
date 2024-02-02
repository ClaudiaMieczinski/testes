
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class driver {

    public static void main(String[] args){
        System.setProperty("webdriver.chromedriver.driver" , "C:\\Drivers\\chromedriver117.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.drogariasaopaulo.com.br");
        driver.manage().window().maximize();

        WebElement botaoCookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        botaoCookies.click();
        WebElement caixaDeBusca = driver.findElement(By.cssSelector("#rnk-comp-header-form-busca-chaordic > fieldset > div > input"));
        caixaDeBusca.sendKeys("celular");
        WebElement botaoBusca = driver.findElement(By.cssSelector("#rnk-comp-header-form-busca-chaordic > fieldset > div > button > span:nth-child(2) > svg"));
        botaoBusca.click();
        WebElement resultadoPesquisa = driver.findElement(By.className("collection-link"));
        String resultado = resultadoPesquisa.getText();
        resultado = resultado.toLowerCase();

        if (resultado.contains("dipirona") || resultado.contains("maxalgina")){
        System.out.println("*** Sucesso ***");
        } else {
            System.out.println("*** Erro na Pesquisa ***");
            System.out.println("O resultado foi: " + resultado);
        }

        driver.close();

        }

}

