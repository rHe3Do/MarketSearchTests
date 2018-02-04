package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class ResultsPage extends BasePage {

    private String elementTitle;

    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2')]//div[contains(@class, 'card2__title')]")
    private List<WebElement> shownTargets;

    @FindBy(xpath = "//input[@id=\"header-search\"]")
    WebElement searchField;

    @FindBy(xpath = "//button[span='Найти']")
    WebElement searchBtn;

    @FindBy(xpath = "//h1[contains(@class, 'title')]")
    WebElement newSearchRes;

    public ResultsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkElemetsAmount(String amount) {
        Assert.assertEquals("Ожидаемое количество элементов - %s \n" +
                        "Фактическое количество элементов - %s",
                Integer.parseInt(amount), shownTargets.size());
    }

    public void getElementTitle(String number) {
        elementTitle = shownTargets.get(Integer.parseInt(number)).getText();
    }

    public void startNewSearch() {
        fillField(searchField, elementTitle);
        waitAndClick(searchBtn);
    }

    public void checkElementValue(){
        Assert.assertEquals("Ожидаемый результат поиска - %s \n" +
                        "Фактический результат поиска - %s",
                elementTitle, newSearchRes.getText());
    }
}
