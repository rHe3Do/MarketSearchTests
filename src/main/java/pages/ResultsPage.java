package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class ResultsPage extends BasePage {

    public String elementTitle;

    @FindBy(xpath = "//div[contains(@class, 'n-snippet')]/div[contains(@class, 'title')]")
    private List<WebElement> shownTargets;

    @FindBy(xpath = "//input[@id=\"header-search\"]")
    WebElement searchField;

    @FindBy(xpath = "//button[span='Найти']")
    WebElement searchBtn;

    @FindBy(xpath = "//h1[@class='title title_size_28 title_bold_yes']")
    WebElement newSearchRes;

    public ResultsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkElemetsAmount(Integer amount) {
        Assert.assertTrue("Ожидаемое количество элементов - %d " +
                        "\n Фактическое количество элементов - %d",
                amount.equals(shownTargets.size()));
    }

    public void getElementTitle(Integer number) {
        elementTitle = shownTargets.get(number+1).getText();
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
