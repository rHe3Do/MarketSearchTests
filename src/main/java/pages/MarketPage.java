package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MarketPage extends BasePage {

    /** Элемент для перехода в категорию Электроника **/
    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Электроника')]")
    WebElement electronikaCat;

    /* Остальные пункты меню, если будет необходимо
    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Компьютеры')]")
    WebElement computersCat;

    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Бытовая техника')]")
    WebElement domesticAppCat;

    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Детские товары')]")
    WebElement kidsGoodsCat;

    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Зоотовары')]")
    WebElement zooGoodsCat;

    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Дом')]")
    WebElement houseHoldCat;

    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Ещё')]")
    WebElement moreCat;
    */

    /** Элемент для перехода в подкатегорию Телевизоры **/
    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Телевизоры')]")
    WebElement tVsSub;

    /** Элемент для перехода в подкатегорию Наушники **/
    @FindBy(xpath = "//a[contains(@class, 'topmenu')][contains(text(), 'Наушники')]")
    WebElement headphonesSub;

    /** Элемент для перехода в расширенный поиск **/
    @FindBy(xpath = "//a[contains(@class, 'link i-bem')][contains(text(), 'Перейти ко всем фильтрам')]")
    WebElement extendedSearch;

    public MarketPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    /** Переход в выбранную пользователем подкатегорию **/
    public void chooseCat(String submenu){
        Actions actions = this.actions.moveToElement(electronikaCat);
        switch (submenu){
            case "Телевизоры":
                waitAndClick(tVsSub);
                break;
            case "Наушники":
                waitAndClick(headphonesSub);
                break;
            default:
                throw new AssertionError("Кнопка '"+submenu+"' отсутствует на странице");
        }
    }

    /** Переход в расширенный поиск **/
    public void goToExtSearch(){
        waitAndClick(extendedSearch);
    }

}
