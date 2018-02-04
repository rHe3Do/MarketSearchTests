package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ExtendedFilterPage extends BasePage {

    /**
     * Поле для указания минимальной стоимости
     */
    @FindBy(xpath = "//input[contains(@name, 'pricefrom')]")
    WebElement minPriceSearch;

    /**
     * Кнопка Показать всё на случай, если производителей нет в отображаемом списке
     */
    @FindBy(xpath = "//button[@role=\"button\"]//span[@class=\"button__text\"][contains(text(), 'Показать всё')]")
    WebElement showAllBtn;

    /**
     * Кнопка перехода к результатам поиска с установленными фильтрами
     */
    @FindBy(xpath = "//a[@role=\"button\"][span='Показать подходящие']")
    WebElement showResultsBtn;

    public ExtendedFilterPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    /** Указание минимальной стоимости
     *
     * @param price принимает число в виде String и вносит в поле минимальной стоимости диапазона поиска
     *              допустимый ввод - целое число
     */
    public void setMinPriceSearch(String price) {
        fillField(minPriceSearch, price);
    }

    /**
     * Установка фильтра по производителю
     * @param manufacturer принимает на вход название компании-производителя, компания должна присутствовать
     *                     в списке на веб-странице и иметь товар, подходящий под остальные установленные
     *                     условия поиска
     */
    public void setFilter(String... manufacturer) {
        waitAndClick(showAllBtn);
        for (String man: manufacturer) {
            try {
                waitAndClick(BaseSteps.getDriver().findElement
                        (By.xpath("//span[contains(@class, 'checkbox')][label='" + man + "']")));
            } catch (Exception e) {
                throw new AssertionError("Производитель" + manufacturer +
                        "не доступен для выбора, либо не представлен в списке");
            }
        }
    }

    /**
     * Нажатие на кнопку Показать результат
     */
    public void clickShowResultsBtn(){
        waitAndClick(showResultsBtn);
    }

}
