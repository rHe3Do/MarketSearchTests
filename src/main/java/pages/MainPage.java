package pages;

import gherkin.lexer.No;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage {

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    /** Элемент для перехода в Яндекс.Маркет с главной страницы Яндекса **/
    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Маркет')]")
    WebElement market;

    /* Остальные пункты меню, для будущего расширения
    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Видео')]")
    WebElement video;


    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Картинки')]")
    WebElement images;

    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Новости')]")
    WebElement news;

    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Карты')]")
    WebElement maps;

    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Переводчик')]")
    WebElement translater;

    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Музыка')]")
    WebElement music;

    @FindBy(xpath = "//a[contains(@class, 'home-link')][contains(text(), 'Ещё')]")
    WebElement elseSub;
    */

    /** Переход в Яндекс.Маркет с главной страницы Яндекса,
     *  если не отображен элемент для перехода, получаем ошибку при выполнении **/
    public void goToCat(String category) throws NoSuchElementException{
        switch (category){
            case "Маркет":
                waitAndClick(market);
                break;
            default:
                throw new AssertionError("Кнопка '"+category+"' отсутствует на странице");
        }
    }
}
