import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    WebDriver driver = new ChromeDriver();
    private  final WebElement userName = driver.findElement(By.id("user-name"));
    private  final WebElement password = driver.findElement(By.name("password"));
    private  final WebElement loginButton = driver.findElement(By.className("submit-button"));
    private final WebElement listOfUserName = driver.findElement(By.tagName("h4"));
    private  final WebElement linkText = driver.findElement(By.linkText("All Items"));
    private  final WebElement partLinkText = driver.findElement(By.partialLinkText("All"));
    private  final WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']"));
    private  final WebElement productName = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
    private  final WebElement productNamePart = driver.findElement(By.xpath("//*[contains(text(),'Backpack')]"));
    private  final WebElement productList = driver.findElement(By.xpath("//*[contains(@data-test,'list')]"));
    private  final WebElement cssByTag = driver.findElement(By.cssSelector("input"));
    private  final WebElement cssByClass = driver.findElement(By.cssSelector("input.class"));

    //*[@class='login_wrapper-inner']//descendant::div -- Выбирает всех потомков
    //*[@class='login_wrapper-inner']//parent::div -- выбрать элемент, являющийся прямым родительским
    //*[text()='Test']//ancestor::div -- Выбирает всех предков
    //input[@id='password']/preceding::input[1] -- Выбирает все элементы выше указанного указанного уровня.
    //input[@id='password']/preceding-sibling::input[1] -- выбирает
    // только на том же уровне и перед указанным, т.е. любой элемент с тем же родителем и на том же уровне.
    //*[@class='login_wrapper-inner']/following-sibling::div --выбирает все элементы «братского», то есть того же уровня
    //*[@data-test='password' and contains(@id, 'password')] или //div[@class=('inventory','item')]
    //h4/text()
    //link/@href
    //img[@class = 'bm-icon']/@src

    /*cssSelector
    .inventory_item_desc
            .inventory_item .inventory_item_img -- ищет дочерний элемент
            #root - ищет по айди
            [data-test="header-container"]
            [data-test~=item] -- по частичному значению атрибута
            [data-test|=item] --поиск по начальному слову из атрибута
            [data-test$=item] --поиск по конечному слову из атрибута
            [data-test*=item] --поиск по частичному совпадению из атрибута

     */
}
